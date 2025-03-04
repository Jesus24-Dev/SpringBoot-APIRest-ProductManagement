package com.productmanagement.api_products.services;

import com.productmanagement.api_products.exceptions.OrderNotFoundException;
import com.productmanagement.api_products.models.Order;
import com.productmanagement.api_products.models.OrderProduct;
import com.productmanagement.api_products.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order [" + id + "] not found"));
    }

    @Transactional
    public Order createOrder(Order order) {
        double totalPrice = calculateTotalPrice(order);
        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }

    @Transactional
    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order [" + id + "] not found"));

        existingOrder.setCustomer(orderDetails.getCustomer());
        existingOrder.setOrderDate(orderDetails.getOrderDate());
        existingOrder.setProductStatus(orderDetails.getProductStatus());

        existingOrder.getOrderProducts().clear();
        existingOrder.getOrderProducts().addAll(orderDetails.getOrderProducts());

        double totalPrice = calculateTotalPrice(existingOrder);
        existingOrder.setTotalPrice(totalPrice);

        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order [" + id + "] not found"));

        orderRepository.delete(existingOrder);
    }

    private double calculateTotalPrice(Order order) {
        double totalPrice = 0.0;

        for (OrderProduct orderProduct : order.getOrderProducts()) {
            double productPrice = orderProduct.getProduct().getPrice();
            int quantity = orderProduct.getQuantity();
            totalPrice += productPrice * quantity;
        }

        return totalPrice;
    }
}
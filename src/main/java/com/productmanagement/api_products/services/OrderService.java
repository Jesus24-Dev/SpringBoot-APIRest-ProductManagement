package com.productmanagement.api_products.services;

import com.productmanagement.api_products.dtos.OrderDTO;
import com.productmanagement.api_products.exceptions.OrderNotFoundException;
import com.productmanagement.api_products.models.Order;
import com.productmanagement.api_products.models.OrderProduct;
import com.productmanagement.api_products.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductService productService;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order [" + id + "] not found"));
    }

    @Transactional
    public Order createOrder(Order order) {
        OrderDTO orderDTO = new OrderDTO(order);
        double totalPrice = calculateTotalPrice(orderDTO);
        order.setTotalPrice(totalPrice);
        return orderRepository.save(order);
    }

    @Transactional
    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order [" + id + "] not found"));

        existingOrder.setProductStatus(orderDetails.getProductStatus());
        existingOrder.getOrderProducts().clear();
        existingOrder.getOrderProducts().addAll(orderDetails.getOrderProducts());

        
        OrderDTO orderDTO = new OrderDTO(existingOrder);
        double totalPrice = calculateTotalPrice(orderDTO);
        existingOrder.setTotalPrice(totalPrice);

        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order [" + id + "] not found"));

        orderRepository.delete(existingOrder);
    }

   private double calculateTotalPrice(OrderDTO orderDTO) {
    return orderDTO.getOrderProducts().stream()
            .mapToDouble(op -> op.getProductPrice() * op.getQuantity()) // Usamos los datos del DTO
            .sum();
    }

}
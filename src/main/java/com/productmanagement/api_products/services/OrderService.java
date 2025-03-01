
package com.productmanagement.api_products.services;

import com.productmanagement.api_products.exceptions.OrderNotFoundException;
import com.productmanagement.api_products.models.Order;
import com.productmanagement.api_products.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public Order getOrderById(Long id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order [" + id + "] not found"));
    }
    public void createOrder(Order order){
        orderRepository.save(order);
    }
    public void updateOrder(Long id, Order orderDetails){
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order [" + id + "] not found"));
        
        existingOrder.setCustomer(orderDetails.getCustomer());
        existingOrder.setOrderDate(orderDetails.getOrderDate());
        existingOrder.setOrderProducts(orderDetails.getOrderProducts());
        existingOrder.setProductStatus(orderDetails.getProductStatus());
        existingOrder.setTotalPrice(orderDetails.getTotalPrice());  
        
        orderRepository.save(existingOrder);
    }
    public void deleteOrder(Long id){
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order [" + id + "] not found"));
        
        orderRepository.delete(existingOrder);
    }
}

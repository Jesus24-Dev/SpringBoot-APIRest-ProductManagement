
package products.productmanagement.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products.productmanagement.enums.OrderStatus;
import products.productmanagement.models.Order;
import products.productmanagement.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    @Transactional
    public Order createOrder(Order order){
        if (order.getUser() == null || order.getUser().getId() == null) {
        throw new IllegalArgumentException("Order must have a user");
        }
        if (order.getProducts() == null || order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one product");
        }
        return orderRepository.save(order);
    }
    
    public Order getOrderById(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        
        return order;
    }
    
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    
    @Transactional
    public Order updateOrder(Long id, Order order){
        Order existingOrder = getOrderById(id);
        if (order.getStatus() != null) {
            existingOrder.setStatus(order.getStatus());
        }
        existingOrder.setOrderDate(order.getOrderDate());

        return orderRepository.save(existingOrder);
    }
    
    @Transactional
    public void deleteOrder(Long id) {
        Order order = getOrderById(id);
        if (order.getStatus() == OrderStatus.COMPLETE) {
            throw new IllegalStateException("Cannot delete a completed order");
        }
        orderRepository.delete(order);
    }
}

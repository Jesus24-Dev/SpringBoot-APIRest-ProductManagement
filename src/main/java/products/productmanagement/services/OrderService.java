
package products.productmanagement.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products.productmanagement.dtos.request.OrderRequest;
import products.productmanagement.dtos.response.OrderResponse;
import products.productmanagement.enums.OrderStatus;
import products.productmanagement.models.Order;
import products.productmanagement.models.Product;
import products.productmanagement.models.User;
import products.productmanagement.repository.OrderRepository;
import products.productmanagement.repository.ProductRepository;
import products.productmanagement.repository.UserRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public OrderResponse createOrder(OrderRequest request) {
        if (request.getUserId() == null) {
            throw new IllegalArgumentException("User ID is required");
        }
        if (request.getProductIds() == null || request.getProductIds().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one product");
        }

        User user = userRepository.findById(request.getUserId())
            .orElseThrow(() -> new EntityNotFoundException("User not found"));
        List<Product> products = productRepository.findAllById(request.getProductIds());

        Order order = new Order();
        order.setUser(user);
        order.setProducts(products);
        order.setStatus(request.getStatus() != null ? request.getStatus() : OrderStatus.PENDING);
        order.setOrderDate(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);
        return new OrderResponse(savedOrder);
    }

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        return new OrderResponse(order);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
            .map(OrderResponse::new)
            .toList();
    }

    @Transactional
    public OrderResponse updateOrderStatus(Long id, OrderStatus newStatus) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        if (newStatus != null) {
            order.setStatus(newStatus);
        }

        Order updatedOrder = orderRepository.save(order);
        return new OrderResponse(updatedOrder);
    }

    @Transactional
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        if (order.getStatus() == OrderStatus.COMPLETE) {
            throw new IllegalStateException("Cannot delete a completed order");
        }

        orderRepository.delete(order);
    }
}

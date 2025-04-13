
package products.productmanagement.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import products.productmanagement.models.Order;
import products.productmanagement.services.OrderService;

@RestController
@RequestMapping("/api/categories")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        Order orderCreated = orderService.createOrder(order);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(orderCreated);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        Order orderFounded = orderService.getOrderById(id);
        
        return ResponseEntity.ok(orderFounded);
    }
    
    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        
        return ResponseEntity.ok(orders);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order){
        Order orderUpdated = orderService.updateOrder(id, order);
        
        return ResponseEntity.ok(orderUpdated);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}


package com.productmanagement.api_products.controllers;

import com.productmanagement.api_products.models.OrderProduct;
import com.productmanagement.api_products.services.OrderProductService;
import jakarta.validation.Valid;
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

@RestController
@RequestMapping("/api/order-products")
public class OrderProductController {
    @Autowired
    private OrderProductService orderProductService;
    
    @GetMapping
    public ResponseEntity<List<OrderProduct>> getAllOrderProducts() {
        List<OrderProduct> orderProducts = orderProductService.getAllOrdersProducts();
        return ResponseEntity.ok(orderProducts);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<OrderProduct> getOrderProductById(@PathVariable Long id) {
        OrderProduct orderProduct = orderProductService.getOrderProductById(id);
        return ResponseEntity.ok(orderProduct);
    }

    @PostMapping
    public ResponseEntity<OrderProduct> createOrderProduct(@Valid @RequestBody OrderProduct orderProduct) {      
        OrderProduct createdOrderProduct = orderProductService.createOrderProduct(orderProduct);
        return new ResponseEntity<>(createdOrderProduct, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<OrderProduct> updateOrderProduct(@Valid @PathVariable Long id, @RequestBody OrderProduct orderProductDetails) {
        OrderProduct updatedOrderProduct = orderProductService.updateOrderProduct(id, orderProductDetails);
        return ResponseEntity.ok(updatedOrderProduct);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderProduct(@PathVariable Long id) {
        orderProductService.deleteOrderProduct(id);
        return ResponseEntity.noContent().build();
    }
}

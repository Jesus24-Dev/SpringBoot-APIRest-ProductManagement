
package com.productmanagement.api_products.controllers;

import com.productmanagement.api_products.exceptions.ProductNotFoundException;
import com.productmanagement.api_products.models.Product;
import com.productmanagement.api_products.services.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<Product> getAllProducts(){
        try {
            return productService.getAllProducts();
        } catch(Exception e) {
            throw new RuntimeException("Error fetching products", e);
        }       
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product [" + id + "] not found"));
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody Product product){
        productService.createProduct(product);
        return ResponseEntity.ok("User created");           
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@Valid @PathVariable Long id, @RequestBody Product productDetails){
        Product product = productService.getProductById(id)
            .orElseThrow(() -> new ProductNotFoundException("Product [" + id + "] not found"));
        productService.updateProduct(product.getId(), productDetails);
        return ResponseEntity.ok("User updated");             
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        Product product = productService.getProductById(id)
            .orElseThrow(() -> new ProductNotFoundException("Product [" + id + "] not found"));
        productService.deleteProduct(product.getId());
        return ResponseEntity.ok("Product deleted");
    }
}

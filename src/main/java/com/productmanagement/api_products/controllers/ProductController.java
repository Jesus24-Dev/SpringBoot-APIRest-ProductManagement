
package com.productmanagement.api_products.controllers;

import com.productmanagement.api_products.models.Product;
import com.productmanagement.api_products.services.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
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
        return productService.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    
    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody Product product){
        productService.createProduct(product);
        return ResponseEntity.ok("User created");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@Valid @PathVariable Long id, @RequestBody Product productDetails){
        productService.updateProduct(id, productDetails);
        return ResponseEntity.ok("User updated");
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}

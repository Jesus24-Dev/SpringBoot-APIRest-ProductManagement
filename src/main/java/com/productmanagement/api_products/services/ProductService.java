
package com.productmanagement.api_products.services;

import com.productmanagement.api_products.exceptions.ProductNotFoundException;
import com.productmanagement.api_products.models.Product;
import com.productmanagement.api_products.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product [" + id + "] not found"));
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Long id, Product productDetails) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product [" + id + "] not found"));
        
        existingProduct.setName(productDetails.getName());
        existingProduct.setPrice(productDetails.getPrice());
        
        productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product [" + id + "] not found"));
        
        productRepository.delete(existingProduct);
    }
}


package com.productmanagement.api_products.services;

import com.productmanagement.api_products.models.Product;
import com.productmanagement.api_products.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }
    
    public Product createProduct(Product product){
        return productRepository.save(product);
    }
    
    public Product updateProduct(Long id, Product productDetails){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not Found"));
        
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        
        return productRepository.save(product);
    }
    
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}

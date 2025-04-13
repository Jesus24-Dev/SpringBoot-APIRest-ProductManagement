package products.productmanagement.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products.productmanagement.models.Category;
import products.productmanagement.models.Product;
import products.productmanagement.repository.CategoryRepository;
import products.productmanagement.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Transactional
    public Product createProduct(Product product){
        if (product.getCategory() == null || product.getCategory().getId() == null) {
            throw new EntityNotFoundException("Category ID is required");
        }
        Category category = categoryRepository.findById(product.getCategory().getId())
            .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        product.setCategory(category);
        return productRepository.save(product);
    }
    
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    
    public Product getProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        
        return product;
    }
    
    @Transactional
    public Product updateProduct(Long id, Product product){
        Product productFounded = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        Category category = categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        
        productFounded.setName(product.getName());
        productFounded.setPrice(product.getPrice());
        productFounded.setStock(product.getStock());
        productFounded.setDescription(product.getDescription());
        productFounded.setCategory(category);
        
        return productRepository.save(productFounded);
    }
    
    @Transactional
    public void deleteProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        
        productRepository.delete(product);
    }
    
}

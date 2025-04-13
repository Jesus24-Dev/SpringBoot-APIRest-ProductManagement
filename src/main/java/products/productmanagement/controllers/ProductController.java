
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
import products.productmanagement.models.Product;
import products.productmanagement.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product productCreated = productService.createProduct(product);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(productCreated);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product productFounded = productService.getProductById(id);
        
        return ResponseEntity.ok(productFounded);
    }
    
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        
        return ResponseEntity.ok(products);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product productUpdated = productService.updateProduct(id, product);
        
        return ResponseEntity.ok(productUpdated);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

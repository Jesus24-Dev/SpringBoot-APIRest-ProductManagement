
package products.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import products.productmanagement.models.Product;

public interface ProductRepository extends JpaRepository<Long, Product>{
    
}

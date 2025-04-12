
package products.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import products.productmanagement.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}

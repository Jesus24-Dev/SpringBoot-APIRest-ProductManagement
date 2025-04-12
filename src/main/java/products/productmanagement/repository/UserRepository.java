
package products.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import products.productmanagement.models.User;

public interface UserRepository extends JpaRepository<Long, User>{
    
}

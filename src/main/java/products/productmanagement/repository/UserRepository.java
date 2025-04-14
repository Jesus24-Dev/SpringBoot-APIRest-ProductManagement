
package products.productmanagement.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import products.productmanagement.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}


package products.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import products.productmanagement.models.Order;

public interface OrderRepository extends JpaRepository<Long, Order>{
    
}


package com.productmanagement.api_products.repository;

import com.productmanagement.api_products.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}

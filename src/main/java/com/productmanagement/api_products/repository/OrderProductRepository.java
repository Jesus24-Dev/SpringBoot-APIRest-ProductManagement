
package com.productmanagement.api_products.repository;

import com.productmanagement.api_products.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long>{
    
}

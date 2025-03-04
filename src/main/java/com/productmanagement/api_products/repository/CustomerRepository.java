
package com.productmanagement.api_products.repository;

import com.productmanagement.api_products.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}

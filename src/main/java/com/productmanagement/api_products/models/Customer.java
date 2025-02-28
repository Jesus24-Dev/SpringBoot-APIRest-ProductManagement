
package com.productmanagement.api_products.models;

import com.productmanagement.api_products.utils.CustomerRoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name can't be empty")
    private String name;

    @NotBlank(message = "Password can't be empty")
    private String password;

    private CustomerRoleEnum.Role role;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Customer() {
        this.role = CustomerRoleEnum.Role.CUSTOMER; 
    }

    public Customer(String name, String password) {
        this.name = name;
        this.password = passwordEncoder.encode(password); 
        this.role = CustomerRoleEnum.Role.CUSTOMER;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = passwordEncoder.encode(password); 
    }

    public CustomerRoleEnum.Role getRole() {
        return role;
    }

    public void setRole(CustomerRoleEnum.Role role) {
        this.role = role;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}

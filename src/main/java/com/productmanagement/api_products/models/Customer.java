
package com.productmanagement.api_products.models;

import com.productmanagement.api_products.utils.CustomerRoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name can't be empty")
    private String name;

    @NotBlank(message = "Password can't be empty")
    private String password;

    @Enumerated(EnumType.STRING)
    private CustomerRoleEnum.Role role;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    public Customer() {
        this.role = CustomerRoleEnum.Role.CUSTOMER; 
    }

    public Customer(String name, String password, List<Order> orders) {
        this.name = name;
        this.password = password; 
        this.role = CustomerRoleEnum.Role.CUSTOMER;
        this.orders = orders;
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
        this.password = password; 
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

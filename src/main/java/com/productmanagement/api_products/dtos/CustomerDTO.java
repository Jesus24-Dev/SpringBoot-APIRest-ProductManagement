
package com.productmanagement.api_products.dtos;

import com.productmanagement.api_products.models.Customer;
import com.productmanagement.api_products.utils.CustomerRoleEnum;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerDTO {
    private Long id;
    private String name;
    private CustomerRoleEnum.Role role;
    private List<OrderDTO> orders;
    
    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.role = customer.getRole();
        this.orders = customer.getOrders()
                                .stream()
                                .map(OrderDTO::new)
                                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerRoleEnum.Role getRole() {
        return role;
    }

    public void setRole(CustomerRoleEnum.Role role) {
        this.role = role;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
       
}

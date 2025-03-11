
package com.productmanagement.api_products.dtos;

import com.productmanagement.api_products.models.Order;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {
    private Long id;
    private Long customerId;
    private LocalDate orderDate;
    private double totalPrice;
    private List<OrderProductDTO> orderProducts;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.customerId = order.getCustomer().getId();
        this.orderDate = order.getOrderDate();
        this.totalPrice = order.getTotalPrice();
        this.orderProducts = order.getOrderProducts()
                                 .stream()
                                 .map(OrderProductDTO::new)
                                 .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }      

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderProductDTO> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductDTO> orderProducts) {
        this.orderProducts = orderProducts;
    }
     
}

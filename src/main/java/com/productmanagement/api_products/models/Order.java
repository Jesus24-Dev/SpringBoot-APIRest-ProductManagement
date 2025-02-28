
package com.productmanagement.api_products.models;

import com.productmanagement.api_products.utils.ProductStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull(message = "Customer id can't be empty")
    private Customer customer;

    @PastOrPresent
    @NotNull(message = "Order date can't be empty")
    private LocalDate orderDate;

    @Min(value = 0, message = "Total price must be at least 0")
    private Double totalPrice;

    @NotNull(message = "Product Status can't be empty")
    @Enumerated(EnumType.STRING)
    private ProductStatusEnum.ProductStatus productStatus;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Order() {
        this.productStatus = ProductStatusEnum.ProductStatus.PENDING;
    }

    public Order(Customer customer, LocalDate orderDate, Double totalPrice, 
                 ProductStatusEnum.ProductStatus productStatus) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.productStatus = productStatus != null ? productStatus : ProductStatusEnum.ProductStatus.PENDING;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ProductStatusEnum.ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatusEnum.ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}

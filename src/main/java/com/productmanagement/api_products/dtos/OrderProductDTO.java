
package com.productmanagement.api_products.dtos;

import com.productmanagement.api_products.models.OrderProduct;

public class OrderProductDTO {
    private Long id;
    private int quantity;
    private Long productId;  
    private String productName;
    private Double productPrice;

    public OrderProductDTO(OrderProduct orderProduct) {
        this.id = orderProduct.getId();
        this.quantity = orderProduct.getQuantity();
        this.productId = orderProduct.getProduct().getId();
        this.productName = orderProduct.getProduct().getName();
        this.productPrice = orderProduct.getProduct().getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    
}


package com.productmanagement.api_products.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    @NotBlank(message = "Name can't be empty")
    @Size(max = 50, message = "Name can't be longer than 50 characters")
    private String name;
    
    @Min(value = 0, message = "Price must be at least 0")
    private Double price;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @NotBlank(message = "Category can't be empty")
    private Category category;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Min(value = 0, message = "Count must be at least 0")
    private int count;
    
    public Product() {
    }

    public Product(String name, Double price, Category category, int count) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.count = count;
    }
         
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
       
}


package products.productmanagement.dtos.response;

import java.time.LocalDateTime;
import products.productmanagement.models.Product;

public class ProductResponse {
    
    private final Long id;
    private final String name;
    private final String description;
    private final float price;
    private final int stock;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final CategoryResponse category;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.createdAt = product.getCreatedAt();
        this.updatedAt = product.getUpdatedAt();
        this.category = new CategoryResponse(product.getCategory());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updatedAt;
    }

    public CategoryResponse getCategory() {
        return category;
    }
    
    
}

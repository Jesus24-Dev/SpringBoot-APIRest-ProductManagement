
package products.productmanagement.dtos.response;

import java.time.LocalDateTime;
import products.productmanagement.models.Category;

public class CategoryResponse {
    private final Long id;
    private final String name;
    private final LocalDateTime updatedAt;
    private final LocalDateTime createdAt;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.updatedAt = category.getUpdatedAt();
        this.createdAt = category.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getUpdatedAd() {
        return updatedAt;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    
}

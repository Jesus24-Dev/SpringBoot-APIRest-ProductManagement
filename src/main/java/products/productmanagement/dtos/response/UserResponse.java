
package products.productmanagement.dtos.response;

import java.time.LocalDateTime;
import products.productmanagement.enums.Role;
import products.productmanagement.models.User;

public class UserResponse {
    private final Long id;
    private final String username;
    private final Role role;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    
    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
  
}

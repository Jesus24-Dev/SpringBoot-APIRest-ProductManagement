
package products.productmanagement.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import products.productmanagement.enums.Role;

public class UserRequest {
    
    @NotBlank(message = "The username is required")
    private String username;
    
    @NotBlank(message = "The password is required")
    private String password;
    
    @NotNull(message = "The User Role is required")
    private Role role; 

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}

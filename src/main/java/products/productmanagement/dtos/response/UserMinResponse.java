
package products.productmanagement.dtos.response;

import products.productmanagement.models.User;

public class UserMinResponse {
    private final Long id;
    private final String username;

    public UserMinResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
}

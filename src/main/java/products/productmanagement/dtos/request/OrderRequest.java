
package products.productmanagement.dtos.request;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import products.productmanagement.enums.OrderStatus;

public class OrderRequest {
    private Long userId; 
    
    @NotNull(message = "The products are required")
    private List<Long> productIds; 
    
    @NotNull(message = "The order status is required")
    private OrderStatus status; 

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    
    
}


package products.productmanagement.dtos.request;

import java.util.List;
import products.productmanagement.enums.OrderStatus;

public class OrderRequest {
    private Long userId; 
    private List<Long> productIds; 
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

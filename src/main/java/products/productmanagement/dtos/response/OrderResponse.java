
package products.productmanagement.dtos.response;

import java.time.LocalDateTime;
import java.util.List;
import products.productmanagement.enums.OrderStatus;
import products.productmanagement.models.Order;

public class OrderResponse {
    private final Long id;
    private final LocalDateTime orderDate;
    private final OrderStatus status;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final UserMinResponse user; 
    private final List<ProductMinResponse> products; 

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.orderDate = order.getOrderDate();
        this.status = order.getStatus();
        this.createdAt = order.getCreatedAt();
        this.updatedAt = order.getUpdatedAt();
        this.user = new UserMinResponse(order.getUser());
        this.products = order.getProducts().stream()
                .map(ProductMinResponse::new)
                .toList();
    }
}

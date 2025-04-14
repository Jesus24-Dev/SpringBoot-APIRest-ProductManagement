
package products.productmanagement.dtos.response;

import products.productmanagement.models.Product;

public class ProductMinResponse {
    private final Long id;
    private final String name;
    private final float price;

    public ProductMinResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    } 

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
       
}

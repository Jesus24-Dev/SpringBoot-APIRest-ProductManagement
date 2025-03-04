
package com.productmanagement.api_products.services;

import com.productmanagement.api_products.exceptions.OrderProductNotFoundException;
import com.productmanagement.api_products.models.OrderProduct;
import com.productmanagement.api_products.repository.OrderProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {
    
    @Autowired
    private OrderProductRepository orderProductRepository;
    
    public List<OrderProduct> getAllOrdersProducts(){
        return orderProductRepository.findAll();
    }
    public OrderProduct getOrderProductById(Long id){
        return orderProductRepository.findById(id)
                .orElseThrow(() -> new OrderProductNotFoundException("Order Products [" + id + "] not found"));
    }
    public void createOrderProduct(OrderProduct orderProduct){
        orderProductRepository.save(orderProduct);
    }
    public void updateOrderProduct(Long id, OrderProduct orderProductDetails){
        OrderProduct existingOrderProduct = orderProductRepository.findById(id)
                .orElseThrow(() -> new OrderProductNotFoundException("Order Products [" + id + "] not found"));
        
        existingOrderProduct.setOrder(orderProductDetails.getOrder());
        existingOrderProduct.setProduct(orderProductDetails.getProduct());
        existingOrderProduct.setQuantity(orderProductDetails.getQuantity());
    }
    public void deleteOrderProduct(Long id){
        OrderProduct existingOrderProduct = orderProductRepository.findById(id)
                .orElseThrow(() -> new OrderProductNotFoundException("Order Products [" + id + "] not found"));
        
        orderProductRepository.delete(existingOrderProduct);
    }
    
}


package com.productmanagement.api_products.services;

import com.productmanagement.api_products.exceptions.OrderProductNotFoundException;
import com.productmanagement.api_products.models.OrderProduct;
import com.productmanagement.api_products.repository.OrderProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    public List<OrderProduct> getAllOrdersProducts() {
        return orderProductRepository.findAll();
    }

    public OrderProduct getOrderProductById(Long id) {
        return orderProductRepository.findById(id)
                .orElseThrow(() -> new OrderProductNotFoundException("Order Products [" + id + "] not found"));
    }

    @Transactional
    public OrderProduct createOrderProduct(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

    @Transactional
    public OrderProduct updateOrderProduct(Long id, OrderProduct orderProductDetails) {
        OrderProduct existingOrderProduct = orderProductRepository.findById(id)
                .orElseThrow(() -> new OrderProductNotFoundException("Order Products [" + id + "] not found"));

        existingOrderProduct.setQuantity(orderProductDetails.getQuantity());
        return orderProductRepository.save(existingOrderProduct);
    }

    @Transactional
    public void deleteOrderProduct(Long id) {
        OrderProduct existingOrderProduct = orderProductRepository.findById(id)
                .orElseThrow(() -> new OrderProductNotFoundException("Order Products [" + id + "] not found"));

        orderProductRepository.delete(existingOrderProduct);
    }
    
}

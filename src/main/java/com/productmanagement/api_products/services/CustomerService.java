
package com.productmanagement.api_products.services;

import com.productmanagement.api_products.exceptions.CustomerNotFoundException;
import com.productmanagement.api_products.models.Customer;
import com.productmanagement.api_products.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer [" + id + "] not found"));
    }
    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }
    public void updateCustomer(Long id, Customer customerDetails){
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer [" + id + "] not found"));
        
        existingCustomer.setName(customerDetails.getName());
        existingCustomer.setPassword(customerDetails.getPassword());
        
        customerRepository.save(existingCustomer);
    }
    public void deleteCustomer(Long id){
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer [" + id + "] not found"));
        
        customerRepository.delete(existingCustomer);
    }
}

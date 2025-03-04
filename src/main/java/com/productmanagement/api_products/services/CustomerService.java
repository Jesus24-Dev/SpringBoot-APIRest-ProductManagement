
package com.productmanagement.api_products.services;

import com.productmanagement.api_products.exceptions.CustomerNotFoundException;
import com.productmanagement.api_products.models.Customer;
import com.productmanagement.api_products.repository.CustomerRepository;
import com.productmanagement.api_products.utils.CustomerRoleEnum;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer [" + id + "] not found"));
    }

    @Transactional
    public Customer createCustomer(Customer customer) {
        customer.setRole(CustomerRoleEnum.Role.CUSTOMER);
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer [" + id + "] not found"));

        existingCustomer.setName(customerDetails.getName());
        existingCustomer.setPassword(customerDetails.getPassword());
        return customerRepository.save(existingCustomer);
    }

    @Transactional
    public void deleteCustomer(Long id) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer [" + id + "] not found"));

        customerRepository.delete(existingCustomer);
    }
}

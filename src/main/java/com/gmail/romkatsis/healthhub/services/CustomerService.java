package com.gmail.romkatsis.healthhub.services;

import com.gmail.romkatsis.healthhub.exceptions.UserNotFoundException;
import com.gmail.romkatsis.healthhub.models.Customer;
import com.gmail.romkatsis.healthhub.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findCustomers() {
        return customerRepository.findAll();
    }

    public Customer findCustomerById(int id) {
        return customerRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Transactional
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}

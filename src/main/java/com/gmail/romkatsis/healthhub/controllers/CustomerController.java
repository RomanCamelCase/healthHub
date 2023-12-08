package com.gmail.romkatsis.healthhub.controllers;

import com.gmail.romkatsis.healthhub.models.Customer;
import com.gmail.romkatsis.healthhub.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.findCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping
    public ResponseEntity<Object> addCustomer(@RequestBody @Valid Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.ok().build();
    }
}

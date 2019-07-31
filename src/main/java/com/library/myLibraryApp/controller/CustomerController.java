package com.library.myLibraryApp.controller;

import com.library.myLibraryApp.repository.CustomerRepository;
import com.library.myLibraryApp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(path="/hi")
    private String Welcome(){
        return "hello";
    }

    @PostMapping(value = "/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        Customer aCustomer = customerRepository.save(new Customer(customer.getFirstName(), customer.getLastName()));
        return aCustomer;
    }
}

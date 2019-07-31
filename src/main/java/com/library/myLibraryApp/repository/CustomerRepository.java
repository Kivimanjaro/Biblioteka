package com.library.myLibraryApp.repository;

import com.library.myLibraryApp.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findCustomerById(long id);
}

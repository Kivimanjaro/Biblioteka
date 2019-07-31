package com.library.myLibraryApp.service;

import com.library.myLibraryApp.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public boolean isBookLimitReached(Customer aCustomer){
        if(aCustomer.getBooksRented() >= aCustomer.getBookLimit()){
            aCustomer.setBookLimitReached(true);
            return true;
        } else return false;
    }

}

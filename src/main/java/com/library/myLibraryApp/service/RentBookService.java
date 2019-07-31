package com.library.myLibraryApp.service;

import com.library.myLibraryApp.model.Book;
import com.library.myLibraryApp.model.Customer;
import com.library.myLibraryApp.model.RentBook;
import com.library.myLibraryApp.repository.BookRepository;
import com.library.myLibraryApp.repository.CustomerRepository;
import com.library.myLibraryApp.repository.RentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class RentBookService {

    @Autowired
    RentBookRepository rentBookRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerService customerService;


    public Optional<RentBook> rentBook(long bookId, long customerId){

        Customer customer = customerRepository.findCustomerById(customerId);
        Book book = bookRepository.findBookById(bookId);

        if(customer == null) {
            System.out.println("customer with id " + customerId + " not found");
            return Optional.empty();
        }
        else if(book == null){
            System.out.println("Book with id " + bookId + " not found");
            return Optional.empty();
        }
        else if(customerService.isBookLimitReached(customer)){
            System.out.println("Book limit reached! " + customer.getBookLimit() + " rented! ");
            return Optional.empty();
        }
        else if(book.isRented()){
            System.out.println("Book is rented at this moment. Sorry! ");
            return Optional.empty();
        }
        else {
            book.setRented(true);
            customer.setBooksRented(customer.getBooksRented()+1);
            RentBook aRentbook = rentBookRepository.save(new RentBook(book, customer));
            System.out.println("Book " + book.getTitle() + " rented successfully");

            return Optional.of(aRentbook);
        }
    }

    public List<RentBook> findOverdueBooks(){
        List<RentBook> rentBookList = rentBookRepository.findAll();
        List<RentBook> overdueBooksList = rentBookList.stream()
          .filter(rentBook -> rentBook.getDateDue().isBefore(LocalDateTime.now()))
          .collect(Collectors.toList());
        return overdueBooksList;
    }

}

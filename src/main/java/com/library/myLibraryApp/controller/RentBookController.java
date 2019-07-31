package com.library.myLibraryApp.controller;

import com.library.myLibraryApp.model.Customer;
import com.library.myLibraryApp.model.RentBook;
import com.library.myLibraryApp.repository.RentBookRepository;
import com.library.myLibraryApp.service.RentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rentBook")
public class RentBookController {

    @Autowired
    RentBookRepository rentBookRepository;

    @Autowired
    RentBookService rentBookService;

    @PostMapping(value = "/book")
    public Optional<RentBook> rentBook(@RequestParam(value = "customerId") long customerId,
                             @RequestParam(value = "bookId") long bookId ){
        return rentBookService.rentBook(bookId, customerId);
    }

    @GetMapping(value = "/update")
    public List<RentBook> rentBooks(){
        return rentBookService.findOverdueBooks();
    }

    @PutMapping(value = "/test")
    public List<RentBook> testMethod(){
        List<RentBook> rentBookList = rentBookRepository.findAll();
        List<RentBook> overdueBooksList = rentBookList.stream()
          .filter(rentBook -> rentBook.getDateDue().isBefore(LocalDateTime.now()))
          .collect(Collectors.toList());
        overdueBooksList.forEach(book -> book.setOverdue(true));
        rentBookRepository.saveAll(rentBookList);

        System.out.println(overdueBooksList);
        return overdueBooksList;
    }

}

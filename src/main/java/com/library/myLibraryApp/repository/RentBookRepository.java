package com.library.myLibraryApp.repository;

import com.library.myLibraryApp.model.RentBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentBookRepository extends CrudRepository<RentBook, Long> {

    RentBook findRentedBookById(long id);

    List<RentBook> findAll();

}

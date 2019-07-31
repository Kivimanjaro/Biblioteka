package com.library.myLibraryApp.repository;

import com.library.myLibraryApp.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String title);

    Book findBookById(long id);

    public List<Book> findByGenre(String bookGenre);
}

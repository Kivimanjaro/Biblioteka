package com.library.myLibraryApp.service;

import com.library.myLibraryApp.model.Book;
import com.library.myLibraryApp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        List<Book> aBooksList = (List)bookRepository.findAll();
        return aBooksList;
    }

    public List<Book> findBooksByTitle(String title){
        List<Book> aBookList = bookRepository.findByTitle(title);
        return aBookList;
    }

    public List<Book> findBooksByGenre(String genreName){
        List<Book> aBookList = bookRepository.findByGenre(genreName);
        return aBookList;
    }

    public Book addBook(Book book){
        Book aBook = bookRepository.save(new Book(book.getIsbn(), book.getAuthor(), book.getTitle(), book.getGenre()));
        return aBook;
    }

    public Book removeBook(long id){
        Book aBook = bookRepository.findBookById(id);
        bookRepository.delete(aBook);
        return aBook;
    }

    public Book findBookById(long id){
        Book aBook = bookRepository.findBookById(id);
        return aBook;
    }
}

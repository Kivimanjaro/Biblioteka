package com.library.myLibraryApp.controller;

import com.library.myLibraryApp.repository.BookRepository;
import com.library.myLibraryApp.model.Book;
import com.library.myLibraryApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable long id){
        return bookService.findBookById(id);
    }

    @GetMapping("{title}")
    public List<Book> findBooksByTitle(@PathVariable String title){
        return bookService.findBooksByTitle(title);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/removeBook/{id}")
    public Book removeBook(@PathVariable long id){
        return bookService.removeBook(id);
    }

    @GetMapping("/findBooksByGenre/{genre}")
    public List<Book> findBooksByGenre(@PathVariable String genre){
        return bookService.findBooksByGenre(genre);
    }


}

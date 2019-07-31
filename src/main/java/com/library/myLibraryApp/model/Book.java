package com.library.myLibraryApp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {


    public Book(String isbn, String author, String title, String genre) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.rented = rented;
        this.genre = genre;
    }

    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "rented")
    private boolean rented;

    @Column(name = "genre")
    private String genre;

    @OneToMany(mappedBy = "book")
    private List<RentBook> rentedBooks;

    public long getId() {
        return id;
    }

    public long getBookId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }


    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
          "id=" + id +
          ", isbn='" + isbn + '\'' +
          ", author='" + author + '\'' +
          ", title='" + title + '\'' +
          ", rented=" + rented +
          ", genre='" + genre + '\'' +
          '}';
    }
}

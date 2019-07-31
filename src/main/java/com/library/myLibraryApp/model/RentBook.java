package com.library.myLibraryApp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.library.myLibraryApp.repository.BookRepository;
import com.library.myLibraryApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "rent_book")
public class RentBook {

    public RentBook(Book book, Customer customer) {
        this.book = book;
        this.customer = customer;
        this.dateRented = LocalDateTime.now();
        this.dateDue = LocalDateTime.now().plusSeconds(1);
        this.overdue = false;
        this.returned = false;
    }

    public RentBook() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "date_rented")
    private LocalDateTime dateRented;

    @Column(name = "date_due")
    private LocalDateTime dateDue;

    @Column(name = "date_returned")
    private LocalDateTime dateReturned;

    @Column(name = "is_overdue")
    private boolean overdue;

    @Column(name = "is_returned")
    private boolean returned;

    public long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getDateRented() {
        return dateRented;
    }

    public LocalDateTime getDateDue() {
        return dateDue;
    }

    public LocalDateTime getDateReturned() {
        return dateReturned;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    @Override
    public String toString() {
        return "RentBook{" +
          "id=" + id +
          ", book.id=" + book.getBookId() +
          ", custome.id=" + customer.getId() +
          ", dateRented=" + dateRented +
          ", dateDue=" + dateDue +
          ", dateReturned=" + dateReturned +
          ", overdue=" + overdue +
          ", returned=" + returned +
          '}';
    }
}

package com.library.myLibraryApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.library.myLibraryApp.service.CustomerService;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.apache.tomcat.jni.Local;
import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = true;
        this.registrationDate = LocalDateTime.now();
        this.bookLimitReached = false;
        this.bookLimit = 3;
        this.booksRented = 0;
    }

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "active")
    private boolean active;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "book_limit_reached")
    private boolean bookLimitReached;

    @Column(name = "book_limit")
    private int bookLimit;

    @Column(name = "books_rented")
    private int booksRented;

    @OneToMany(mappedBy = "customer")
    private List<RentBook> rentedBooks;

    public long getId() {
        return id;
    }

    public int getBookLimit() {
        return bookLimit;
    }

    public void setBookLimit(int bookLimit) {
        this.bookLimit = bookLimit;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isBookLimitReached() {
        return bookLimitReached;
    }

    public void setBookLimitReached(boolean bookLimitReached) {
        this.bookLimitReached = bookLimitReached;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public int getBooksRented() {
        return booksRented;
    }

    public void setBooksRented(int booksRented) {
        this.booksRented = booksRented;
    }

    @Override
    public String toString() {
        return "Customer{" +
          "id=" + id +
          ", firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", active=" + active +
          ", registrationDate=" + registrationDate +
          ", bookLimitReached=" + bookLimitReached +
          ", bookLimit=" + bookLimit +
          '}';
    }
}

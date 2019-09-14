package com.company.DelcieDionU1M5Summative.dto;

/*
book_id int not null auto_increment primary key,
    isbn varchar (15) not null,
    publish_date date not null,
    author_id int not null,
    title varchar (70) not null,
    publisher_id int not null,
    price decimal(5,2) not null
 */

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Book {

    /*
    book_id int not null auto_increment primary key,
    isbn varchar (15) not null,
    publish_date date not null,
    author_id int not null,
    title varchar (70) not null,
    publisher_id int not null,
    price decimal(5,2) not null
     */

    private int id;
    private String isbn;
    private LocalDate publishDate;
    private int authorId;
    private String title;
    private int publisherId;
    private BigDecimal price; // Change out with BigDecimal

    public Book() {
    }

    public Book(int id, String isbn, LocalDate publishDate, int authorId, String title, int publisherId, BigDecimal price) {
        this.id = id;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.authorId = authorId;
        this.title = title;
        this.publisherId = publisherId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                authorId == book.authorId &&
                publisherId == book.publisherId &&
                isbn.equals(book.isbn) &&
                publishDate.equals(book.publishDate) &&
                title.equals(book.title) &&
                price.equals(book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, publishDate, authorId, title, publisherId, price);
    }
}

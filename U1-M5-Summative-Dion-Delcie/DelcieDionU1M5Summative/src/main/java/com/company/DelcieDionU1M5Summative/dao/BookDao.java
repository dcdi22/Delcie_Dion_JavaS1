package com.company.DelcieDionU1M5Summative.dao;

import com.company.DelcieDionU1M5Summative.dto.Book;

import java.util.List;

public interface BookDao {

    Book getBook(int id);

    List<Book> getAllBooks();

    Book addBook(Book book);

    void updateBook(Book book);

    void deleteBook(int id);

    List<Book> getBooksByAuthor (int authorId);

}

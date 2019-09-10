package com.company.DelcieDionU1M5Summative.dao;

import com.company.DelcieDionU1M5Summative.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoJdbcTemplateImpl implements BookDao {

    @Override
    public Book getBook(int id) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Book addBook(Book book) {
        return null;
    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(int id) {

    }

    @Override
    public List<Book> getBooksByAuthor(int authorId) {
        return null;
    }
}

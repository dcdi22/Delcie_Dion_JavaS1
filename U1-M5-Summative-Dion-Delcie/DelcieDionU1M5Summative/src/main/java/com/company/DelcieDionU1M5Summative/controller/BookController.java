package com.company.DelcieDionU1M5Summative.controller;

import com.company.DelcieDionU1M5Summative.dao.AuthorDao;
import com.company.DelcieDionU1M5Summative.dao.BookDao;
import com.company.DelcieDionU1M5Summative.dao.PublisherDao;
import com.company.DelcieDionU1M5Summative.dto.Author;
import com.company.DelcieDionU1M5Summative.dto.Book;
import com.company.DelcieDionU1M5Summative.dto.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping( value = "/book")
public class BookController {

    @Autowired
    BookDao bookDao;
    @Autowired
    AuthorDao authorDao;
    @Autowired
    PublisherDao publisherDao;

    // ============ ADD BOOK ============

    @RequestMapping( method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Book addBook(@RequestBody @Valid Book book){
        return bookDao.addBook(book);
    }

    // ============ GET ALL BOOKS ============

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> getAllBooks() {
        if (bookDao.getAllBooks().size() > 0) {
            return bookDao.getAllBooks();
        } else {
            throw new IllegalArgumentException("No Books found.");
        }
    }

    // ============ GET BOOKS BY AUTHOR ============

    @RequestMapping(value = "/authorID/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> getBooksByAuthor(@PathVariable int id) {
        return bookDao.getBooksByAuthor(id);
    }

    // ============ GET BOOK ============

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Book getBook(@PathVariable int id) {
        if (bookDao.getAllBooks().contains(bookDao.getBook(id))) {
            return bookDao.getBook(id);
        } else {
            throw new IllegalArgumentException("No Book with that ID found");
        }
    }

    // ============ UPDATE BOOK ============

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateBook(@PathVariable int id, @RequestBody @Valid Book book) {
        if (bookDao.getAllBooks().contains(bookDao.getBook(id))) {
            book.setId(id);
            bookDao.updateBook(book);
        } else {
            throw new IllegalArgumentException("No Book with matching ID to update.");
        }
    }

    // ============ DELETE BOOK ============

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBook(@PathVariable int id) {
        if (bookDao.getAllBooks().contains(bookDao.getBook(id))) {
            bookDao.deleteBook(id);
        } else {
            throw new IllegalArgumentException("No Book with that ID found");
        }
    }

}

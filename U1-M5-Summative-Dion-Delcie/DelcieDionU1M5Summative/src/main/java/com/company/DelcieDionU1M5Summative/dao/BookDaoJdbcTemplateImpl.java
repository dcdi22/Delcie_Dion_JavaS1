package com.company.DelcieDionU1M5Summative.dao;

import com.company.DelcieDionU1M5Summative.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbcTemplateImpl implements BookDao {

    /*
    book_id int not null auto_increment primary key,
    isbn varchar (15) not null,
    publish_date date not null,
    author_id int not null,
    title varchar (70) not null,
    publisher_id int not null,
    price decimal(5,2) not null
     */

    private static final String SELECT_BOOK_SQL=
            "select * from book where book_id = ?";

    private static final String SELECT_ALL_BOOKS_SQL=
            "select * from book";

    private static final String SELECT_BOOKS_BY_AUTHOR=
            "select * from book where author_id = ?";

    private static final String INSERT_BOOK_SQL=
            "insert into book (isbn, publish_date, author_id, title, publisher_id, price) values (?,?,?,?,?,?)";

    private static final String UPDATE_BOOK_SQL=
            "update book set isbn = ?, publish_date = ?, author_id = ?, title = ?, publisher_id = ?, price = ? where book_id = ?";

    public static final String DELETE_BOOK_SQL=
            "delete from book where book_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book getBook(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_BOOK_SQL, this::mapRowToBook, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query(SELECT_ALL_BOOKS_SQL, this::mapRowToBook);
    }

    @Override
    @Transactional
    public Book addBook(Book book) {
        jdbcTemplate.update(INSERT_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        book.setId(id);
        return book;
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        jdbcTemplate.update(UPDATE_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice(),
                book.getId());
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        jdbcTemplate.update(DELETE_BOOK_SQL, id);
    }

    @Override
    public List<Book> getBooksByAuthor(int authorId) {
        return jdbcTemplate.query(SELECT_BOOKS_BY_AUTHOR, this::mapRowToBook, authorId);
    }



    private Book mapRowToBook (ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("book_id"));
        book.setIsbn(rs.getString("isbn"));
        book.setPublishDate(rs.getDate("publish_date").toLocalDate());
        book.setAuthorId(rs.getInt("author_id"));
        book.setTitle(rs.getString("title"));
        book.setPublisherId(rs.getInt("publisher_id"));
        book.setPrice(rs.getBigDecimal("price"));
        return book;
    }
}

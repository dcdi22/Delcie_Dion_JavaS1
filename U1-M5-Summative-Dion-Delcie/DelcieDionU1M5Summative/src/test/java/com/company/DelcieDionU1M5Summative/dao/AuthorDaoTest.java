package com.company.DelcieDionU1M5Summative.dao;

import com.company.DelcieDionU1M5Summative.dto.Author;
import com.company.DelcieDionU1M5Summative.dto.Book;
import com.company.DelcieDionU1M5Summative.dto.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {

    @Autowired
    protected AuthorDao authorDao;
    @Autowired
    protected  BookDao bookDao;
    @Autowired
    protected  PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        List<Author> authors = authorDao.getAllAuthors();
        for (Author a: authors) {
            authorDao.deleteAuthor(a.getId());
        }

        List<Book> books = bookDao.getAllBooks();
        for (Book b: books) {
            bookDao.deleteBook(b.getId());
        }

        List<Publisher> publishers = publisherDao.getAllPublishers();
        for (Publisher p: publishers) {
            publisherDao.deletePublisher(p.getId());
        }
    }

    /*
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state char(2) not null,
    postal_code varchar(25) not null,
    phone varchar(15) not null,
    email varchar(60) not null
     */

    @Test
    public void addGetDeleteAuthors() {
        Author author = new Author();
        author.setFirstName("Augusten");
        author.setLastName("Burroughs");
        author.setStreet("Street");
        author.setCity("City");
        author.setState("CA");
        author.setPostalCode("90210");
        author.setPhone("567-789-1234");
        author.setEmail("author@gmail.com");
        author = authorDao.addAuthor(author);

        Author author1 = authorDao.getAuthor(author.getId());

        assertEquals(author1, author);

        authorDao.deleteAuthor(author.getId());

        author1 = authorDao.getAuthor(author.getId());

        assertNull(author1);

    }

    @Test
    public void getAllAuthors() {
        Author author = new Author();
        author.setFirstName("Augusten");
        author.setLastName("Burroughs");
        author.setStreet("Street");
        author.setCity("City");
        author.setState("CA");
        author.setPostalCode("90210");
        author.setPhone("567-789-1234");
        author.setEmail("author@gmail.com");
        author = authorDao.addAuthor(author);

        author = new Author();
        author.setFirstName("Waris");
        author.setLastName("Dirie");
        author.setStreet("Street");
        author.setCity("City");
        author.setState("NY");
        author.setPostalCode("90210");
        author.setPhone("567-789-1234");
        author.setEmail("author@gmail.com");
        authorDao.addAuthor(author);

        List<Author> authorList = authorDao.getAllAuthors();

        assertEquals(2, authorList.size());
    }

    @Test
    public void updateAuthor() {
        Author author = new Author();
        author.setFirstName("Augusten");
        author.setLastName("Burroughs");
        author.setStreet("Street");
        author.setCity("City");
        author.setState("CA");
        author.setPostalCode("90210");
        author.setPhone("567-789-1234");
        author.setEmail("author@gmail.com");
        author = authorDao.addAuthor(author);

        author.setFirstName("Waris");
        author.setLastName("Dirie");

        authorDao.updateAuthor(author);

        Author author1 = authorDao.getAuthor(author.getId());

        assertEquals(author1, author);
    }
}
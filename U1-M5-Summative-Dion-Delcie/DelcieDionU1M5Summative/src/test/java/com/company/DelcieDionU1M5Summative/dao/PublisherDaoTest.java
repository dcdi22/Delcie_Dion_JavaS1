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
public class PublisherDaoTest {

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
    name varchar(50)not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state char(2) not null,
    postal_code varchar(25) not null,
    phone varchar(15) not null,
    email varchar(60) not null
     */

    @Test
    public void addGetDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Picador");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("CA");
        publisher.setPostalCode("90210");
        publisher.setPhone("567-789-1234");
        publisher.setEmail("author@gmail.com");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getId());
        assertEquals(publisher1, publisher);

        publisherDao.deletePublisher(publisher.getId());

        publisher1 = publisherDao.getPublisher(publisher.getId());

        assertNull(publisher1);

    }

    @Test
    public void getAllPublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("Picador");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("CA");
        publisher.setPostalCode("90210");
        publisher.setPhone("567-789-1234");
        publisher.setEmail("author@gmail.com");
        publisher = publisherDao.addPublisher(publisher);

        publisher = new Publisher();
        publisher.setName("William Morrow");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("CA");
        publisher.setPostalCode("90210");
        publisher.setPhone("567-789-1234");
        publisher.setEmail("author@gmail.com");
        publisher = publisherDao.addPublisher(publisher);

        List<Publisher> publisherList = publisherDao.getAllPublishers();

        assertEquals(2, publisherList.size());
    }

    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Picador");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("CA");
        publisher.setPostalCode("90210");
        publisher.setPhone("567-789-1234");
        publisher.setEmail("author@gmail.com");
        publisher = publisherDao.addPublisher(publisher);


        publisher.setName("William Morrow");
        publisher.setStreet("ROAD");

        publisherDao.updatePublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getId());

        assertEquals(publisher1, publisher);
    }
}
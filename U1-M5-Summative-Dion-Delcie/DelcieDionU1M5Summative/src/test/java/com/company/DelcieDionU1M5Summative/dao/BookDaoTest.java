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

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {

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
    book_id int not null auto_increment primary key,
    isbn varchar (15) not null,
    publish_date date not null,
    author_id int not null,
    title varchar (70) not null,
    publisher_id int not null,
    price decimal(5,2) not null
     */

    @Test
    public void addGetDeleteBook() {
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

        Publisher publisher = new Publisher();
        publisher.setName("Picador");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("CA");
        publisher.setPostalCode("90210");
        publisher.setPhone("567-789-1234");
        publisher.setEmail("author@gmail.com");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("34655235342");
        book.setPublishDate(new Date(1986, 2, 23));
        book.setAuthorId(author.getId());
        book.setTitle("Running With Scissors");
        book.setPublisherId(publisher.getId());
        book.setPrice(12.99);
        book = bookDao.addBook(book);

        Book book1 = bookDao.getBook(book.getId());

        assertEquals(book1, book);

        bookDao.deleteBook(book.getId());

        book1 = bookDao.getBook(book.getId());

        assertNull(book1);
    }

    @Test
    public void getAllBooks() {
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

        Publisher publisher = new Publisher();
        publisher.setName("Picador");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("CA");
        publisher.setPostalCode("90210");
        publisher.setPhone("567-789-1234");
        publisher.setEmail("author@gmail.com");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("34655235342");
        book.setPublishDate(new Date(1986, 2, 23));
        book.setAuthorId(author.getId());
        book.setTitle("Running With Scissors");
        book.setPublisherId(publisher.getId());
        book.setPrice(12.99);
        book = bookDao.addBook(book);

        book = new Book();
        book.setIsbn("657657545");
        book.setPublishDate(new Date(1990, 7, 20));
        book.setAuthorId(author.getId());
        book.setTitle("Dry");
        book.setPublisherId(publisher.getId());
        book.setPrice(16.99);
        bookDao.addBook(book);

        List<Book> bookList = bookDao.getAllBooks();

        assertEquals(2, bookList.size());
    }

    @Test
    public void updateBook() {
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

        Publisher publisher = new Publisher();
        publisher.setName("Picador");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("CA");
        publisher.setPostalCode("90210");
        publisher.setPhone("567-789-1234");
        publisher.setEmail("author@gmail.com");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("34655235342");
        book.setPublishDate(new Date(1986, 2, 23));
        book.setAuthorId(author.getId());
        book.setTitle("Running With Scissors");
        book.setPublisherId(publisher.getId());
        book.setPrice(12.99);
        book = bookDao.addBook(book);

        book.setIsbn("657657545");
        book.setPublishDate(new Date(1990, 7, 20));
        book.setAuthorId(author.getId());
        book.setTitle("Dry");

        bookDao.updateBook(book);

        Book book1 = bookDao.getBook(book.getId());

        assertEquals(book1, book);
    }

    @Test
    public void getBooksByAuthor() {
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

        Author author1 = new Author();
        author1.setFirstName("Waris");
        author1.setLastName("Dirie");
        author1.setStreet("Road");
        author1.setCity("City");
        author1.setState("NY");
        author1.setPostalCode("90210");
        author1.setPhone("567-789-1234");
        author1.setEmail("author@gmail.com");
        author1 = authorDao.addAuthor(author1);

        Author author2 = new Author();
        author2.setFirstName("Jennette");
        author2.setLastName("Walls");
        author2.setStreet("Lane");
        author2.setCity("City");
        author2.setState("MI");
        author2.setPostalCode("90210");
        author2.setPhone("567-789-1234");
        author2.setEmail("author@gmail.com");
        author2 = authorDao.addAuthor(author2);

        Publisher publisher = new Publisher();
        publisher.setName("Picador");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("CA");
        publisher.setPostalCode("90210");
        publisher.setPhone("567-789-1234");
        publisher.setEmail("author@gmail.com");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("34655235342");
        book.setPublishDate(new Date(1986, 2, 23));
        book.setAuthorId(author.getId());
        book.setTitle("Running With Scissors");
        book.setPublisherId(publisher.getId());
        book.setPrice(12.99);
        book = bookDao.addBook(book);

        book = new Book();
        book.setIsbn("657657545");
        book.setPublishDate(new Date(1990, 7, 20));
        book.setAuthorId(author.getId());
        book.setTitle("Dry");
        book.setPublisherId(publisher.getId());
        book.setPrice(16.99);
        bookDao.addBook(book);

        book = new Book();
        book.setIsbn("23180090");
        book.setPublishDate(new Date(1999, 7, 20));
        book.setAuthorId(author1.getId());
        book.setTitle("Desert Flower");
        book.setPublisherId(publisher.getId());
        book.setPrice(16.99);
        bookDao.addBook(book);

        List<Book> bookList = bookDao.getBooksByAuthor(author.getId());
        assertEquals(2, bookList.size());

        List<Book> bookList2 = bookDao.getBooksByAuthor(author1.getId());
        assertEquals(1, bookList2.size());

        List<Book> bookList3 = bookDao.getBooksByAuthor(author2.getId());
        assertEquals(0, bookList3.size());

    }
}
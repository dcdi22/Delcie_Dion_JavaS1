package com.company.DelcieDionU1M5Summative.dao;

import com.company.DelcieDionU1M5Summative.dto.Author;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorDaoJdbcTemplateImpl implements AuthorDao {

    // Prepared Statements
    private static final String SELECT_AUTHOR_SQL=
            "select * from author where author_id = ?";

    private static final String SELECT_ALL_AUTHORS_SQL=
            "select * from author";

    private static final String INSERT_AUTHOR_SQL=
            "insert into author (fisrt_name, last_name, street, city, state, postal_code, phone, email) values (?,?,?,?,?,?,?,?)";

    private static final String UPDATE_AUTHOR_SQL=
            ""


    @Override
    public Author getAuthor(int id) {
        return null;
    }

    @Override
    public List<Author> getAllAuthors() {
        return null;
    }

    @Override
    public Author addAuthor(Author author) {
        return null;
    }

    @Override
    public void updateAuthor(int id) {

    }

    @Override
    public void deleteAuthor(int id) {

    }

    /*
    author_id int not null auto_increment primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state char(2) not null,
    postal_code varchar(25) not null,
    phone varchar(15) not null,
    email varchar(60) not null
     */

    private Author mapRowToAuthor(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getInt("author_id"));
        author.setFirstName(rs.getString("first_name"));
        author.setLastName(rs.getString("last_name"));
        author.setStreet(rs.getString("street"));
        author.setCity(rs.getString("city"));
        author.setState(rs.getString("state"));
        author.setPostalCode(rs.getString("postal_code"));
        author.setPhone(rs.getString("phone"));
        author.setEmail(rs.getString("email"));
        return author;
    }

}

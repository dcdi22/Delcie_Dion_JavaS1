package com.company.DelcieDionU1M5Summative.controller;

import com.company.DelcieDionU1M5Summative.dao.AuthorDao;
import com.company.DelcieDionU1M5Summative.dto.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    AuthorDao authorDao;

    // ============ ADD AUTHOR ============

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author) {
        return authorDao.addAuthor(author);
    }

    // ============ GET AUTHOR ============

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Author getAnAuthor(@PathVariable int id) {
        return authorDao.getAuthor(id);
    }

    // ============ GET ALL AUTHORS ============

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Author> getAllAuthors() {
        return authorDao.getAllAuthors();
    }

    // ============ UPDATE AUTHOR ============

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateAuthor(@PathVariable int id, @RequestBody Author updatedAuthor) {
        updatedAuthor.setId(id);
        authorDao.updateAuthor(updatedAuthor);
    }

    // ============ DELETE AUTHOR ============

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteAuthor(@PathVariable int id) {
        authorDao.deleteAuthor(id);
    }

}

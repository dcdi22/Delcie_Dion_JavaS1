package com.company.DelcieDionU1M5Summative.controller;

import com.company.DelcieDionU1M5Summative.dao.AuthorDao;
import com.company.DelcieDionU1M5Summative.dto.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    AuthorDao authorDao;

    // ============ ADD AUTHOR ============

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Author addAuthor(@RequestBody @Valid Author author) {
        return authorDao.addAuthor(author);
    }

    // ============ GET ALL AUTHORS ============

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Author> getAllAuthors() {
        if (authorDao.getAllAuthors().size() > 0) {
            return authorDao.getAllAuthors();
        } else {
            throw new IllegalArgumentException("No Authors Found.");
        }
    }

    // ============ GET AUTHOR ============

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Author getAnAuthor(@PathVariable int id) {
        if (authorDao.getAllAuthors().contains(authorDao.getAuthor(id))) {
            return authorDao.getAuthor(id);
        } else {
            throw new IllegalArgumentException("No Author with that ID found.");
        }

    }

    // ============ UPDATE AUTHOR ============

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateAuthor(@PathVariable int id, @RequestBody @Valid Author updatedAuthor) {
        if (authorDao.getAllAuthors().contains(authorDao.getAuthor(id))) {
            updatedAuthor.setId(id);
            authorDao.updateAuthor(updatedAuthor);
        } else {
            throw new IllegalArgumentException("Could not update, no author with matching ID.");
        }

    }

    // ============ DELETE AUTHOR ============

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteAuthor(@PathVariable int id) {
        if (authorDao.getAllAuthors().contains(authorDao.getAuthor(id))) {
            authorDao.deleteAuthor(id);
        } else {
            throw new IllegalArgumentException("No Author with that ID found.");
        }

    }

}

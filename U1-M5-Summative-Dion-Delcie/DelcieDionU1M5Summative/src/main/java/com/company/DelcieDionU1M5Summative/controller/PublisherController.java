package com.company.DelcieDionU1M5Summative.controller;

import com.company.DelcieDionU1M5Summative.dao.PublisherDao;
import com.company.DelcieDionU1M5Summative.dto.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/publisher")
public class PublisherController {

    @Autowired
    PublisherDao publisherDao;

    // ============ ADD PUBLISHER ============

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody @Valid Publisher publisher) {
        return publisherDao.addPublisher(publisher);
    }

    // ============ GET ALL PUBLISHERS ============

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Publisher> getAllPublishers() {
        if (publisherDao.getAllPublishers().size() > 0) {
            return publisherDao.getAllPublishers();
        } else {
            throw new IllegalArgumentException("No Publishers found.");
        }
    }

    // ============ GET PUBLISHER ============

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Publisher getPublisher(@PathVariable int id) {
        if (publisherDao.getAllPublishers().contains(publisherDao.getPublisher(id))) {
            return publisherDao.getPublisher(id);
        } else {
            throw new IllegalArgumentException("No Publisher with that ID found.");
        }
    }

    // ============ UPDATE PUBLISHER ============

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updatePublisher(@PathVariable int id, @RequestBody @Valid Publisher updatedPublisher) {
        if (publisherDao.getAllPublishers().contains(publisherDao.getPublisher(id))) {
            updatedPublisher.setId(id);
            publisherDao.updatePublisher(updatedPublisher);
        } else {
            throw new IllegalArgumentException("Could not update, no publisher with matching ID.");
        }
    }

    // ============ DELETE PUBLISHER ============

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePublisher(@PathVariable int id) {
        if (publisherDao.getAllPublishers().contains(publisherDao.getPublisher(id))) {
            publisherDao.deletePublisher(id);
        } else {
            throw new IllegalArgumentException("No Publisher with that ID found.");
        }
    }
}

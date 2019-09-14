package com.company.DelcieDionU1M5Summative.controller;

import com.company.DelcieDionU1M5Summative.dao.PublisherDao;
import com.company.DelcieDionU1M5Summative.dto.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/publisher")
public class PublisherController {

    @Autowired
    PublisherDao publisherDao;

    // ============ ADD PUBLISHER ============

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return publisherDao.addPublisher(publisher);
    }

    // ============ GET PUBLISHER ============

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Publisher getAnPublisher(@PathVariable int id) {
        return publisherDao.getPublisher(id);
    }

    // ============ GET ALL PUBLISHERS ============

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Publisher> getAllPublishers() {
        return publisherDao.getAllPublishers();
    }

    // ============ UPDATE PUBLISHER ============

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updatePublisher(@PathVariable int id, @RequestBody Publisher updatedPublisher) {
        updatedPublisher.setId(id);
        publisherDao.updatePublisher(updatedPublisher);
    }

    // ============ DELETE PUBLISHER ============

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePublisher(@PathVariable int id) {
        publisherDao.deletePublisher(id);
    }
}

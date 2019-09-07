package com.company.VideoGameCollectionDaoDelcieDion.dao;

import com.company.VideoGameCollectionDaoDelcieDion.model.Publisher;

import java.util.List;

public interface PublisherDao {

    Publisher addPublisher(Publisher publisher);

    Publisher getPublisher(int id);

    List<Publisher> getAllPublishers();

    void updatePublisher(Publisher publisher);

    void deletePublisher(int id);

}

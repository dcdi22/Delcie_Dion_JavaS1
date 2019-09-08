package com.company.VideoGameCollectionDaoDelcieDion.dao;

import com.company.VideoGameCollectionDaoDelcieDion.model.Console;
import com.company.VideoGameCollectionDaoDelcieDion.model.Game;
import com.company.VideoGameCollectionDaoDelcieDion.model.Publisher;
import com.company.VideoGameCollectionDaoDelcieDion.model.Type;
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
    ConsoleDao consoleDao;
    @Autowired
    GameDao gameDao;
    @Autowired
    PublisherDao publisherDao;
    @Autowired
    TypeDao typeDao;

    @Before
    public void setUp() throws Exception {
        List<Console> consoleList = consoleDao.getAllConsoles();
        for (Console c: consoleList) {
            consoleDao.deleteConsole(c.getId());
        }

        List<Game> gameList = gameDao.getAllGames();
        for (Game g: gameList) {
            gameDao.deleteGame(g.getId());
        }

        List<Publisher> publisherList = publisherDao.getAllPublishers();
        for (Publisher p: publisherList) {
            publisherDao.deletePublisher(p.getId());
        }

        List<Type> typeList = typeDao.getAllTypes();
        for (Type t: typeList) {
            typeDao.deleteType(t.getId());
        }
    }

    @Test
    public void addGetDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Bethesda");
        publisher.setWebsite("www.bethesda.com");
        publisherDao.addPublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getId());

        assertEquals(publisher1, publisher);

        publisherDao.deletePublisher(publisher.getId());

        publisher1 = publisherDao.getPublisher(publisher.getId());

        assertNull(publisher1);

    }

    @Test
    public void getAllPublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("Bethesda");
        publisher.setWebsite("www.bethesda.com");
        publisherDao.addPublisher(publisher);

        publisher = new Publisher();
        publisher.setName("CD Projekt Red");
        publisher.setWebsite("www.blahblah.com");
        publisherDao.addPublisher(publisher);

        List<Publisher> publisherList = publisherDao.getAllPublishers();

        assertEquals(publisherList.size(), 2);
    }

    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Bethesda");
        publisher.setWebsite("www.bethesda.com");
        publisherDao.addPublisher(publisher);

        publisher.setName("CD Projekt Red");
        publisher.setWebsite("www.blahblah.com");
        publisherDao.updatePublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getId());

        assertEquals(publisher1, publisher);
    }
}
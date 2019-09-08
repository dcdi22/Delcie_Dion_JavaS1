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
public class ConsoleDaoTest {

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


        List<Publisher> publisherList = publisherDao.getAllPublishers();
        for (Publisher p: publisherList) {
            publisherDao.deletePublisher(p.getId());
        }

        List<Type> typeList = typeDao.getAllTypes();
        for (Type t: typeList) {
            typeDao.deleteType(t.getId());
        }

        List<Game> gameList = gameDao.getAllGames();
        for (Game g: gameList) {
            gameDao.deleteGame(g.getId());
        }
    }

    @Test
    public void addGetDeleteConsole() {
        Console console = new Console();
        console.setName("PS4");
        console.setYear("2013");
        consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getId());

        assertEquals(console1, console);

        consoleDao.deleteConsole(console.getId());

        console1 = consoleDao.getConsole(console.getId());
        assertNull(console1);
    }

    @Test
    public void getAllConsoles() {
        Console console = new Console();
        console.setName("PS4");
        console.setYear("2013");
        consoleDao.addConsole(console);

        console = new Console();
        console.setName("Xbox One");
        console.setYear("2013");
        consoleDao.addConsole(console);

        List<Console> consoleList = consoleDao.getAllConsoles();

        assertEquals(consoleList, 2);
    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setName("PS4");
        console.setYear("2013");
        consoleDao.addConsole(console);

        console.setName("Xbox One");
        console.setYear("2013");
        consoleDao.updateConsole(console);

        Console console1 = consoleDao.getConsole(console.getId());

        assertEquals(console1, console);
    }
}
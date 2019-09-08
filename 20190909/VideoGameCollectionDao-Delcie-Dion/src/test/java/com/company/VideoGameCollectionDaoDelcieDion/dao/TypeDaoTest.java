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
public class TypeDaoTest {

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
    public void addGetDelete() {
        Type type = new Type();
        type.setName("rpg");
        type.setDescription("role playing game");
        type = typeDao.addType(type);

        Type type1 = typeDao.getType(type.getId());

        assertEquals(type1, type);

        typeDao.deleteType(type.getId());

        type1 = typeDao.getType(type.getId());

        assertNull(type1);

    }

    @Test
    public void getAllTypes() {
        Type type = new Type();
        type.setName("rpg");
        type.setDescription("role playing game");
        type = typeDao.addType(type);

        type = new Type();
        type.setName("action");
        type.setDescription("boom boom pow game");
        type = typeDao.addType(type);

        List<Type> typeList = typeDao.getAllTypes();

        assertEquals(typeList.size(), 2);
    }

    @Test
    public void updateType() {
        Type type = new Type();
        type.setName("rpg");
        type.setDescription("role playing game");
        type = typeDao.addType(type);

        type.setName("action");
        type.setDescription("boom boom pow game");
        typeDao.updateType(type);

        Type type1 = typeDao.getType(type.getId());

        assertEquals(type1, type);
    }
}
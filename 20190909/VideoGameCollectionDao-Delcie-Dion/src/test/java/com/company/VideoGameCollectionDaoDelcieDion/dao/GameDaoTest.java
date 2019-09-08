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
public class GameDaoTest {

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
    public void addGetDeleteGame() {
        Type type = new Type();
        type.setName("rpg");
        type.setDescription("Role Playing Game");
        type = typeDao.addType(type);

        Publisher publisher = new Publisher();
        publisher.setName("Bethesda");
        publisher.setWebsite("www.bethesda.com");
        publisher = publisherDao.addPublisher(publisher);

        Console console = new Console();
        console.setName("PS4");
        console.setYear("2013");
        console = consoleDao.addConsole(console);

        Game game = new Game();
        game.setConsole_id(console.getId());
        game.setPublisher_id(publisher.getId());
        game.setType_id(type.getId());
        game = gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getId());

        assertEquals(game1, game);

        gameDao.deleteGame(game.getId());

        game1 = gameDao.getGame(game.getId());

        assertNull(game1);

    }

    @Test
    public void getAllGames() {
        Type type = new Type();
        type.setName("rpg");
        type.setDescription("Role Playing Game");
        type = typeDao.addType(type);

        Publisher publisher = new Publisher();
        publisher.setName("Bethesda");
        publisher.setWebsite("www.bethesda.com");
        publisher = publisherDao.addPublisher(publisher);

        Console console = new Console();
        console.setName("PS4");
        console.setYear("2013");
        console = consoleDao.addConsole(console);

        Game game = new Game();
        game.setConsole_id(console.getId());
        game.setPublisher_id(publisher.getId());
        game.setType_id(type.getId());
        game = gameDao.addGame(game);

        game = new Game();
        game.setConsole_id(console.getId());
        game.setPublisher_id(publisher.getId());
        game.setType_id(type.getId());
        game = gameDao.addGame(game);

        List<Game> gameList = gameDao.getAllGames();
        assertEquals(gameList.size(), 2);
    }

    @Test
    public void getGamesByConsole() {
        Type type = new Type();
        type.setName("rpg");
        type.setDescription("Role Playing Game");
        type = typeDao.addType(type);

        Publisher publisher = new Publisher();
        publisher.setName("Bethesda");
        publisher.setWebsite("www.bethesda.com");
        publisher = publisherDao.addPublisher(publisher);

        Console console = new Console();
        console.setName("PS4");
        console.setYear("2013");
        console = consoleDao.addConsole(console);

        Console console1 = new Console();
        console1.setName("Xbox One");
        console1.setYear("2013");
        console1 = consoleDao.addConsole(console1);

        Game game = new Game();
        game.setConsole_id(console.getId());
        game.setPublisher_id(publisher.getId());
        game.setType_id(type.getId());
        game = gameDao.addGame(game);

        game = new Game();
        game.setConsole_id(console.getId());
        game.setPublisher_id(publisher.getId());
        game.setType_id(type.getId());
        game = gameDao.addGame(game);

        Game game1 = new Game();
        game1.setConsole_id(console1.getId());
        game1.setPublisher_id(publisher.getId());
        game1.setType_id(type.getId());
        game1 = gameDao.addGame(game1);

        List<Game> gameList = gameDao.getGamesByConsole(game.getId());

        assertEquals(gameList, 1);

        gameList = gameDao.getGamesByConsole(game1.getId());
        assertEquals(gameList.size(), 2);
        // I FEEL LIKE THIS TEST IS ALL WRONG

    }

    @Test
    public void getGamesByPublisher() {
        Type type = new Type();
        type.setName("rpg");
        type.setDescription("Role Playing Game");
        type = typeDao.addType(type);

        Publisher publisher = new Publisher();
        publisher.setName("Bethesda");
        publisher.setWebsite("www.bethesda.com");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setName("CD Projekt Red");
        publisher1.setWebsite("www.cdprojekt.com");
        publisher1 = publisherDao.addPublisher(publisher1);

        Console console = new Console();
        console.setName("PS4");
        console.setYear("2013");
        console = consoleDao.addConsole(console);

        Game game = new Game();
        game.setConsole_id(console.getId());
        game.setPublisher_id(publisher.getId());
        game.setType_id(type.getId());
        game = gameDao.addGame(game);

        game = new Game();
        game.setConsole_id(console.getId());
        game.setPublisher_id(publisher.getId());
        game.setType_id(type.getId());
        game = gameDao.addGame(game);

        Game game1 = new Game();
        game1.setConsole_id(console.getId());
        game1.setPublisher_id(publisher1.getId());
        game1.setType_id(type.getId());
        game1 = gameDao.addGame(game1);

        List<Game> gameList = gameDao.getGamesByPublisher(game.getId());
        assertEquals(gameList, 1);

        gameList = gameDao.getGamesByPublisher(game1.getId());
        assertEquals(gameList.size(), 2);
    }

    @Test
    public void getGamesByType() {
        Type type = new Type();
        type.setName("rpg");
        type.setDescription("Role Playing Game");
        type = typeDao.addType(type);

        Type type1 = new Type();
        type1.setName("action");
        type1.setDescription("Boom boom pow Game");
        type1 = typeDao.addType(type1);

        Publisher publisher = new Publisher();
        publisher.setName("Bethesda");
        publisher.setWebsite("www.bethesda.com");
        publisher = publisherDao.addPublisher(publisher);

        Console console = new Console();
        console.setName("PS4");
        console.setYear("2013");
        console = consoleDao.addConsole(console);

        Game game = new Game();
        game.setConsole_id(console.getId());
        game.setPublisher_id(publisher.getId());
        game.setType_id(type.getId());
        game = gameDao.addGame(game);

        game = new Game();
        game.setConsole_id(console.getId());
        game.setPublisher_id(publisher.getId());
        game.setType_id(type.getId());
        game = gameDao.addGame(game);

        Game game1 = new Game();
        game1.setConsole_id(console.getId());
        game1.setPublisher_id(publisher.getId());
        game1.setType_id(type1.getId());
        game1 = gameDao.addGame(game1);

        List<Game> gameList = gameDao.getGamesByType(game.getId());

        assertEquals(gameList, 1);

        gameList = gameDao.getGamesByType(game1.getId());
        assertEquals(gameList.size(), 2);
    }

    @Test
    public void updateGame() {
        Type type = new Type();
        type.setName("rpg");
        type.setDescription("Role Playing Game");
        type = typeDao.addType(type);

        Publisher publisher = new Publisher();
        publisher.setName("Bethesda");
        publisher.setWebsite("www.bethesda.com");
        publisher = publisherDao.addPublisher(publisher);

        Console console = new Console();
        console.setName("PS4");
        console.setYear("2013");
        console = consoleDao.addConsole(console);

        Console console1 = new Console();
        console1.setName("Xbox One");
        console1.setYear("2013");
        console1 = consoleDao.addConsole(console1);

        Game game = new Game();
        game.setConsole_id(console.getId());
        game.setPublisher_id(publisher.getId());
        game.setType_id(type.getId());
        game = gameDao.addGame(game);

        game.setConsole_id(console1.getId());
        gameDao.updateGame(game);

        Game game1 = gameDao.getGame(game.getId());

        assertEquals(game1, game);
    }
}
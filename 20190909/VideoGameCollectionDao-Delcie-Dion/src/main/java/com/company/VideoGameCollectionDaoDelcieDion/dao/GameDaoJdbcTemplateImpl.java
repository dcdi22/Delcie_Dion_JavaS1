package com.company.VideoGameCollectionDaoDelcieDion.dao;

import com.company.VideoGameCollectionDaoDelcieDion.model.Game;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameDaoJdbcTemplateImpl implements GameDao {
    @Override
    public Game addGame(Game game) {
        return null;
    }

    @Override
    public Game getGame(int id) {
        return null;
    }

    @Override
    public List<Game> getAllGames() {
        return null;
    }

    @Override
    public List<Game> getGamesByConsole(int console_id) {
        return null;
    }

    @Override
    public List<Game> getGamesByPublisher(int publisher_id) {
        return null;
    }

    @Override
    public List<Game> getGamesByType(int type_id) {
        return null;
    }

    @Override
    public void updateGame(Game game) {

    }

    @Override
    public void deleteGame(int id) {

    }
}

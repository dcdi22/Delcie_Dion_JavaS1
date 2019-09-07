package com.company.VideoGameCollectionDaoDelcieDion.dao;

import com.company.VideoGameCollectionDaoDelcieDion.model.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getAllGames();

    List<Game> getGamesByConsole(int console_id);

    List<Game> getGamesByPublisher(int publisher_id);

    List<Game> getGamesByType(int type_id);

    void updateGame(Game game);

    void deleteGame(int id);

}

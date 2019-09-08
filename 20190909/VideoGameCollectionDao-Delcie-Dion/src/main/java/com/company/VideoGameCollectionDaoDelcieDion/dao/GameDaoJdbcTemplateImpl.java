package com.company.VideoGameCollectionDaoDelcieDion.dao;

import com.company.VideoGameCollectionDaoDelcieDion.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoJdbcTemplateImpl implements GameDao {
    private static final String INSERT_GAME_SQL=
            "insert into game (console_id, publisher_id, type_id ) value (?,?,?)";

    private static final String SELECT_GAME_SQL=
            "select * from game where game_id = ?";

    private static final String SELECT_ALL_GAMES_SQL=
            "select * from game";

    private static final String SELECT_GAME_BY_CONSOLE=
            "select * from game where console_id = ?";

    private static final String SELECT_GAME_BY_PUBLISHER=
            "select * from game where publisher_id = ?";

    private static final String SELECT_GAME_BY_TYPE=
            "select * from game where type_id = ?";

    private static final String UPDATE_GAME_SQL=
            "update game set console_id = ?, publisher_id = ?, type_id = ? where game_id = ?";

    private static final String DELETE_GAME_SQL=
            "delete from game where game_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Game addGame(Game game) {
        jdbcTemplate.update(INSERT_GAME_SQL,
                game.getConsole_id(),
                game.getPublisher_id(),
                game.getType_id());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        game.setId(id);
        return game;
    }

    @Override
    public Game getGame(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Game> getAllGames() {

        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);
    }

    @Override
    public List<Game> getGamesByConsole(int console_id) {

        return jdbcTemplate.query(SELECT_GAME_BY_CONSOLE, this::mapRowToGame, console_id);
    }

    @Override
    public List<Game> getGamesByPublisher(int publisher_id) {

        return jdbcTemplate.query(SELECT_GAME_BY_PUBLISHER, this::mapRowToGame, publisher_id);
    }

    @Override
    public List<Game> getGamesByType(int type_id) {

        return jdbcTemplate.query(SELECT_GAME_BY_TYPE, this::mapRowToGame, type_id);
    }

    @Override
    public void updateGame(Game game) {
        jdbcTemplate.update(UPDATE_GAME_SQL,
                game.getConsole_id(),
                game.getPublisher_id(),
                game.getType_id(),
                game.getId());
    }

    @Override
    public void deleteGame(int id) {
        jdbcTemplate.update(DELETE_GAME_SQL, id);
    }

    private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setId(rs.getInt("game_id"));
        game.setConsole_id(rs.getInt("console_id"));
        game.setPublisher_id(rs.getInt("publisher_id"));
        game.setType_id(rs.getInt("type_id"));
        return game;
    }
}

package com.company.CoffeeInventoryDaoDelcieDion.dao;

import com.company.CoffeeInventoryDaoDelcieDion.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoffeeDaoJdbcTemplateImpl implements CoffeeDao {
    /*
    coffee_id int not null auto_increment primary key,
    roaster_id int not null,
    name varchar(50) not null,
    count int not null,
    unit_price decimal(5,2) not null,
    description varchar(255),
    type varchar(50)
     */
    // MIGHT HAVE TO TAKE OUT DESCRIPTION AND TYPE SINCE THE MAPPER
    // COULDN'T TAKE IT
    private static final String INSERT_COFFEE_SQL=
            "insert into coffee (roaster_id, name, count, unit_price, description, type) value (?,?,?,?,?,?)";

    private static final String SELECT_COFFEE_SQL=
            "select * from coffee where coffee_id = ?";

    private static final String SELECT_ALL_COFFEES_SQL=
            "select * from coffee";

    private static final String SELECT_COFFEE_BY_TYPE=
            "select * from coffee where type = ?";

    private static final String SELECT_COFFEE_BY_ROASTER=
            "select * from coffee where roaster_id = ?";

    private static final String UPDATE_COFFEE_SQL=
            "update coffee set roaster_id = ?, name = ?, count = ?, unit_price = ?, description = ?, type = ? where coffee_id = ?";

    private static final String DELETE_COFFEE_SQL=
            "delete from coffee where coffee_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CoffeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public Coffee addCoffee(Coffee coffee) {
        jdbcTemplate.update(INSERT_COFFEE_SQL,
                coffee.getRoasterId(),
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnit_price(),
                coffee.getDescription(),
                coffee.getType());
        int id = jdbcTemplate.queryForObject("select_last_insert_id()", Integer.class);
        coffee.setId(id);
        return coffee;
    }

    @Override
    public Coffee getCoffee(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_COFFEE_SQL, this::mapRowToCoffee, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Coffee> getAllCoffee() {
        return jdbcTemplate.query(SELECT_ALL_COFFEES_SQL, this::mapRowToCoffee);
    }

    @Override
    public List<Coffee> getCoffeeByType(String type) {
        return jdbcTemplate.query(SELECT_COFFEE_BY_TYPE, this::mapRowToCoffee, type);
    }

    @Override
    public List<Coffee> getCoffeByRoaster(int roasterId) {
        return jdbcTemplate.query(SELECT_COFFEE_BY_ROASTER, this::mapRowToCoffee, roasterId);
    }

    @Override
    public void updateCoffee(Coffee coffee) {
        jdbcTemplate.update(UPDATE_COFFEE_SQL,
                coffee.getRoasterId(),
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnit_price(),
                coffee.getDescription(),
                coffee.getType(),
                coffee.getId());
    }

    @Override
    public void deleteCoffee(int id) {
        jdbcTemplate.update(DELETE_COFFEE_SQL, id);
    }

    /*
    coffee_id int not null auto_increment primary key,
    roaster_id int not null,
    name varchar(50) not null,
    count int not null,
    unit_price decimal(5,2) not null,
    description varchar(255),
    type varchar(50)
     */
    private Coffee mapRowToCoffee(ResultSet rs, int rowNum) throws SQLException {
        Coffee coffee = new Coffee();
        coffee.setId(rs.getInt("coffee_id"));
        coffee.setRoasterId(rs.getInt("roaster_id"));
        coffee.setName(rs.getString("name"));
        coffee.setCount(rs.getInt("count"));
        coffee.setUnit_price(rs.getDouble("unit_price"));
//        coffee.getDescription(rs.getString("description"));
//        coffee.getType(rs.getString("type"));
        // ^^ Is this not working because they are not `not null`?
        return coffee;
    }
}

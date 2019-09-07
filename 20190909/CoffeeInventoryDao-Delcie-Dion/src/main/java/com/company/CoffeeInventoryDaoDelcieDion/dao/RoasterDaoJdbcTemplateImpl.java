package com.company.CoffeeInventoryDaoDelcieDion.dao;

import com.company.CoffeeInventoryDaoDelcieDion.model.Roaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoasterDaoJdbcTemplateImpl implements RoasterDao {
    /*
    roaster_id int not null auto_increment primary key,
    name varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state char(2) not null,
    postal_code varchar(25) not null,
    phone varchar(15) not null,
    email varchar(60) not null,
    note varchar(255)
     */
    private static final String INSERT_ROASTER_SQL =
            "insert into roaster (name, street, city, state, postal_code, phone, email, note) values (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_ROASTER_SQL=
            "select * from roaster where roaster_id = ?";

    private static final String SELECT_ALL_ROASTERS_SQL=
            "select * from roaster";

    private static final String DELETE_ROASTER_SQL=
            "delete from roaster where roaster_id = ?";

    private static final String UPDATE_ROASTER_SQL=
            "update roaster set name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ?, note = ? where roaster_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RoasterDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public Roaster addRoaster(Roaster roaster) {
        jdbcTemplate.update(INSERT_ROASTER_SQL,
                roaster.getName(),
                roaster.getStreet(),
                roaster.getCity(),
                roaster.getState(),
                roaster.getPostal_code(),
                roaster.getPhone(),
                roaster.getEmail(),
                roaster.getNote());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        roaster.setId(id);
        return roaster;
    }

    @Override
    public Roaster getRoaster(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_ROASTER_SQL, this::mapRowToRoaster, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Roaster> getAllRoasters() {
        return jdbcTemplate.query(SELECT_ALL_ROASTERS_SQL, this::mapRowToRoaster);
    }

    @Override
    public void updateRoaster(Roaster roaster) {
        jdbcTemplate.update(UPDATE_ROASTER_SQL,
                roaster.getName(),
                roaster.getStreet(),
                roaster.getCity(),
                roaster.getState(),
                roaster.getPostal_code(),
                roaster.getPhone(),
                roaster.getEmail(),
                roaster.getNote(),
                roaster.getId());
    }

    @Override
    public void deleteRoaster(int id) {
        jdbcTemplate.update(DELETE_ROASTER_SQL, id);
    }

    /*
    roaster_id int not null auto_increment primary key,
    name varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state char(2) not null,
    postal_code varchar(25) not null,
    phone varchar(15) not null,
    email varchar(60) not null,
    note varchar(255)
     */
    private Roaster mapRowToRoaster(ResultSet rs, int rowNum) throws SQLException {
        Roaster roaster = new Roaster();
        roaster.setId(rs.getInt("roaster_id"));
        roaster.setName(rs.getString("name"));
        roaster.setStreet(rs.getString("street"));
        roaster.setCity(rs.getString("city"));
        roaster.setState(rs.getString("state"));
        roaster.setPostal_code(rs.getString("postal_code"));
        roaster.setPhone(rs.getString("phone"));
        roaster.setEmail(rs.getString("email"));
        roaster.setNote(rs.getString("note"));
        return roaster;
    }
}

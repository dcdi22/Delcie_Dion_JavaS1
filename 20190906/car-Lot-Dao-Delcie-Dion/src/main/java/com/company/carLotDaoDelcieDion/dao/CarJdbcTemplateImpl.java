package com.company.carLotDaoDelcieDion.dao;

import com.company.carLotDaoDelcieDion.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarJdbcTemplateImpl implements CarDao {

    private static final String INSERT_CAR_SQL =
            "INSERT INTO CAR (MAKE, MODEL, YEAR, COLOR) VALUES (?,?,?,?)";

    private static final String SELECT_CAR_SQL=
            "select * from car where id = ?";

    private static final String SELECT_ALL_CARS_SQL=
            "select * from car";

    private static final String DELETE_CAR_SQL=
            "delete from car where id = ?";

    private static final String UPDATE_CAR_SQL=
            "update car set make = ?, model = ?, year = ?, color = ? where id = ?";

    private static final String SELECT_CAR_BY_MAKE_SQL=
            "select * from car where make = ?";

    private static final String SELECT_CAR_BY_COLOR_SQL=
            "select * from car where color = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Getting one car for the given id
     *
     * @param id
     * @return car
     */
    @Override
    public Car getcar(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CAR_SQL, this::mapRowToCar, id);
        } catch (EmptyResultDataAccessException e) {
            // if nothing is returned just catch the exception and return null;
            return null;
        }
    }

    /**
     * Get all the cars
     *
     * @return List of cars
     */
    @Override
    public List<Car> getAllCars() {
        return jdbcTemplate.query(SELECT_ALL_CARS_SQL, this::mapRowToCar);
    }

    /**
     * Adds the given car to the DB
     *
     * @param car
     * @return
     */
    @Override
    @Transactional
    public Car addCar(Car car) {
        jdbcTemplate.update(INSERT_CAR_SQL,
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getColor());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        car.setId(id);
        return car;
    }

    /**
     * Updating car by ID
     *
     * @param car
     */
    @Override
    public void updateCar(Car car) {
        jdbcTemplate.update(UPDATE_CAR_SQL,
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getColor(),
                car.getId());
    }

    /**
     * Delete car where ID matching the
     * car object being passed in
     *
     * @param id
     */
    @Override
    public void deleteCar(int id) {
        jdbcTemplate.update(DELETE_CAR_SQL, id);
    }

    /**
     * Get all cars with given make
     *
     * @param make
     * @return
     */
    @Override
    public List<Car> getCarByMake(String make) {
        return jdbcTemplate.query(SELECT_CAR_BY_MAKE_SQL, this::mapRowToCar, make);
    }

    /**
     * Get all cars with given make
     *
     * @param color
     * @return
     */
    @Override
    public List<Car> getCarByColor(String color) {
        return jdbcTemplate.query(SELECT_CAR_BY_COLOR_SQL, this::mapRowToCar, color);
    }

    /**
     * Maps motorcycle table row to Motorcycle object
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    private Car mapRowToCar(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getString("year"));
        car.setColor(rs.getString("color"));
        return car;
    }

}

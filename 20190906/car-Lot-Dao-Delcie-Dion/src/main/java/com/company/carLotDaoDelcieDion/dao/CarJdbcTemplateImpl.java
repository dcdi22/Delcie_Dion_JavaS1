package com.company.carLotDaoDelcieDion.dao;

import com.company.carLotDaoDelcieDion.model.Car;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CarJdbcTemplateImpl implements CarDao {

    /**
     * Getting one car for the given id
     *
     * @param id
     * @return car
     */
    @Override
    public Car getcar(int id) {
        return null;
    }

    /**
     * Get all the cars
     *
     * @return List of cars
     */
    @Override
    public List<Car> getAllCars() {
        return null;
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
        return null;
    }

    /**
     * Updating car by ID
     *
     * @param car
     */
    @Override
    public void updateCar(Car car) {

    }

    /**
     * Delete car where ID matching the
     * car object being passed in
     *
     * @param id
     */
    @Override
    public void deleteCar(int id) {

    }

    /**
     * Get all cars with given make
     *
     * @param make
     * @return
     */
    @Override
    public List<Car> getCarByMake(String make) {
        return null;
    }

    /**
     * Get all cars with given make
     *
     * @param color
     * @return
     */
    @Override
    public List<Car> getCarByColor(String color) {
        return null;
    }
}

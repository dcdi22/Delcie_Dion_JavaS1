package com.company.carLotDaoDelcieDion.dao;

import com.company.carLotDaoDelcieDion.model.Car;

import java.util.List;

public interface CarDao {

    /**
     * Getting one car for the given id
     * @param id
     * @return car
     */
    Car getcar(int id);


    /**
     * Get all the cars
     * @return List of cars
     */
    List<Car> getAllCars();


    /**
     * Adds the given car to the DB
     * @param car
     * @return
     */
    Car addCar(Car car);


    /**
     * Updating car by ID
     * @param car
     */
    void updateCar(Car car);


    /**
     * Delete car where ID matching the
     * car object being passed in
     * @param id
     */
    void deleteCar(int id);

    /**
     * Get all cars with given make
     * @param make
     * @return
     */
    List<Car> getCarByMake(String make);

    /**
     * Get all cars with given make
     * @param color
     * @return
     */
    List<Car> getCarByColor(String color);
}

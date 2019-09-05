package com.company.carLotDaoDelcieDion.dao;

import com.company.carLotDaoDelcieDion.model.Car;
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
public class CarDaoTest {

    @Autowired
    protected CarDao dao;

    @Before
    public void setUp() throws Exception {
        List<Car> carList = dao.getAllCars();
        carList.stream()
                .forEach(car -> dao.deleteCar(car.getId()));
    }

    @Test
    public void getcar() {
        Car car = new Car();

    }

    @Test
    public void getAllCars() {
    }

    @Test
    public void addCar() {
    }

    @Test
    public void updateCar() {
    }

    @Test
    public void deleteCar() {
    }

    @Test
    public void getCarByMake() {
    }

    @Test
    public void getCarByColor() {
    }
}
package com.company.carLotDaoDelcieDion.dao;

import com.company.carLotDaoDelcieDion.model.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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
    public void addGetDeleteCar() {
        Car car = new Car();
        car.setMake("Ford");
        car.setModel("Mustang");
        car.setYear("2012");
        car.setColor("Blue");
        car = dao.addCar(car);

        Car car2 = dao.getcar(car.getId());

        assertEquals(car, car2);

        dao.deleteCar(car.getId());
        car2 = dao.getcar(car.getId());
        assertNull(car2);
    }

    @Test
    public void getAllCars() {
        Car car = new Car();
        car.setMake("Ford");
        car.setModel("Mustang");
        car.setYear("2012");
        car.setColor("Blue");
        car = dao.addCar(car);

        Car car2 = new Car();
        car2.setMake("Ford");
        car2.setModel("Fiesta");
        car2.setYear("2030");
        car2.setColor("Blue");
        car2 = dao.addCar(car2);

        List<Car> carList = new ArrayList<>();
        carList.add(car);
        carList.add(car2);

        List<Car> carList2 = dao.getAllCars();

        assertEquals(carList.size(), carList2.size());


    }

    @Test
    public void updateCar() {
        Car car = new Car();
        car.setMake("Ford");
        car.setModel("Mustang");
        car.setYear("2012");
        car.setColor("Blue");
        car = dao.addCar(car);

        car.setMake("NEW MAKE");
        car.setModel("Fiesta");
        car.setYear("1000");
        car.setColor("NEW COLOR");
        dao.addCar(car);

        Car car2 = dao.getcar(car.getId());
        assertEquals(car, car2);
    }

    @Test
    public void getCarByMake() {
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Africa Twin");
        car.setYear("2019");
        car.setColor("black");
        dao.addCar(car);

        car.setMake("Chevy");
        car.setModel("Camaro");
        car.setYear("2019");
        car.setColor("black");
        dao.addCar(car);

        car.setMake("Chevy");
        car.setModel("Camaro");
        car.setYear("1976");
        car.setColor("blue");
        dao.addCar(car);

        List<Car> carList = dao.getCarByMake("Chevy");
        assertEquals(2, carList.size());
    }

    @Test
    public void getCarByColor() {
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Africa Twin");
        car.setYear("2019");
        car.setColor("black");
        dao.addCar(car);

        car.setMake("Chevy");
        car.setModel("Camaro");
        car.setYear("2019");
        car.setColor("black");
        dao.addCar(car);

        car.setMake("Chevy");
        car.setModel("Camaro");
        car.setYear("1976");
        car.setColor("blue");
        dao.addCar(car);

        List<Car> carList = dao.getCarByColor("black");
        assertEquals(2, carList.size());
    }
}
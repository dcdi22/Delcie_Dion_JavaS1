package com.company.DelcieDionCarLotJpaRepository.dao;

import com.company.DelcieDionCarLotJpaRepository.dto.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Before
    public void setUp() throws Exception {
        carRepository.deleteAll();
    }

    @Test
    public void addGetDeleteCar() {
//        carRepository.deleteAll();
        Car car = new Car();
        car.setMake("Ford");
        car.setModel("Mustang");
        car.setYear("2012");
        car.setColor("Blue");
        carRepository.save(car);

        Car car1 = carRepository.findOne(car.getId());

        assertEquals(car1, car);

        carRepository.delete(car);

        car1 = carRepository.findOne(car.getId());

        assertNull(car1);
    }

    @Test
    public void getAllCars() {
        Car car = new Car();
        car.setMake("Ford");
        car.setModel("Mustang");
        car.setYear("2012");
        car.setColor("Blue");
        carRepository.save(car);

        car = new Car();
        car.setMake("Ford");
        car.setModel("Fiesta");
        car.setYear("2030");
        car.setColor("Blue");
        carRepository.save(car);

        List<Car> carList = carRepository.findAll();

        assertEquals(2, carList.size());
    }

    @Test
    @Transactional
    public void updateCar() {
        Car car = new Car();
        car.setMake("Ford");
        car.setModel("Mustang");
        car.setYear("2012");
        car.setColor("Blue");
        carRepository.save(car);

        car.setMake("NEW MAKE");
        car.setModel("NEW MODEL");

        carRepository.save(car);

        Car car1 = carRepository.getOne(car.getId());

        assertEquals(car1, car);

    }

    @Test
    public void getMake() {
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Africa Twin");
        car.setYear("2019");
        car.setColor("black");
        carRepository.save(car);

        car = new Car();
        car.setMake("Chevy");
        car.setModel("Camaro");
        car.setYear("2019");
        car.setColor("black");
        carRepository.save(car);

        car = new Car();
        car.setMake("Chevy");
        car.setModel("Camaro");
        car.setYear("1976");
        car.setColor("blue");
        carRepository.save(car);

        List<Car> carList = carRepository.findByMake("Chevy");
        assertEquals(2, carList.size());
    }

    @Test
    public void getColor () {
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Africa Twin");
        car.setYear("2019");
        car.setColor("black");
        carRepository.save(car);

        car = new Car();
        car.setMake("Chevy");
        car.setModel("Camaro");
        car.setYear("2019");
        car.setColor("black");
        carRepository.save(car);

        car = new Car();
        car.setMake("Chevy");
        car.setModel("Camaro");
        car.setYear("1976");
        car.setColor("blue");
        carRepository.save(car);

        List<Car> carList = carRepository.findByColor("black");
        assertEquals(2, carList.size());
    }

    @Test
    public void getMakeAndColor() {
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Africa Twin");
        car.setYear("2019");
        car.setColor("black");
        carRepository.save(car);

        car = new Car();
        car.setMake("Chevy");
        car.setModel("Camaro");
        car.setYear("2019");
        car.setColor("black");
        carRepository.save(car);

        car = new Car();
        car.setMake("Chevy");
        car.setModel("Camaro");
        car.setYear("1976");
        car.setColor("blue");
        carRepository.save(car);

        List<Car> carList = carRepository.findByMakeAndColor("Chevy", "blue");
        assertEquals(1, carList.size());
    }
}
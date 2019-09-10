package com.company.DelcieDionCoffeeInventoryJpaRepository.dao;

import com.company.DelcieDionCoffeeInventoryJpaRepository.dto.Coffee;
import com.company.DelcieDionCoffeeInventoryJpaRepository.dto.Roaster;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Proxy;
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
//@Transactional // recently added
public class CoffeeRepositoryTest {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private RoasterRepository roasterRepository;

    @Before
    public void setUp() throws Exception {
        coffeeRepository.deleteAll();
        roasterRepository.deleteAll();
    }

    @Test
    public void addGetDeleteCoffee() {
        Roaster roaster = new Roaster();
        roaster.setName("Delcie");
        roaster.setStreet("street way");
        roaster.setCity("city");
        roaster.setState("ga");
        roaster.setPostal_code("12345");
        roaster.setPhone("4047070808");
        roaster.setEmail("person@gmail.com");
        roaster.setNote("Hiiiiiiiii");
        roasterRepository.save(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("yummy");
        coffee.setCount(40);
        coffee.setUnit_price(4.66);
        coffee.setDescription("brown water bitter");
        coffee.setType("Medium Roast");
        coffeeRepository.save(coffee);

//        Hibernate.initialize(coffee.getId());
        Coffee coffee1 = coffeeRepository.findOne(coffee.getId());
        /*
        The difference between getOne and findOne is that the first always returns a lazy proxy, even if there is no actual row in the database. The lazy proxy needs an open EntityManager to operate on. However as your test method doesn't run in a single transaction the EntityManager will be closed as soon as the getOne method ends.

Without an open EntityManager calls on the object will fail as it cannot retrieve the values from the database anymore.

To solve use findOne instead of getOne OR make your test method transactional. The latter however has some other effects on your test-case (it will return the same object from the findOne call as it will also reuse a single EntityManager).
         */

        assertEquals(coffee1, coffee);

        coffeeRepository.delete(coffee.getId());

        coffee1 = coffeeRepository.findOne(coffee.getId());

        assertNull(coffee1);

    }

    @Test
    public void getAllCoffee() {
        Roaster roaster = new Roaster();
        roaster.setName("Delcie");
        roaster.setStreet("street way");
        roaster.setCity("city");
        roaster.setState("ga");
        roaster.setPostal_code("12345");
        roaster.setPhone("4047070808");
        roaster.setEmail("person@gmail.com");
        roaster.setNote("Hiiiiiiiii");
        roasterRepository.save(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("yummy");
        coffee.setCount(40);
        coffee.setUnit_price(4.66);
        coffee.setDescription("brown water bitter");
        coffee.setType("Medium Roast");
        coffeeRepository.save(coffee);

        coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("2ND");
        coffee.setCount(80);
        coffee.setUnit_price(6.66);
        coffee.setDescription("brown water bitter");
        coffee.setType("Dark Roast");
        coffeeRepository.save(coffee);

        List<Coffee> coffeeList = coffeeRepository.findAll();
        assertEquals(2, coffeeList.size());
    }

    @Test
    public void getCoffeeByRoaster() {
        Roaster roaster = new Roaster();
        roaster.setName("Delcie");
        roaster.setStreet("street way");
        roaster.setCity("city");
        roaster.setState("ga");
        roaster.setPostal_code("12345");
        roaster.setPhone("4047070808");
        roaster.setEmail("person@gmail.com");
        roaster.setNote("Hiiiiiiiii");
        roasterRepository.save(roaster);

        Roaster roaster1 = new Roaster();
        roaster1.setName("Michelle");
        roaster1.setStreet("street way");
        roaster1.setCity("city");
        roaster1.setState("ga");
        roaster1.setPostal_code("12345");
        roaster1.setPhone("4047070808");
        roaster1.setEmail("person@gmail.com");
        roaster1.setNote("Byeeeeeee");
        roasterRepository.save(roaster1);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("yummy");
        coffee.setCount(40);
        coffee.setUnit_price(4.66);
        coffee.setDescription("brown water bitter");
        coffee.setType("Medium Roast");
        coffeeRepository.save(coffee);

        Coffee coffee1 = new Coffee();
        coffee1.setRoasterId(roaster1.getId());
        coffee1.setName("2ND");
        coffee1.setCount(40);
        coffee1.setUnit_price(4.66);
        coffee1.setDescription("brown water bitter");
        coffee1.setType("Dark Roast");
        coffeeRepository.save(coffee);

        List<Coffee> coffeeList = coffeeRepository.findByRoasterId(roaster.getId());

        assertEquals(1, coffeeList.size());
    }

    @Test
    public void getCoffeeByType(){
        Roaster roaster = new Roaster();
        roaster.setName("Delcie");
        roaster.setStreet("street way");
        roaster.setCity("city");
        roaster.setState("ga");
        roaster.setPostal_code("12345");
        roaster.setPhone("4047070808");
        roaster.setEmail("person@gmail.com");
        roaster.setNote("Hiiiiiiiii");
        roasterRepository.save(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("yummy");
        coffee.setCount(40);
        coffee.setUnit_price(4.66);
        coffee.setDescription("brown water bitter");
        coffee.setType("Medium Roast");
        coffeeRepository.save(coffee);

        Coffee coffee1 = new Coffee();
        coffee1.setRoasterId(roaster.getId());
        coffee1.setName("2ND");
        coffee1.setCount(40);
        coffee1.setUnit_price(4.66);
        coffee1.setDescription("brown water bitter");
        coffee1.setType("Dark Roast");
        coffeeRepository.save(coffee1);

        List<Coffee> coffeeList = coffeeRepository.findByType("Dark Roast");

        assertEquals(1, coffeeList.size());
    }

    @Test
    public void getCoffeeByRoasterAndType() {
        Roaster roaster = new Roaster();
        roaster.setName("Delcie");
        roaster.setStreet("street way");
        roaster.setCity("city");
        roaster.setState("ga");
        roaster.setPostal_code("12345");
        roaster.setPhone("4047070808");
        roaster.setEmail("person@gmail.com");
        roaster.setNote("Hiiiiiiiii");
        roasterRepository.save(roaster);

        Roaster roaster1 = new Roaster();
        roaster1.setName("Michelle");
        roaster1.setStreet("street way");
        roaster1.setCity("city");
        roaster1.setState("ga");
        roaster1.setPostal_code("12345");
        roaster1.setPhone("4047070808");
        roaster1.setEmail("person@gmail.com");
        roaster1.setNote("Byeeeeeee");
        roasterRepository.save(roaster1);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("yummy");
        coffee.setCount(40);
        coffee.setUnit_price(4.66);
        coffee.setDescription("brown water bitter");
        coffee.setType("Medium Roast");
        coffeeRepository.save(coffee);

        Coffee coffee1 = new Coffee();
        coffee1.setRoasterId(roaster1.getId());
        coffee1.setName("2ND");
        coffee1.setCount(40);
        coffee1.setUnit_price(4.66);
        coffee1.setDescription("brown water bitter");
        coffee1.setType("Dark Roast");
        coffeeRepository.save(coffee);

        List<Coffee> coffeeList = coffeeRepository.findByRoasterIdAndType(roaster.getId(), "Dark Roast");

        assertEquals(0, coffeeList.size());
    }

    @Test
    @Transactional // Had to add Transactional to get it to work
    public void updateCoffee() {
        Roaster roaster = new Roaster();
        roaster.setName("Delcie");
        roaster.setStreet("street way");
        roaster.setCity("city");
        roaster.setState("ga");
        roaster.setPostal_code("12345");
        roaster.setPhone("4047070808");
        roaster.setEmail("person@gmail.com");
        roaster.setNote("Hiiiiiiiii");
        roasterRepository.save(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("yummy");
        coffee.setCount(40);
        coffee.setUnit_price(4.66);
        coffee.setDescription("brown water bitter");
        coffee.setType("Medium Roast");
        coffeeRepository.save(coffee);

        coffee.setName("NEW NAME");
        coffee.setDescription("NEW DESCRIPTION");

        coffeeRepository.save(coffee);

        Coffee coffee1 = coffeeRepository.getOne(coffee.getId());

        assertEquals(coffee1, coffee);

    }

}
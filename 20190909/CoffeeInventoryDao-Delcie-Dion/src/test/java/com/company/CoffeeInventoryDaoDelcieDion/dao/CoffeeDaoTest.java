package com.company.CoffeeInventoryDaoDelcieDion.dao;

import com.company.CoffeeInventoryDaoDelcieDion.model.Coffee;
import com.company.CoffeeInventoryDaoDelcieDion.model.Roaster;
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
public class CoffeeDaoTest {

    @Autowired
    CoffeeDao coffeeDao;
    @Autowired
    RoasterDao roasterDao;

    @Before
    public void setUp() throws Exception {
        List<Coffee> coffeeList = coffeeDao.getAllCoffee();
        for (Coffee c: coffeeList) {
            coffeeDao.deleteCoffee(c.getId());
        }

        List<Roaster> roasterList = roasterDao.getAllRoasters();
        for (Roaster r: roasterList) {
            roasterDao.deleteRoaster(r.getId());
        }
    }

    /*
    roaster_id int not null,
    name varchar(50) not null,
    count int not null,
    unit_price decimal(5,2) not null,
    description varchar(255),
    type varchar(50)
     */

    /*
    name varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state char(2) not null,
    postal_code varchar(25) not null,
    phone varchar(15) not null,
    email varchar(60) not null,
    note varchar(255)
     */

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
        roaster = roasterDao.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("yummy");
        coffee.setCount(40);
        coffee.setUnit_price(4.66);
        coffee.setDescription("brown water bitter");
        coffee.setType("Medium Roast");
        coffee = coffeeDao.addCoffee(coffee);

        Coffee coffee1 = coffeeDao.getCoffee(coffee.getId());

        assertEquals(coffee, coffee1);

        coffeeDao.deleteCoffee(coffee.getId());

        coffee1 = coffeeDao.getCoffee(coffee.getId());

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
        roaster = roasterDao.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("yummy");
        coffee.setCount(40);
        coffee.setUnit_price(4.66);
        coffee.setDescription("brown water bitter");
        coffee.setType("Medium Roast");
        coffee = coffeeDao.addCoffee(coffee);

        coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("2ND");
        coffee.setCount(80);
        coffee.setUnit_price(6.66);
        coffee.setDescription("brown water bitter");
        coffee.setType("Dark Roast");
        coffee = coffeeDao.addCoffee(coffee);

        List<Coffee> coffeeList = coffeeDao.getAllCoffee();

        assertEquals(coffeeList.size(), 2);
    }

    @Test
    public void getCoffeeByType() {
        Roaster roaster = new Roaster();
        roaster.setName("Delcie");
        roaster.setStreet("street way");
        roaster.setCity("city");
        roaster.setState("ga");
        roaster.setPostal_code("12345");
        roaster.setPhone("4047070808");
        roaster.setEmail("person@gmail.com");
        roaster.setNote("Hiiiiiiiii");
        roaster = roasterDao.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("yummy");
        coffee.setCount(40);
        coffee.setUnit_price(4.66);
        coffee.setDescription("brown water bitter");
        coffee.setType("Medium Roast");
        coffee = coffeeDao.addCoffee(coffee);

        Coffee coffee1 = new Coffee();
        coffee1.setRoasterId(roaster.getId());
        coffee1.setName("2ND");
        coffee1.setCount(40);
        coffee1.setUnit_price(4.66);
        coffee1.setDescription("brown water bitter");
        coffee1.setType("Dark Roast");
        coffee1 = coffeeDao.addCoffee(coffee1);

        List<Coffee> cList = coffeeDao.getCoffeeByType(coffee.getType());
        assertEquals(cList.size(),1);

        cList = coffeeDao.getCoffeeByType(coffee1.getType());
        assertEquals(cList.size(), 1);
    }

    @Test
    public void getCoffeByRoaster() {
        Roaster roaster = new Roaster();
        roaster.setName("Delcie");
        roaster.setStreet("street way");
        roaster.setCity("city");
        roaster.setState("ga");
        roaster.setPostal_code("12345");
        roaster.setPhone("4047070808");
        roaster.setEmail("person@gmail.com");
        roaster.setNote("Hiiiiiiiii");
        roaster = roasterDao.addRoaster(roaster);

        Roaster roaster1 = new Roaster();
        roaster1.setName("Michelle");
        roaster1.setStreet("street way");
        roaster1.setCity("city");
        roaster1.setState("ga");
        roaster1.setPostal_code("12345");
        roaster1.setPhone("4047070808");
        roaster1.setEmail("person@gmail.com");
        roaster1.setNote("Byeeeeeee");
        roaster1 = roasterDao.addRoaster(roaster1);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("yummy");
        coffee.setCount(40);
        coffee.setUnit_price(4.66);
        coffee.setDescription("brown water bitter");
        coffee.setType("Medium Roast");
        coffee = coffeeDao.addCoffee(coffee);

        Coffee coffee1 = new Coffee();
        coffee1.setRoasterId(roaster1.getId());
        coffee1.setName("2ND");
        coffee1.setCount(40);
        coffee1.setUnit_price(4.66);
        coffee1.setDescription("brown water bitter");
        coffee1.setType("Dark Roast");
        coffee1 = coffeeDao.addCoffee(coffee1);

        List<Coffee> cList = coffeeDao.getCoffeByRoaster(coffee.getRoasterId());
        assertEquals(cList.size(),1);

        cList = coffeeDao.getCoffeByRoaster(coffee1.getRoasterId());
        assertEquals(cList.size(), 1);
    }

    @Test
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
        roaster = roasterDao.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("yummy");
        coffee.setCount(40);
        coffee.setUnit_price(4.66);
        coffee.setDescription("brown water bitter");
        coffee.setType("Medium Roast");
        coffee = coffeeDao.addCoffee(coffee);

        coffee.setName("NEW NAME");
        coffee.setDescription("NEW DESCRIPTION");

        coffeeDao.updateCoffee(coffee);

        Coffee coffee1 = coffeeDao.getCoffee(coffee.getId());

        assertEquals(coffee1, coffee);
    }
}
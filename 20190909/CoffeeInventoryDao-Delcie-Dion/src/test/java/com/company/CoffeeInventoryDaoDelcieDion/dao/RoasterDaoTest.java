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
public class RoasterDaoTest {

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

    @Test
    public void addGetDeleteRoaster() {
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

        assertEquals(roaster1, roaster);

        roasterDao.deleteRoaster(roaster.getId());

        roaster1 = roasterDao.getRoaster(roaster.getId());

        assertNull(roaster1);
    }

    @Test
    public void getAllRoasters() {
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

        roaster = new Roaster();
        roaster.setName("Michelle");
        roaster.setStreet("street way");
        roaster.setCity("city");
        roaster.setState("ga");
        roaster.setPostal_code("12345");
        roaster.setPhone("4047070808");
        roaster.setEmail("person@gmail.com");
        roaster.setNote("Byeeeeeee");
        roasterDao.addRoaster(roaster);

        List<Roaster> rList = roasterDao.getAllRoasters();

        assertEquals(rList.size(),2);
    }

    @Test
    public void updateRoaster() {
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

        roaster.setName("Michelle");
        roaster.setStreet("street way");
        roaster.setCity("city");
        roaster.setState("ga");
        roaster.setPostal_code("12345");
        roaster.setPhone("4047070808");
        roaster.setEmail("person@gmail.com");
        roaster.setNote("Byeeeeeee");
        roasterDao.updateRoaster(roaster);

        Roaster roaster1 = roasterDao.getRoaster(roaster.getId());

        assertEquals(roaster1, roaster);
    }
}
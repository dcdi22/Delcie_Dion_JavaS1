package com.company.DelcieDionCoffeeInventoryJpaRepository.dao;

import com.company.DelcieDionCoffeeInventoryJpaRepository.dto.Coffee;
import com.company.DelcieDionCoffeeInventoryJpaRepository.dto.Roaster;
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
public class RoasterRepositoryTest {

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
    @Transactional
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
        roasterRepository.save(roaster);

        Roaster roaster1 = roasterRepository.findOne(roaster.getId());

        assertEquals(roaster1, roaster); //WHY YOU BROKEN UGGGHHH

        roasterRepository.delete(roaster.getId());

        roaster1 = roasterRepository.findOne(roaster.getId());

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
        roasterRepository.save(roaster);

        roaster = new Roaster();
        roaster.setName("Michelle");
        roaster.setStreet("street way");
        roaster.setCity("city");
        roaster.setState("ga");
        roaster.setPostal_code("12345");
        roaster.setPhone("4047070808");
        roaster.setEmail("person@gmail.com");
        roaster.setNote("Byeeeeeee");
        roasterRepository.save(roaster);

        List<Roaster> rList = roasterRepository.findAll();

        assertEquals(rList.size(),2);
    }

    @Test
    @Transactional
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
        roasterRepository.save(roaster);


        roaster.setName("Michelle");
        roasterRepository.save(roaster);

        Roaster roaster1 = roasterRepository.findOne(roaster.getId());

        assertEquals(roaster1, roaster);
    }
}
package com.company.CoffeeInventoryDaoDelcieDion.dao;

import com.company.CoffeeInventoryDaoDelcieDion.model.Coffee;

import java.util.List;

public interface CoffeeDao {

    Coffee addCoffee(Coffee coffee);

    Coffee getCoffee(int id);

    List<Coffee> getAllCoffee();

    List<Coffee> getCoffeeByType(String type);

    List<Coffee> getCoffeByRoaster(int roasterId);

    void updateCoffee(Coffee coffee);

    void deleteCoffee(int id);


}

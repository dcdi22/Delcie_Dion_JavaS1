package com.company.CoffeeInventoryDaoDelcieDion.dao;

import com.company.CoffeeInventoryDaoDelcieDion.model.Roaster;

import java.util.List;

public interface RoasterDao {

    Roaster addRoaster(Roaster roaster);

    Roaster getRoaster(int id);

    List<Roaster> getAllRoasters();

    void updateRoaster(Roaster roaster);

    void deleteRoaster(int id);

}

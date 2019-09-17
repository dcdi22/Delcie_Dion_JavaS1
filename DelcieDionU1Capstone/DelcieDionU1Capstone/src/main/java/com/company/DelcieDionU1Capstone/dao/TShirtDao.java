package com.company.DelcieDionU1Capstone.dao;

import com.company.DelcieDionU1Capstone.dto.TShirt;

import java.util.List;

public interface TShirtDao {

    TShirt getShirt(int tshirtId);

    List<TShirt> getAllShirts();

    List<TShirt> getShirtByColor(String color);

    List<TShirt> getShirtBySize(String size);

    TShirt addShirt(TShirt tShirt);

    void updateShirt(TShirt tShirt);

    void deleteShirt(int tshirtId);

}

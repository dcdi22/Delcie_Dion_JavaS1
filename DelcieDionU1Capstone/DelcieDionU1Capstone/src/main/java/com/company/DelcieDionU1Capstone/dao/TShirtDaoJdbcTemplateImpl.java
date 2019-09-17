package com.company.DelcieDionU1Capstone.dao;

import com.company.DelcieDionU1Capstone.dto.TShirt;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtDao {

    // Prepared Statements
    private static final String

    @Override
    public TShirt getShirt(int tshirtId) {
        return null;
    }

    @Override
    public List<TShirt> getAllShirts() {
        return null;
    }

    @Override
    public List<TShirt> getShirtByColor(String color) {
        return null;
    }

    @Override
    public List<TShirt> getShirtBySize(String size) {
        return null;
    }

    @Override
    public TShirt addShirt(TShirt tShirt) {
        return null;
    }

    @Override
    public void updateShirt(TShirt tShirt) {

    }

    @Override
    public void deleteShirt(int tshirtId) {

    }

    private TShirt mapRowToTShirt(ResultSet rs, int rowNum) throws SQLException {
        TShirt tShirt = new TShirt();
        tShirt.setTshirtId(rs.getInt("t_shirt_id"));
        tShirt.setSize(rs.getString("size"));
        tShirt.setColor(rs.getString("color"));
        tShirt.setDescription(rs.getString("description"));
        tShirt.setPrice(rs.getBigDecimal("price"));
        tShirt.setQuantity(rs.getInt("quantity"));
        return tShirt;
    }
 }

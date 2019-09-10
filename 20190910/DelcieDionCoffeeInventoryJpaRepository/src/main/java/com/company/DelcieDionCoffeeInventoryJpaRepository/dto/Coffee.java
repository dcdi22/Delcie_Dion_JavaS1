package com.company.DelcieDionCoffeeInventoryJpaRepository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "coffee")
public class Coffee {

    @Id // sets primary key
    @GeneratedValue( strategy = GenerationType.AUTO) // sets AutoIncrement
    private int id;
    private int roasterId;
    private String name;
    private int count;
    private double unit_price;
    private String description;
    private String type;

    public Coffee() {
    }

//    public Coffee(int id, int roasterId, String name, int count, double unit_price, String description, String type) {
//        this.id = id;
//        this.roasterId = roasterId;
//        this.name = name;
//        this.count = count;
//        this.unit_price = unit_price;
//        this.description = description;
//        this.type = type;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoasterId() {
        return roasterId;
    }

    public void setRoasterId(int roasterId) {
        this.roasterId = roasterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return id == coffee.id &&
                roasterId == coffee.roasterId &&
                count == coffee.count &&
                Double.compare(coffee.unit_price, unit_price) == 0 &&
                name.equals(coffee.name) &&
                Objects.equals(description, coffee.description) &&
                Objects.equals(type, coffee.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roasterId, name, count, unit_price, description, type);
    }
}

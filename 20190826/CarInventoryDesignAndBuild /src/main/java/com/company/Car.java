package com.company;
import com.opencsv.bean.CsvBindByName;

import java.util.*;

public class Car {

    @CsvBindByName(column = "Make")
    private String make;
    @CsvBindByName(column = "Model")
    private String model;
    @CsvBindByName(column = "Year")
    private int year;
    @CsvBindByName(column = "Color")
    private String color;
    @CsvBindByName(column = "Miles")
    private int miles;
    private static List<Car> carList = new ArrayList<>();



    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public static List<Car> getCarList() {
        return carList;
    }

    public static void setCarList(List<Car> carList) {
        Car.carList = carList;
    }

    public Car(String make, String model, int year, String color, int miles) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.miles = miles;
    }

    public Car() {
    }
}

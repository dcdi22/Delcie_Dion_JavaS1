package com.company;

public class Car {

    public String make;
    public String model;
    public String type;
    public String color;
    public String engine;
    public String transmission;
    public int numDoors;
    public double mpg;
    public int milesDriven;

    public void drive(int miles) {

    }

    public void honk() {

    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public double getMpg() {
        return mpg;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public int getMilesDriven() {
        return milesDriven;
    }

    public void setMilesDriven(int milesDriven) {
        this.milesDriven = milesDriven;
    }

    public Car(String make, String model, String type, String color, String engine, String transmission, int numDoors, double mpg, int milesDriven) {
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
        this.numDoors = numDoors;
        this.mpg = mpg;
        this.milesDriven = milesDriven;
    }



}

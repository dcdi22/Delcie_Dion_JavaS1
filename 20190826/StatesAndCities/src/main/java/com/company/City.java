package com.company;

import com.opencsv.bean.CsvBindByName;

import java.util.ArrayList;
import java.util.List;

public class City {
    // add a StateId , state name

    @CsvBindByName(column = "City Name")
    private String name;
    @CsvBindByName(column = "City Pop")
    private int population;
    @CsvBindByName(column = "Capital")
    private boolean isCapital;

//    private static List<City> cityList = new ArrayList<>();

    public City() {
    }

    public City(String name, int population, boolean isCapital) {
        this.name = name;
        this.population = population;
        this.isCapital = isCapital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }
}

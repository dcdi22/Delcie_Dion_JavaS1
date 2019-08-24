package com.company;

import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvBindByName;

public class State {

    @CsvBindByName(column = "State Name")
    private String name;
    @CsvBindByName(column = "State Pop")
    private int population;
    @CsvBindByName(column = "State City")
    private City city;

    private static List<State> stateList = new ArrayList<>();

    public State() {
    }

    public State(String name, int population, City city) {
        this.name = name;
        this.population = population;
        this.city = city;
    }

    public static List<State> getStateList() {
        return stateList;
    }

    public static void setStateList(List<State> stateList) {
        State.stateList = stateList;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

package com.company.cityWebService.Model;

public class City {

    private String name;
    private String state;
    private int population;
    private boolean isCapital;

//    private List<City> cityList = new ArrayList<>();


    public City() {
    }

    public City(String name, String state, int population, boolean isCapital) {
        this.name = name;
        this.state = state;
        this.population = population;
        this.isCapital = isCapital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

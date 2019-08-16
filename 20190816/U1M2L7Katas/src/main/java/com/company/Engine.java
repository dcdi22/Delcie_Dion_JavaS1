package com.company;

public class Engine {

    private boolean airPressure;
    private boolean fuel;

    public boolean isAirPressure() {
        return airPressure;
    }

    public void setAirPressure(boolean airPressure) {
        this.airPressure = airPressure;
    }

    public boolean isFuel() {
        return fuel;
    }

    public void setFuel(boolean fuel) {
        this.fuel = fuel;
    }

    public Engine() {
    }
}

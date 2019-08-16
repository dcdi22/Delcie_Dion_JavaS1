package com.company;

public class Transmission {

    private boolean solenoid;
    private boolean fuel;

    public boolean isSolenoid() {
        return solenoid;
    }

    public void setSolenoid(boolean solenoid) {
        this.solenoid = solenoid;
    }

    public boolean isFuel() {
        return fuel;
    }

    public void setFuel(boolean fuel) {
        this.fuel = fuel;
    }

    public Transmission() {
    }
}

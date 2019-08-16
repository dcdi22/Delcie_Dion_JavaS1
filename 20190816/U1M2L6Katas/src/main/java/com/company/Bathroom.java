package com.company;

public class Bathroom extends Home {

    private boolean hasTub;
    private boolean hasStandUpShower;
    private boolean hasStorage;
    private int numOfDrawers;

    public boolean shower(boolean water, boolean hasShower){
        return true;
    }

    public boolean brushTeeth(boolean hasBrush, boolean hasWater, boolean hasTeeth) {
        return true;
    }

    public Bathroom() {
    }

    public boolean isHasTub() {
        return hasTub;
    }

    public void setHasTub(boolean hasTub) {
        this.hasTub = hasTub;
    }

    public boolean isHasStandUpShower() {
        return hasStandUpShower;
    }

    public void setHasStandUpShower(boolean hasStandUpShower) {
        this.hasStandUpShower = hasStandUpShower;
    }

    public boolean isHasStorage() {
        return hasStorage;
    }

    public void setHasStorage(boolean hasStorage) {
        this.hasStorage = hasStorage;
    }

    public int getNumOfDrawers() {
        return numOfDrawers;
    }

    public void setNumOfDrawers(int numOfDrawers) {
        this.numOfDrawers = numOfDrawers;
    }
}

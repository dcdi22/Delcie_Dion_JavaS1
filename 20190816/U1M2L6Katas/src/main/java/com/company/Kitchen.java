package com.company;

public class Kitchen extends Home {

    private boolean hasIsland;
    private String counterType;
    private String cabinetColor;
    private int numOfCabinets;
    private int numOfSinks;
    private boolean hasDishwasher;

    public String makeDinner(int numIngredients) {
        return "warm food";
    }

    public boolean doDishes(int numOfDirtyDishes) {
        return true;
    }

    public Kitchen() {
    }

    public boolean isHasIsland() {
        return hasIsland;
    }

    public void setHasIsland(boolean hasIsland) {
        this.hasIsland = hasIsland;
    }

    public String getCounterType() {
        return counterType;
    }

    public void setCounterType(String counterType) {
        this.counterType = counterType;
    }

    public String getCabinetColor() {
        return cabinetColor;
    }

    public void setCabinetColor(String cabinetColor) {
        this.cabinetColor = cabinetColor;
    }

    public int getNumOfCabinets() {
        return numOfCabinets;
    }

    public void setNumOfCabinets(int numOfCabinets) {
        this.numOfCabinets = numOfCabinets;
    }

    public int getNumOfSinks() {
        return numOfSinks;
    }

    public void setNumOfSinks(int numOfSinks) {
        this.numOfSinks = numOfSinks;
    }

    public boolean isHasDishwasher() {
        return hasDishwasher;
    }

    public void setHasDishwasher(boolean hasDishwasher) {
        this.hasDishwasher = hasDishwasher;
    }
}

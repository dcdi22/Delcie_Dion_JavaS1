package com.company;

public class Backyard extends Home {

    private String landscapeType;
    private boolean hasPool;
    private boolean hasDeck;

    public void mowLawn(boolean grassLong) {

    }

    public void goSwimming(boolean hasPool) {

    }

    public String getLandscapeType() {
        return landscapeType;
    }

    public void setLandscapeType(String landscapeType) {
        this.landscapeType = landscapeType;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public boolean isHasDeck() {
        return hasDeck;
    }

    public void setHasDeck(boolean hasDeck) {
        this.hasDeck = hasDeck;
    }

    public Backyard() {
    }
}

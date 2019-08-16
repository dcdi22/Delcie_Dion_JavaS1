package com.company;

public class Bedroom extends Home {

    private boolean isMaster;
    private boolean hasBed;
    private int numOfClosets;
    private boolean hasCeilingFan;

    public void myBedroom(boolean isMaster) {

    }

    public void sleep(boolean hasBed) {

    }

    public Bedroom() {
    }

    public boolean isMaster() {
        return isMaster;
    }

    public void setMaster(boolean master) {
        isMaster = master;
    }

    public boolean isHasBed() {
        return hasBed;
    }

    public void setHasBed(boolean hasBed) {
        this.hasBed = hasBed;
    }

    public int getNumOfClosets() {
        return numOfClosets;
    }

    public void setNumOfClosets(int numOfClosets) {
        this.numOfClosets = numOfClosets;
    }

    public boolean isHasCeilingFan() {
        return hasCeilingFan;
    }

    public void setHasCeilingFan(boolean hasCeilingFan) {
        this.hasCeilingFan = hasCeilingFan;
    }
}

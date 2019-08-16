package com.company;

public class Basement extends Home {

    private boolean isFinished;
    private boolean isScary;

    public  boolean liveInBasement(boolean isFinished){
        return true;
    }

    public boolean storeJunk(boolean isLivedIn) {
        return false;
    }

    public Basement() {
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean isScary() {
        return isScary;
    }

    public void setScary(boolean scary) {
        isScary = scary;
    }
}

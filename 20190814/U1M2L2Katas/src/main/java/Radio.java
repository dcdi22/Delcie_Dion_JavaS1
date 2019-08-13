package com.company;

public class Radio {

    public String manufacturer;
    public String model;
    public int numSpeaker;
    public String station;
    public int volume;
    public boolean powered;

    public void togglePower() {

    }

    public String getManufacturer(){
        return manufacturer;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public int getNumSpeakers() {
        return numSpeaker;
    }

    public void setNumSpeaker(int numSpeaker){
        this.numSpeaker = numSpeaker;
    }

    public String getStation(){
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public int getVolume(){
        return volume;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    public boolean isPowered() {
        return powered;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }

    public Radio(String manufacturer, String model, int numSpeaker, String station, int volume, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.numSpeaker = numSpeaker;
        this.station = station;
        this.volume = volume;
        this.powered = powered;
    }

}

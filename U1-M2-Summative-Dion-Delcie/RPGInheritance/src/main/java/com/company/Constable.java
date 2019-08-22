package com.company;

public class Constable extends BaseClass {

    // This is a child class that extends BaseClass and inherits all it's properties and methods

    /*
    Steps
    1. Add properties/ variables
    2. Add any necessary methods
    3. Generate getters
    4. Generate setters
    5. Make a default constructor
     */

    private int strength = 60;
    private int stamina = 60;
    private int speed = 20;
    private int attackPower = 5;
    private boolean jurisdiction;

    public void arrest() {
        System.out.println("You are under arrest");
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public boolean isJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(boolean jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public Constable() {
    }

    // Write super() in Constructor;??
}

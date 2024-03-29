package com.company;

public class Warrior extends BaseClass {

    // This is a child class that extends BaseClass and inherits all it's properties and methods

    /*
    Steps
    1. Add properties/ variables
    2. Add any necessary methods
    3. Generate getters
    4. Generate setters
    5. Make a default constructor
     */

    private int strength = 75;
    private int stamina = 100;
    private int speed = 50;
    private int attackPower = 10;
    private int shieldStrength = 100;

    public void decreaseShieldStrength() {
        System.out.println("I'm decreasing your shield strength");
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

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    public Warrior() {
    }

    // Write super() in Constructor;??
}

package com.company;

public class Farmer extends BaseClass {

    private int strength = 75;
    private int stamina = 75;
    private int speed = 10;
    private int attackPower = 1;

    public void plow() {
        System.out.println("Plowing the field");
    }

    public void harvest() {
        System.out.println("Harvesting the crop");
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

    public Farmer() {
    }

    // Write super() in Constructor;??
}

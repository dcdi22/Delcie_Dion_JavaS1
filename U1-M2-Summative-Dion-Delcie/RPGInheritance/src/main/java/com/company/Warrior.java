package com.company;

public class Warrior extends BaseClass {

    private int strength = 75;
    private int stamina = 100;
    private int speed = 50;
    private int attackPower = 10;
    private int shieldStrength = 100;

    public void decreaseShieldStrength() {
        System.out.println("I'm decreasing your shield strength");
    }

}

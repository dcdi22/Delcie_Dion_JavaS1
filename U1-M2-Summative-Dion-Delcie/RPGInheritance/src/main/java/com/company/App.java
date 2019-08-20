package com.company;

public class App {
    public static void main(String[] args) {
        Farmer joe = new Farmer();
        int healthPoints = joe.getHealth();
        System.out.println(healthPoints);
    }
}

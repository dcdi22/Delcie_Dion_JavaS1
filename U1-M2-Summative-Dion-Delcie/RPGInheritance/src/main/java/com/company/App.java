package com.company;

public class App {
    public static void main(String[] args) {
        /*
        I don't think this App class is necessary according to the instructions,
        however I wanted a public main to make sure my objects' methods could be accessed.
         */
        Farmer joe = new Farmer();
        int healthPoints = joe.getHealth();
        System.out.println(healthPoints);
    }
}

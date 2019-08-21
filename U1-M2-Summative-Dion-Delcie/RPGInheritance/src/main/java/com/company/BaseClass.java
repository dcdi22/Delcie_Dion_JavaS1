package com.company;

public class BaseClass {

    /*
    Shared values

    Properties / variables
    - name
    - health (initial value = 100)

    Abilities / methods
    - run
    - attack
    - heal
    - decreaseHealth
    - increaseStamina
    - decreaseStamina
     */

    // =====================================================

    /*
    Steps
    1. Add properties/ variables
    2. Add any necessary methods
    3. Generate getters
    4. Generate setters
    5. Make a default constructor
     */

    private String name;
    private int health = 100;

    public void run() {
        System.out.println("You are running");
    }

    public void attack() {
        System.out.println("You are attacking");
    }

    public void heal() {
        System.out.println("You are healing");
    }

    public void decreaseHealth() {
        System.out.println("Your health has decreased");
    }

    public void increaseStamina() {
        System.out.println("Your stamina is increasing");
    }

    public void decreaseStamina() {
        System.out.println("Your  stamina is decreasing");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public BaseClass() {
    }
}

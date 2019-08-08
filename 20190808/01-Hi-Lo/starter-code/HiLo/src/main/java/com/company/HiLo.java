package com.company;

import java.util.Scanner;
import java.util.Random;

public class HiLo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomGen = new Random();

        // Step 1
        System.out.println("Welcome to Hi-Low!");

        // Step 2
        System.out.println("Please give me your name");
        String name = scan.nextLine();

        // Step 3
        System.out.format("OK, %s, here are the rules:", name);

        // Step 4
        // a.
        int randomInt = randomGen.nextInt(100) + 1;
        int userGuess;
        int numberOfGuesses = 1;
        // b. do while???
        do {
        System.out.println("Please Guess a number 1 - 100");
        userGuess = Integer.parseInt(scan.nextLine());
            if (randomInt == userGuess) {
                System.out.format("Congratulations, %s! You win! \n", name);
                System.out.format("It took you %d guesses to find my number!", numberOfGuesses);
            } else if (randomInt > userGuess) {
                System.out.println("Too Low");
            } else if (randomInt < userGuess) {
                System.out.println("Too high");
            } else {
                System.out.println("You did not choose a number between 1-100");
            }
        numberOfGuesses++;
        } while (randomInt != userGuess);







    }
}

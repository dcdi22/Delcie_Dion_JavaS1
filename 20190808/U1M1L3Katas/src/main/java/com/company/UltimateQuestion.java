package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int num = 42;
        int userInput;

        do {
            System.out.println("Please enter a number between 1 - 100");
            userInput = Integer.parseInt(scan.nextLine());
        } while (num != userInput);
        System.out.println("That's the number I was looking for! 42 is definitely the answer!");

    }
}

package com.company;

import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Player 1's salary, do not use dollar signs or commas.");
        int p1 = Integer.parseInt(scan.nextLine());

        System.out.println("Enter Player 2's salary, do not use dollar signs or commas.");
        int p2 = Integer.parseInt(scan.nextLine());

        System.out.println("Enter Player 3's salary, do not use dollar signs or commas.");
        int p3 = Integer.parseInt(scan.nextLine());

        int playerTotal = p1 + p2 + p3;
        System.out.println("Player total cost is: " + playerTotal);

        if (playerTotal > 40000000) {

             // get playsTotal subtract 40,000,000 get that answer and multiple it by .18
            double luxTax = (playerTotal - 40000000) * .18;
            System.out.println("Your luxury tax is: " + String.format("%.2f", luxTax));

        } else {
            System.out.println("You did not go over your spending limit.");
        }

    }
}

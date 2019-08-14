package com.company;

import java.util.Scanner;
import java.util.Random;

public class threeCardMonte {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomGenerator = new Random();

        int ace = randomGenerator.nextInt(3) + 1;
//        String foundAce = "AA\n" +
//                          "AA";
//        String cup = "##\n" +
//                     "##";
//        System.out.println(foundAce);

        System.out.println("You slide up to Fast Eddie's card table and plop down your cash\n" +
                "He glances at you out of the corner of his eye and starts shuffling.\n" +
                "He lays down three cards \n \n" +
                "Which one is the ace? \n \n" +
                "\t ##  ##  ##\n" +
                "\t ##  ##  ##\n" +
                "\t 1   2   3");
        int guess = Integer.parseInt(scan.nextLine());
//        System.out.println(ace);
//        System.out.println(guess);

        if(ace == guess && ace == 1) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n");
            System.out.println("\t AA  ##  ##\n" +
                               "\t AA  ##  ##\n" +
                               "\t 1   2   3");
        } else if(ace == guess && ace == 2) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n");
            System.out.println("\t ##  AA  ##\n" +
                    "\t ##  AA  ##\n" +
                    "\t 1   2   3");
        } else if(ace == guess && ace == 3) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n");
            System.out.println("\t ##  ##  AA\n" +
                    "\t ##  ##  AA\n" +
                    "\t 1   2   3");
        } else if(ace != guess && ace == 1) {
            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + ace + ".\n");
            System.out.println("\t AA  ##  ##\n" +
                    "\t AA  ##  ##\n" +
                    "\t 1   2   3");
        } else if(ace != guess && ace == 2) {
            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + ace + ".\n");
            System.out.println("\t ##  AA  ##\n" +
                    "\t ##  AA  ##\n" +
                    "\t 1   2   3");
        } else if(ace != guess && ace == 3) {
            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + ace + ".\n");
            System.out.println("\t ##  ##  AA\n" +
                    "\t ##  ##  AA\n" +
                    "\t 1   2   3");
        }
//        else {
//            System.out.println("Ha! Fast Eddie wins again! THe ace ws card number " + ace);
//        }
    }
}

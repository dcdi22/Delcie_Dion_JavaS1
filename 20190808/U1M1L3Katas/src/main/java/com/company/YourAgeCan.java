package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your age");
        int age = Integer.parseInt(scan.nextLine());

        if (age >= 100) {
            System.out.println("You are more than a century old");
            System.out.println("You can retire");
            System.out.println("You are eligible for aarp");
            System.out.println("You can be president");
            System.out.println("You can drink alcohol");
            System.out.println("You can vote");
        }
        else if (age >= 80 && age <= 89) {
            System.out.println("You are an octogenerian");
            System.out.println("You can retire");
            System.out.println("You are eligible for aarp");
            System.out.println("You can be president");
            System.out.println("You can drink alcohol");
            System.out.println("You can vote");
        }
        else if (age >= 65) {
            System.out.println("You can retire");
            System.out.println("You are eligible for aarp");
            System.out.println("You can be president");
            System.out.println("You can drink alcohol");
            System.out.println("You can vote");
        }
        else if (age >= 55) {
            System.out.println("You are eligible for aarp");
            System.out.println("You can be president");
            System.out.println("You can drink alcohol");
            System.out.println("You can vote");
        }
        else if (age >= 35) {
            System.out.println("You can be president");
            System.out.println("You can drink alcohol");
            System.out.println("You can vote");
        }
        else if (age >= 21) {
            System.out.println("You can drink alcohol");
            System.out.println("You can vote");
        }
        else if (age >= 18) {
            System.out.println("You can vote");
        }
//        else{
//            System.out.println("You're a baby");
//        }

    }
}

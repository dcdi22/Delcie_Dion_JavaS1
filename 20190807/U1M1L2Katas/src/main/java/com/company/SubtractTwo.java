package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Please enter a number");
        int num1 = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter another number");
        int num2 = Integer.parseInt(scan.nextLine());

        int diff = num1 - num2;
        System.out.println("The difference between your inputs is: " + diff);


    }
}

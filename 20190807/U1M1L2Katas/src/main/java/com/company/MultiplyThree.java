package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a number");
        int num1 = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter another number");
        int num2 = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter a third number");
        int num3 = Integer.parseInt(scan.nextLine());

        int sum = num1 * num2 * num3;
        System.out.println("Your numbers multiplied together is: " + sum);

    }
}
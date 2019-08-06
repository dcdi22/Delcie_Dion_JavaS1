package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a number");
        int num1 = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter another number");
        int num2 = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter a third number");
        int num3 = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter a forth number");
        int num4 = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter a fifth number");
        int num5 = Integer.parseInt(scan.nextLine());

        int sum = num1 + num2 + num3 + num4 + num5;
        System.out.println("This is the sum of all numbers: " + sum);

    }
}

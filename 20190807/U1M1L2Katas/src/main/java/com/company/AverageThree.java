package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Please enter a number");
        double num1 = Double.parseDouble(scan.nextLine());

        System.out.println("Please enter another number");
        double num2 = Double.parseDouble(scan.nextLine());

        System.out.println("Please enter a third number");
        double num3 = Double.parseDouble(scan.nextLine());

        double average = (num1 + num2 + num3) / 3;
//        System.out.println("The average of your numbers is " + String.format( "%.2f" , average));
        System.out.format("Average is: %.2f", average);

    }
}

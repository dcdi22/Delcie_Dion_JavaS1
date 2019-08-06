package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a number");
        int num = Integer.parseInt(scan.nextLine());

        int total = (num * 2) + 5;
        System.out.println("Your number doubled then with five added on is: " + total);

    }
}

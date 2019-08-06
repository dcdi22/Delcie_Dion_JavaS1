package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a number.");
        int num = Integer.parseInt(scan.nextLine());

        int sum = (num + 5) * 2;
        System.out.println("Your number plus five then doubled is: " + sum);

    }
}

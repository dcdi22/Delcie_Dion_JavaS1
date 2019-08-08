package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int num;

        do {
            System.out.println("Please enter a number between 15 - 32");
            num = Integer.parseInt(scan.nextLine());
        } while (num < 15 || num > 32);
        System.out.println("Great you chose" + num);



    }
}

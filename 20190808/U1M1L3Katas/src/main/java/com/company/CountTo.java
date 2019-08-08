package com.company;

import java.util.Scanner;

public class CountTo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a number");
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i <= num ; i++) {
            System.out.println(i);
        }



    }
}

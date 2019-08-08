package com.company;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a number");
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 2; i <= num; i++) {
            int compare = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    compare++;
                }
            }

            if (compare == 2) {
                System.out.println(i);

            }

        }


    }
}


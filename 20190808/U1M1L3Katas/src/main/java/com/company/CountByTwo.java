package com.company;

import java.util.Scanner;

public class CountByTwo {

    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            System.out.println("Please enter a number");
            int num = Integer.parseInt(scan.nextLine());

            // Learned something new. Basic but helpful vvv
            for (int i = 0; i <= num ; i += 2) {
                System.out.println(i);
            }



        }

    }
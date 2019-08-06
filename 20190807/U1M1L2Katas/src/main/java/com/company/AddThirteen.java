package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int addThirteen = 13;

        System.out.println("Please enter a number");
        int num = Integer.parseInt(scan.nextLine());

        // I don't really need the addThirteen variable.
        // I could just substitute it with the actual number 13.
        int sum = num + addThirteen;
        System.out.println("Your number plus thirteen is: " + sum);

    }
}

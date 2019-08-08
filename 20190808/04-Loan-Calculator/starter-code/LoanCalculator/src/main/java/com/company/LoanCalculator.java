package com.company;

import java.lang.Math;
import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Mortgage amount");
        double mortgage = Double.parseDouble(scan.nextLine());

        System.out.println("Enter Term amount");
        double term = Double.parseDouble(scan.nextLine());

        System.out.println("Enter Interest amount");
        double interestRate = Double.parseDouble(scan.nextLine());
        double interest = interestRate / 100 / 12;

        double plusInterest = 1 + interest;
        double shortened = Math.pow(plusInterest, term);


        //P = L[c(1 + c)n]/[(1 + c)n - 1]

//      double amount = mortgage * (interest(1+interest)^term)/((1+interest)^term-1);
        double amount = mortgage * (interest * (shortened)) / (shortened - 1);

//      System.out.println("This is your mortgage payment " + String.format("%.2f", amount));
        /* The Above ^^^ fails because it is .01 cent off and I cannot figure out why
         Personally I would prefer it so that that there weren't
         a million decimals afterwards */
        System.out.println("This is your mortgage payment " + amount);

    }
}

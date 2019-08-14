package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class BetterInput implements UserIO {

    Scanner scan = new Scanner(System.in);

    public int readInt(String prompt) {
        int promptInt = 0;
        try {
            System.out.println(prompt);
            promptInt = Integer.parseInt(scan.nextLine());
            return promptInt;
        } catch (Exception e) {
            System.out.println("You didn't submit an int");
            // write recursion
            readInt(prompt);
        }
        // return
        return promptInt;
    }


    public long readLong(String prompt) {
        long promptLong = 0;
        try {
            System.out.println(prompt);
            promptLong = Long.parseLong(scan.nextLine());
            return promptLong;
        } catch (Exception e) {
            System.out.println("You didn't submit a long");
            readLong(prompt);
        }
        return promptLong;
    }

        public double readDouble (String prompt){
            double promptDouble = 0;
        try {
            System.out.println(prompt);
            promptDouble = Double.parseDouble(scan.nextLine());
            return promptDouble;
        } catch (Exception e) {
            System.out.println("You didn't submit a Double");
            readDouble(prompt);
        }
            return promptDouble;
        }

        public float readFloat (String prompt){
            float promptFloat = 0;
        try {
            System.out.println(prompt);
            promptFloat = Float.parseFloat(scan.nextLine());
            return promptFloat;
        } catch (Exception e) {
            System.out.println("You didn't submit a Float");
            readFloat(prompt);
        }
            return promptFloat;
        }

        public String readString (String prompt){
            System.out.println(prompt);
            String promptString = scan.nextLine();
            return promptString;
        }
    }


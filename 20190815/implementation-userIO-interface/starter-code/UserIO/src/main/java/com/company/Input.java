package com.company;

import java.util.Scanner;

import com.company.interfaces.UserIO;

public class Input implements UserIO {
    Scanner scan = new Scanner(System.in);

    @Override
    public int readInt(String prompt)
    {
        System.out.println(prompt);
        int promptInt =  Integer.parseInt(scan.nextLine());
        return promptInt;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long promptLong =  Long.parseLong(scan.nextLine());
        return promptLong;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double promptDouble = Double.parseDouble(scan.nextLine());
        return promptDouble;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float promptFloat = Float.parseFloat(scan.nextLine());
        return promptFloat;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String promptString = scan.nextLine();
        return promptString;
    }
}

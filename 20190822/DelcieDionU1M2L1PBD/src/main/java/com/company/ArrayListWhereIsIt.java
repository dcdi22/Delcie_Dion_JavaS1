package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayListWhereIsIt {
    public static void main(String[] args) {
        Random randomGen = new Random();
        Scanner scan = new Scanner(System.in);

        List<Integer> arrList = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < 10 ; i++) {
            num = randomGen.nextInt(50 + 1 - 1) + 1;
            arrList.add(num);
        }
        System.out.println("ArrayList: " + arrList.toString());
        System.out.println("Value to find: ");
        int userInput = Integer.parseInt(scan.nextLine());
        if(arrList.contains(userInput)){
            int arrIndex = arrList.lastIndexOf(userInput);
            System.out.println(userInput+" is in slot " + arrIndex);
        }
        else {
            System.out.println(userInput+ " is NOT in the ArrayList.");
        }
    }
}

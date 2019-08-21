package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayListThereOrNot {

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
            System.out.println(userInput+" is in the ArrayList.");
        }
        else {
            System.out.println(userInput+ " is NOT in the ArrayList.");
        }
        /* It says "Just like the previous assignment, if the value is present
        more than once, you ``may`` display the message as many times as necessary."
        Mine never displayed more than once, I hope that's not counted against me.
        I already had the `else` code in place before I saw this pbd so I didn't
        actually change my code any.
         */

    }

}

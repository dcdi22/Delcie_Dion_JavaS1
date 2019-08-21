package com.company;
import java.util.*;

public class FindingAValue {

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
        /*
        "It is not necessary to display anything if the value was not found."
        I went ahead and did it anyways.
         */

    }

}

package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//    Total Method

    public static int total(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


//    Total Odd

    public static int totalOdd(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i += 2) {
                sum += arr[i];

        }
        return sum;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//    Total Even

    public static int totalEven(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i += 2) {
                sum += arr[i];
        }
        return sum;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//    2nd Largest Number

    public static int secondLargestNumber(int [] arr) {
        int firstMax = arr[0]; // Output arr[0], variables to compare
        int secondMax = arr[0]; // Output arr[0], variables to compare

        for (int i = 0; i < arr.length; i++) {
                if (arr[i] > firstMax) { // compare current value of the array to value of first max
                    // You're setting your second max to what your old
                    // first max is because you're setting your new
                    // first max to the value of current arr[i]
                    // because it's(arr[i]) a greater value
                    secondMax = firstMax;
                    firstMax = arr[i];
                } else if (arr[i] > secondMax || firstMax == secondMax) { // compare current value of the array to value of second max
                    // say the firstMax is 6 and currently the secondMax is 3
                    // but the arr[i] value is 4 then !arr[i] > firstMax, so
                    // goes to else if arr[i] > secondMax, which is true so
                    // secondMax value is changed into the current value of arr[i]
                    secondMax = arr[i];
                }

        }
        return secondMax; // Return that sweet sweet value
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//    Swap First and Last

    // arr[0] && arr[arr.length -1] <~~ pseudo code
    public static String[] swapFirstAndLast(String[] arr) {
        String first = arr[0];
        String last = arr[arr.length -1];
        String original;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[0] == first) {
                original = arr[0];
                // first = arr[arr.length -1];
                // ^^^Not sure why using my variable wont reassign the value in the array?^^^
                arr[0] = arr[arr.length -1];
                // last = original;
                arr[arr.length -1] = original;
                break;
            }
        }
        return arr;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//    Reverse

    public static int[] reverse(int [] arr) {
        // make new array, build it backwards
        // for (int i = arr.length; i < 0 ; i--) ?? <~~ These are my pseudo code notes for when
        // I'm trying to decide how I want to structure my code, they're not correct
        // but I like keeping them around to refer back onto how I got to my current code

        int[] reverseArr = new int[arr.length];
        // The for loop prints the array in reverse
        for (int i = arr.length - 1; i >= 0 ; i--) {
            reverseArr[i] = arr[arr.length - 1 -i];
            // ^^^it's replacing what's in the last index with whats in the first, so on and so forth^^^
        }

        return reverseArr;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//  Concatenate String

    public static String concatenateString(String [] arr) {
        // Go through each element in the param array,
        // take the index value(arr[i]) collect all the values in a new variable
        // and place it into the new array? += String?? <~~ ^^^ pseudo coding
        String valueHolder = "";
        for (int i = 0; i < arr.length; i++) {
            valueHolder += arr[i];
        }
        return valueHolder;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//    EveryThird

    public static int[] everyThird(int [] arr) {
        // if or else statement
        // every 3, maybe in the 4 loop?
        // go through the whole array first then initialize an array afterwords?
        // 3 / length of array? <~~ ^^^ pseudo coding
        int iterationCounter = 0;
        int [] everyThirdArr  =  new int[arr.length/3];
        if (arr.length < 3) {
            return null;
        } else {
            for (int i = 2; i < arr.length; i+= 3) {
                everyThirdArr[iterationCounter] = arr[i];
                iterationCounter++;

            }
            return everyThirdArr;
        }

    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//    Less Than Five

    public static int [] lessThanFive(int [] arr) {
        // need to initialize a new an array
        // need to push values into an array
        // use a counter!!
        // do while?
        int counter = 0;
        for (int i = 0; i <arr.length; i++) {
            if (arr[i] < 5) {
                counter++;
            }
            if (counter == 0) {
                return null;
            }
        }
        int [] fiveLessArr = new int[counter];
        int iterationCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 5) {
                fiveLessArr[iterationCounter] = arr[i];
                iterationCounter++;
            }
        }
        return fiveLessArr;
    }












    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] exampleArr = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] exampleArr2 = {3, 6, 4, 9, 4, 2, 6, 7};
        int[] exampleArr3 = {7, 6, 8};
        int[] exampleArr4 = {-3, -17};
        String[] exampleStringArr = {"foo", "bar", "baz", "qux"};

//        int totalSum = total(exampleArr);
//        System.out.println(totalSum);
//
//        int totalSumOdd = totalOdd(exampleArr);
//        System.out.println(totalSumOdd);
//
//        int totalSumEven = totalEven(exampleArr);
//        System.out.println(totalSumEven);
//
//        int secondMax = secondLargestNumber(exampleArr);
//        System.out.println(secondMax);
//
//        String [] swappedArray = swapFirstAndLast(exampleStringArr);
//        System.out.println(Arrays.toString(swappedArray));
//
//        int[] reverseArray = reverse(exampleArr);
//        System.out.println(Arrays.toString(reverseArray));
//
//        String concatenateOutput = concatenateString(exampleStringArr);
//        System.out.println(concatenateOutput);
//
//        int [] thirds = everyThird(exampleArr);
//        System.out.println(Arrays.toString(thirds));
//
//        int [] fiveOrLessArray = lessThanFive(exampleArr);
//        System.out.println(Arrays.toString(fiveOrLessArray));






    }

}

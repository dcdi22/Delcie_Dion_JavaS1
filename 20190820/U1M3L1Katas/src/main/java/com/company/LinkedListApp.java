package com.company;

import java.util.*;

public class LinkedListApp {

    public static int total (LinkedList<Integer> numbers) {

        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }

        return sum;
    }

    public static int totalEven (LinkedList<Integer> numbers) {

        int sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static List swapFirstAndLast(LinkedList<String> strings) {

        String temp = strings.get(0);
        strings.set(0, strings.get(strings.size() - 1));
        strings.set(strings.size() - 1, temp);

        return strings;
    }

    public static List reverse(LinkedList<Integer> numbers) {

//        public List
        LinkedList<Integer> reversed = new LinkedList<>();
        System.out.println(numbers);
//        int[] reversed = new int[numbers.size()];

        for(int i = 0; i < numbers.size(); i++) {

            // length - (i + 1) is the n-th to last element
            // so when i = 0, it would be the last element
            // when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
//            reversed.set(i) = numbers.get(numbers.size() - (i + 1));
            reversed.add(numbers.get(numbers.size() - (i + 1)));
        }


        return reversed;
    }

    public static List lessThanFive(LinkedList<Integer> numbers) {

        int numLessThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            }
        }

        if ( numLessThanFive == 0 ) {
            return null;
        }

//        int[] lessThan = new int[numLessThanFive];
        LinkedList<Integer> lessThan = new LinkedList<>();

        for(int num : numbers) {
            if ( num < 5 ) {

                // subtracting numLessThanFive from length then decrementing numLessThanFive
                // allows us to go from 0 to length - 1 in order without additional variables
//                lessThan[lessThan.length - numLessThanFive] = num;
                lessThan.add(num);
//                lessThan.add(lessThan.size() - numLessThanFive, num);
                numLessThanFive--;
            }
        }

        return lessThan;
    }

    //challenge
    public static int[][] splitAtFive(LinkedList<Integer> numbers) {
        int numLessThanFive = 0;
        int numMoreThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            } else {
                numMoreThanFive++;
            }
        }

        int[] lessThan = new int[numLessThanFive];
        int[] moreThan = new int[numMoreThanFive];


        for(int num : numbers) {

            // subtracting numLessThanFive from length then decrementing numLessThanFive
            // allows us to go from 0 to length - 1 in order without additional variables
            // same with numMoreThanFive
            if ( num < 5 ) {
                lessThan[lessThan.length - numLessThanFive] = num;
                numLessThanFive--;
            } else {
                moreThan[moreThan.length - numMoreThanFive] = num;
                numMoreThanFive--;
            }
        }

        return new int[][] { lessThan, moreThan };
    }

    // Challenge
    public static String[][] evensAndOdds(LinkedList<String> strings) {

        //leveraging integer division
        String[] odds = new String[ strings.size()/2 ];

        // Set evens to null for reassignment below
        String[] evens = null;

        // again leveraging integer division
        // if it's already of even length, we're good
        // but if it's of odd length, there's one more even index than odd
        if (strings.size() % 2 == 0) {
            evens = new String[ strings.size()/2];
        } else {
            evens = new String[ strings.size()/2 + 1];
        }

        for(int i = 0; i < strings.size(); i++) {
            int currIndex = i/2;
            if( i % 2 == 0 ) {
                evens[currIndex] = strings.get(i);
            } else {
                odds[currIndex] = strings.get(i);
            }
        }

        return new String[][] { evens, odds };
    }

    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList();
        numbers.add(5);
        numbers.add(4);
        int totalNum = total((LinkedList<Integer>) numbers);
        System.out.println(totalNum);

        List<String> strings = new LinkedList();
        strings.add("Michelle");
        strings.add("Delcie");
//        String swapNames =
//        List<String> swappedNames = new LinkedList();
//        List<String> strings.swapFirstAndLast(LinkedList<String> strings);
//        List<String> swappedNames = strings.swapFirstAndLast();
    }
}

package com.company;

import java.util.Scanner;

public class App {


    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int subtractOrZero(int a, int b) {
        int result = a - b;
        if (result < 0){
            return 0;
        } else {
            return result;
        }
    }

    public static int max(int a, int b, int c) {
        if ( a > b && a > c) {
            return a;
        }else if (b > a && b > c) {
            return b;
        } else  {
            return c;
        }
    }

    public static int min(int a, int b, int c) {
        if ( a < b && a < c) {
            return a;
        }else if (b < a && b < c) {
            return b;
        } else  {
            return c;
        }
    }

    public static boolean isLarger(int first, int second) {
        if (first > second) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int diff = subtract(5, 3);
        System.out.println(diff);

        int ifZero = subtractOrZero(7, 7);
        System.out.println(ifZero);

        int whichMax = max(4,7,12);
        System.out.println(whichMax);

        int whichMin = min(8,9,11);
        System.out.println(whichMin);

        boolean whichLarger = isLarger(5, 3);
        System.out.println(whichLarger);

    }







}

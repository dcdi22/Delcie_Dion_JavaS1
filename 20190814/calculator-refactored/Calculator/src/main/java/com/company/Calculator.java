package com.company;

public class Calculator {

    //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    ADD

    public static int add(int a, int b) {
        return a+b;
    }
    public static long add(long a, long b){
        return a+b;
    }
    public static float add(float a, float b){ return a+b; }
    public static double add(double a, double b){
        return a+b;
    }

    //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    SUBTRACT
    public static int subtract(int a, int b) {
        return a - b;
    }
    public static long subtract(long a, long b){
        return a-b;
    }
    public static float subtract(float a, float b){ return a-b; }
    public static double subtract(double a, double b){ return a-b; }

    //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    MULTIPLY
    public static int multiply(int a, int b) {return a * b;}
    public static long multiply(long a, long b){
        return a*b;
    }
    public static float multiply(float a, float b){ return a*b; }
    public static double multiply(double a, double b){ return a*b; }

    //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    DIVIDE
    public static int divide(int a, int b) {return a / b;}
    public static long divide(long a, long b){
        return a/b;
    }
    public static float divide(float a, float b){ return a/b; }
    public static double divide(double a, double b){ return a/b; }


    public static void main(String[] args) {
        int i = 1;
        int j = 2;

        long long1 = 23;
        long long2 = 4;

        float float1 = 1.52f;
        float float2 = 1.34f;

        double double1 = 1.52d;
        double double2 = 3.52d;

        System.out.println(Calculator.add(i, j));
        System.out.println(Calculator.add(long1, long2));
        System.out.println(Calculator.add(float1, float2));
        System.out.println(Calculator.add(double1, double2));
//        System.out.println(Calculator.add(float1, double1));

    }

}

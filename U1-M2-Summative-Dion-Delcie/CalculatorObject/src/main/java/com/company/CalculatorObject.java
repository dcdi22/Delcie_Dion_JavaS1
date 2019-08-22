package com.company;

public class CalculatorObject {

    // The following are all examples of Method Overloading.

    /*
    Overloading allows different methods to have the same name,
    but different signatures where the signature can differ by the
    number of input parameters or type of input parameters or both.
     */

    //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    ADD

    public static void add(int a, int b) {
        int sum = a+b;
        System.out.println(a + " + "+ b + " = " + sum );
    }
    public static void add(double a, double b){
        double sum = a+b;
        System.out.println(a + " + "+ b + " = " + sum );
    }

    //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    SUBTRACT
    public static void subtract(int a, int b) {
        int diff = a-b;
        System.out.println(a + " - "+ b + " = " + diff );
    }

    public static void subtract(double a, double b) {
        double diff = a-b;
        System.out.println(a + " - "+ b + " = " + diff );
    }

    //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    MULTIPLY
    public static void multiply(int a, int b) {
        int product = a*b;
        System.out.println(a + " * "+ b + " = " + product );
    }

    public static void multiply(double a, double b) {
        double product = a*b;
        System.out.println(a + " * "+ b + " = " + product );
    }

    //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    DIVIDE
    public static void divide(int a, int b) {
        int dividend = a/b;
        System.out.println(a + " / "+ b + " = " + dividend );
    }

    public static void divide(double a, double b) {
        double dividend = a/b;
        System.out.println(a + " / "+ b + " = " + dividend );
    }

}

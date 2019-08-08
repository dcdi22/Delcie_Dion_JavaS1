package com.company;

import java.util.Scanner;

public class IsJavaKeyword {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a word and we'll see if it's a Java keyword");
        String input = scan.nextLine();

        switch(input) {
            case "while":
            case "for":
            case "double":
            case "new" :
            case "switch":
                System.out.println(input + " is a java keyword");
                break;
                default:
                    System.out.println(input + " is not a java keyword.");
        }



    }
}

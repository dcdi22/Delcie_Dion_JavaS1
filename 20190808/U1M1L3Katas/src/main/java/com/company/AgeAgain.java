package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your age");
        int age = Integer.parseInt(scan.nextLine());

        if (age > 18) {
            System.out.println("What is your job");
            String userJob = scan.nextLine();
            System.out.println(userJob + " sounds like a great job!");
        }
        else if (age >= 14 && age <= 18) {
            System.out.println("Are you planning to go to college?(Please answer in lowercase)");
            String college = scan.nextLine();
            if (college.equals("yes")) {
                System.out.println("What college?");
                String whatCollege = scan.nextLine();
                System.out.println(whatCollege + " is a great school!");
            }
            else if (college.equals("no")) {
                System.out.println("So what do you want to do after high school?");
                String afterSchool = scan.nextLine();
                System.out.println("Wow, " + afterSchool + " sounds like a plan!");
            }
        }
        else if (age < 14) {
            System.out.println("What grade are you in?");
            String grade = scan.nextLine();
            System.out.println("Wow! " + grade + " grade - that sounds exciting!");
        }

    }
}

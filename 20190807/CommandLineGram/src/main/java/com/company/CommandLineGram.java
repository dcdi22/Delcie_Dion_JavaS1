package com.company;

import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is your First name?");
        String firstName = scan.nextLine();

        System.out.println("What is your Last name?");
        String lastName = scan.nextLine();

        System.out.println("What is your email?");
        String email = scan.nextLine();

        System.out.println("What is your Twitter handle?");
        String twitter = scan.nextLine();

        System.out.println("How old are you?");
        int age = Integer.parseInt(scan.nextLine());

        System.out.println("What country do you reside in?");
        String country = scan.nextLine();

        System.out.println("What is your profession?");
        String profession = scan.nextLine();

        System.out.println("What is your favourite operating system?");
        String os = scan.nextLine();

        System.out.println("What is your favourite programming language?");
        String lang = scan.nextLine();

        System.out.println("What is your favourite computer scientist?");
        String sci = scan.nextLine();

        System.out.println("What is your favourite keyboard shortcut?");
        String kShort = scan.nextLine();

        System.out.println("Have you built a computer before?");
        String comp = scan.nextLine();

        System.out.println("If you could be any superhero, who would it be?");
        String hero = scan.nextLine();


        String newline = System.getProperty("line.separator");
        System.out.format("My name is %s %s."
                + newline +
                "My email is %s."
                + newline +
                "My twitter handle is %s."
                + newline +
                "I am %d."
                + newline +
                "I am from %s."
                + newline +
                "I work as a %s."
                + newline +
                "My favourite os is %s."
                + newline +
                "My favourite language is %s."
                + newline +
                "My favourite computer scientist is %s."
                + newline +
                "My favourite keyboard shortcut is %s."
                + newline +
                "%s I have built a computer before."
                + newline +
                "I would be %s"
               , firstName, lastName, email, twitter, age, country, profession, os, lang, sci, kShort, comp, hero );

    }
}

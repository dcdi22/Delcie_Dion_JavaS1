package com.company;

import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("In feet, what is the width of your driveway?");
        int width = Integer.parseInt(scan.nextLine());

        System.out.println("In feet, what is the length of your driveway?");
        int length = Integer.parseInt(scan.nextLine());

        int area = width * length;
        System.out.println("The area of the driveway is "+ area + " sqft");

        int perimeter = 2 * (width + length);
        System.out.println("The perimeter of the driveway is "+ perimeter + " sqft");

        double cementTotal = (area * 12.50);
        double framingTotal = (perimeter * 8.25);

        System.out.println("This cost of the cement is " + String.format("%.2f", cementTotal));
        System.out.println("This cost of the framing/footers is " + String.format("%.2f", framingTotal));

        // Version 2

        System.out.println("What is the cost of cement per square foot?");
        double cementCost = Double.parseDouble(scan.nextLine());

        System.out.println("What is the cost of framing/footers per square foot?");
        double framingCost = Double.parseDouble(scan.nextLine());

        // use originally captured length and width

        double cementTotal2 = (area * cementCost);
        double framingTotal2 = (perimeter * framingCost);

        System.out.println("This cost of the cement is " + String.format("%.2f", cementTotal2));
        System.out.println("This cost of the framing/footers is " + String.format("%.2f", framingTotal2));

    }
}

import java.util.Scanner;

public class rightTriangleChecker {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int side1;
        int side2;
        int side3;
        boolean flag = false;


//        System.out.println("Enter three integers:");
//        while(!flag) {
//            System.out.println("Side 1: ");
//            side1 = Integer.parseInt(scan.nextLine());
//            System.out.println("Side 2: ");
//            side2 = Integer.parseInt(scan.nextLine());
//            if (side2 < side1) {
//                System.out.println(side2 + " is smaller than " + side1);
//                System.out.println("Side 2: ");
//                side2 = Integer.parseInt(scan.nextLine());
//            }
//            System.out.println("Side 3: ");
//            side3 = Integer.parseInt(scan.nextLine());
//            if (side3 < side2) {
//                System.out.println(side3 + " is smaller than " + side2);
//                System.out.println("Side 3: ");
//                side3 = Integer.parseInt(scan.nextLine());
//            }
//        }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        do {
//            System.out.println("Side 1: ");
//            side1 = Integer.parseInt(scan.nextLine());
//            System.out.println("Side 2: ");
//            side2 = Integer.parseInt(scan.nextLine());
//            if (side2 < side1) {
//                System.out.println(side2 + " is smaller than " + side1 + ". Try again.");
//                System.out.println("Side 2: ");
//                side2 = Integer.parseInt(scan.nextLine());
//            }
//            System.out.println("Side 3: ");
//            side3 = Integer.parseInt(scan.nextLine());
//            if (side3 < side2) {
//                System.out.println(side3 + " is smaller than " + side2 + ". Try again.");
//                System.out.println("Side 3: ");
//                side3 = Integer.parseInt(scan.nextLine());
//            }
//        } while (side3 >= side2 && side2 >= side1);

        System.out.println("Enter three integers:");
        System.out.println("Side 1: ");
        side1 = Integer.parseInt(scan.nextLine());
        System.out.println("Side 2: ");
        side2 = Integer.parseInt(scan.nextLine());

        while (side2 < side1) {
            System.out.println(side2 + " is smaller than " + side1 + ". Try again.");
            System.out.println("Side 2: ");
            side2 = Integer.parseInt(scan.nextLine());
        }

        System.out.println("Side 3: ");
        side3 = Integer.parseInt(scan.nextLine());

        while (side3 < side2) {
            System.out.println(side3 + " is smaller than " + side2 + ". Try again.");
            System.out.println("Side 3: ");
            side3 = Integer.parseInt(scan.nextLine());
        }

        System.out.println("Your three sides are " + side1 + " " + side2 + " " + side3);
        if (side2 == side3) {
            System.out.println("NO! These sides do not maake a right triangle!");
        }
        else {
            System.out.println("These sides *do* make a right triangle. Yippy-skippy");
        }






    }

}

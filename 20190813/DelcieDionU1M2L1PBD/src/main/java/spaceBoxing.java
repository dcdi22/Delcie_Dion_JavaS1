import java.util.Scanner;

public class spaceBoxing {

    public static void weightConversion(double weight, double planet){
        double convertedWeight =  weight * planet;
        System.out.println("Your weight would be " + convertedWeight + " pounds on that planet.");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Please enter your current earth weight: ");
        double earthWeight = Double.parseDouble(scan.nextLine());

        System.out.println("I have information for the following planets: \n" +
                "\t1. Venus \t2. Mars \t3. Jupiter \n" +
                "\t4. Saturn \t3.Uranus \t6.Neptune\n" +
                "\n" +
                "Which planet are you visiting?");
        int planet = Integer.parseInt(scan.nextLine());


        switch (planet) {
            case 1:
                weightConversion(earthWeight, .78);
                break;
            case 2:
                weightConversion(earthWeight, .39);
                break;
            case 3:
                weightConversion(earthWeight, 2.65);
                break;
            case 4:
                weightConversion(earthWeight, 1.17);
                break;
            case 5:
                weightConversion(earthWeight, 1.05);
                break;
            case 6:
                weightConversion(earthWeight, 1.23);
                break;
            default:
                System.out.println("You didn't pick a planet from the list");

        }





    }

}

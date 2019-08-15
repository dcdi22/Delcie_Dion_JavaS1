import java.util.Scanner;

public class ValidNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int userInput;

        do {
            System.out.println("Enter a number 1-10");
            userInput = Integer.parseInt(scan.nextLine());
            if ((userInput <= 0 || userInput > 10)) {
                System.out.println("You must enter a number between 1 and 10, please try again.");
            }
        } while (userInput <= 0 || userInput > 10);
        // while userInput is equal or less than 0 OR is above 10
        // continue to ask(do) for a num between 1-10
        // if condition is met break out of the loop
        System.out.println("You chose " + userInput);





    }
}

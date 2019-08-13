import java.util.Scanner;
import java.util.Random;

public class aNumberGuessingGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomGenerator = new Random();

        int computerNumber = randomGenerator.nextInt(10) +1;

        System.out.println("I'm thinking of a number from 1 to 10\n" +
                "Your guess: ");
        int userGuess = Integer.parseInt(scan.nextLine());

        if (userGuess >= 1 && userGuess <= 10) {
            if (userGuess == computerNumber) {
                System.out.println("That's right! My secret number was " + computerNumber + "!");
            }
            else {
                System.out.println("Sorry, but I was really thinking of " + computerNumber+ ".");
            }
        }
        else {
            System.out.println("You did not entered a number 1 - 10. Goodbye.");
        }
    }

}

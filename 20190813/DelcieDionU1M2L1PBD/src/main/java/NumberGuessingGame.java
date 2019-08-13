import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomGenerator = new Random();
        int correct = 0;
        int computerNumber = randomGenerator.nextInt(10) +1;
        boolean flag = true;
        System.out.println("I'm thinking of a number from 1 to 10\n" +
                "Your guess: ");
        int userGuess = Integer.parseInt(scan.nextLine());

        while(flag != false){
            if (userGuess >= 1 && userGuess <= 10) {
                if (userGuess == computerNumber) {
                    System.out.println("That's right! My secret number was " + computerNumber + "!");
                    flag = false;

                }
                else {
                    System.out.println("That is incorrect. Guess again.\nYour guess:");
                    userGuess = Integer.parseInt(scan.nextLine());
                }
            }
            else {
                System.out.println("You did not entered a number 1 - 10. Goodbye.");
            }
            correct++;
        }
        System.out.println("It only took you " + correct + " tries.");
    }
}

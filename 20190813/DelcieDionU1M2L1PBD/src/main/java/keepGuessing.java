import java.util.Scanner;
import java.util.Random;

public class keepGuessing {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomGenerator = new Random();

        int userGuess;
        int computerGuess = randomGenerator.nextInt(10) + 1;
        System.out.println(computerGuess);


        System.out.println("I have chosen a number between 1 and 10. Try to guess it");
        do {

            System.out.println("Your guess: ");
            userGuess = Integer.parseInt(scan.nextLine());
            if (userGuess != computerGuess) {
                System.out.println("That is incorrect. Guess again");
            }
        } while (userGuess != computerGuess);
        System.out.println("That's right! You're a good guesser.");




    }

}

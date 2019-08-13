import java.util.Random;
import java.util.Scanner;

public class hiLoLimited {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomGen = new Random();

        int randomInt = randomGen.nextInt(100) + 1;
        int userGuess;
        int numberOfGuesses = 1;


        do {
            System.out.println("Please Guess a number 1 - 100");
            userGuess = Integer.parseInt(scan.nextLine());
            if (randomInt == userGuess) {
                System.out.format("You guessed it! What are the odds");
            } else if (randomInt > userGuess) {
                System.out.println("Sorry, you are too Low");
            } else if (randomInt < userGuess) {
                System.out.println("Sorry, you are too high");
            }
            numberOfGuesses++;
        } while (randomInt != userGuess && numberOfGuesses <= 7);
        System.out.println("Sorry you did not guess it in 7 tries. You lose.");







    }

}

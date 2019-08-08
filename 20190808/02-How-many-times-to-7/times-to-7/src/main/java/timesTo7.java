import java.util.Scanner;
import java.util.Random;

public class timesTo7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomGen = new Random();


        int howMany7s = 0;
        int first7 = 1; // first roll starting from 1
        boolean firstCheck = false;
        int roll1;
        int roll2;
        int rollValue;



        for (int i = 0; i < 100 ; i++) {
            roll1 = randomGen.nextInt(6) +1;
            roll2 = randomGen.nextInt(6) +1;
            rollValue = roll1 + roll2;
            System.out.println(rollValue);
            // while rollValue != 7 increment first7 until true
            // do increment while 7 not true
            if (rollValue == 7 && firstCheck == false) {
                howMany7s++;
                first7 = i + 1;
                firstCheck = true;
            } else if (rollValue == 7) {
                howMany7s++;
            }
        }
        System.out.println("You rolled a 7 " + howMany7s + " times");
        System.out.println("It took you " + first7 + " rolls to get this many times til you rolled your first 7");


    }
}

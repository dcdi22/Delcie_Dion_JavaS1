import java.util.Random;

public class shorterDoubleDice {

    public static void main(String[] args) {
        Random randomGenerator = new Random();

        int dice1 = 0;
        int dice2 = 0;
//        boolean flag = false;
        // No longer need the boolean flag since do while runs it before reading the value of dice


        System.out.println("HERE COMES THE DICE!\n");
        do {
            dice1 = randomGenerator.nextInt(6) + 1;
            dice2 = randomGenerator.nextInt(6) + 1;
            int total = dice1 + dice2;

            System.out.println(
                    "Roll #1: " + dice1 +
                            "\nRoll #2: " + dice2 +
                            "\nThe total is " + total + "!\n");
        }while (dice1 != dice2);

    }
}

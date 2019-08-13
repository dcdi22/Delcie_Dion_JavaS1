import java.util.Random;

public class dice {

    public static void main(String[] args) {
        Random randomGenerator = new Random();

        int dice1 = randomGenerator.nextInt(6) + 1;
        int dice2 = randomGenerator.nextInt(6) + 1;
        int total = dice1 + dice2;

        System.out.println("HERE COMES THE DICE!\n" +
                "\nRoll #1: " + dice1 +
                "\nRoll #2: " + dice2 +
                "\nThe total is " + total + "!");
    }

}

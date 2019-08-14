import java.util.Random;

public class diceDoubles {

    public static void main(String[] args) {
        // I did this one by accident last time we had PBD's
        Random randomGenerator = new Random();

        int dice1 = 0;
        int dice2 = 0;
        boolean flag = false;


        System.out.println("HERE COMES THE DICE!\n");
        while (!flag) {
            dice1 = randomGenerator.nextInt(6) + 1;
            dice2 = randomGenerator.nextInt(6) + 1;
            int total = dice1 + dice2;

            System.out.println(
                    "Roll #1: " + dice1 +
                    "\nRoll #2: " + dice2 +
                    "\nThe total is " + total + "!\n");
            if(dice1 == dice2){
                flag = true;
            }

        }

    }
}

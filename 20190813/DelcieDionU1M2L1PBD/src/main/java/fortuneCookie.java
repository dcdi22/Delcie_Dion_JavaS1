import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class fortuneCookie {

    public static int[] lotoNumbers() {
        Random randomGenerator = new Random();
        int[] lotoArr = new int[6];
        int lotoNum;
        for (int i = 0; i < 6 ; i++) {
            lotoNum = randomGenerator.nextInt(54) +1;
            lotoArr[i]= lotoNum;
        }
        return lotoArr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomGenerator = new Random();

        int fortuneNumber = randomGenerator.nextInt(6) +1;
        // I'm not responsible for an of these fortunes, I found them online

        switch (fortuneNumber) {
            case 1 :
                System.out.println("Fortune cookie says: 'Don’t let friends impose on you, work calmly and silently'");
                int[] loto = lotoNumbers();
                System.out.println(Arrays.toString(loto));
                break;
            case 2 :
                System.out.println("Fortune cookie says: 'Embrace this love relationship you have!'");
                loto = lotoNumbers();
                System.out.println(Arrays.toString(loto));
                break;
            case 3 :
                System.out.println("Fortune cookie says: 'Fearless courage is the foundation of victory.'");
                loto = lotoNumbers();
                System.out.println(Arrays.toString(loto));
                break;
            case 4 :
                System.out.println("Fortune cookie says: 'Go take a rest; you deserve it.'");
                loto = lotoNumbers();
                System.out.println(Arrays.toString(loto));
                break;
            case 5 :
                System.out.println("Fortune cookie says: 'Happiness begins with facing life with a smile and a wink.'");
                loto = lotoNumbers();
                System.out.println(Arrays.toString(loto));
                break;
            case 6 :
                System.out.println("Fortune cookie says: 'It’s not the amount of time you devote, but what you devote to the time that counts.'");
                loto = lotoNumbers();
                System.out.println(Arrays.toString(loto));
                break;

        }


    }

}

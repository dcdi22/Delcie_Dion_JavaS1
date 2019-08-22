import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class gettingLargest {

    public static void main(String[] args) {
        Random randomGen = new Random();

        List<Integer> arrList = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < 10 ; i++) {
            num = randomGen.nextInt(100 + 1 - 1) + 1;
            arrList.add(num);
        }
        System.out.println("ArrayList: " + arrList.toString());

        int largest = 0;
        for (Integer i: arrList) {
            if(i > largest) {
                largest = i;
            }
        }
        System.out.println("\nThe largest value is " + largest);
    }
}

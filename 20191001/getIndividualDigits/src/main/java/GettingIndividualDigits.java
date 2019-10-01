import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GettingIndividualDigits {

    public static void main(String[] args) {
        for (int i = 10; i < 100 ; i++) {
            String number = String.valueOf(i);
            List<Integer> integerList = new ArrayList<>();
            for (int j = i; j < i + 1; j++) {
//                int num1 = Character.digit(number.charAt(0), 10);
//                int num2 = Character.digit(number.charAt(1), 10);
                int num1 = (i / 10);
                int num2 = (i % 10);
                int sum = num1 + num2;
//                System.out.println(j + " " + i);
//                integerList.add(Character.digit(number.charAt(i), 10));
//                System.out.println(integerList);
//                int num = Character.digit(number.charAt(j), 10);
//                System.out.println("This is num 1: " + num1 + ". This is num 2:   " + num2);
                System.out.println(i + ", " + num1 +"+"+num2+ " = " + sum);
            }
        }
    }

}

import java.util.Arrays;
import java.util.Scanner;

public class ArrayFun5Words {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] userArray = new String[5];

        System.out.println("Please enter a word");
        userArray[0] = scan.nextLine();

        System.out.println("Please enter a second word");
        userArray[1] = scan.nextLine();

        System.out.println("Please enter a third word");
        userArray[2] = scan.nextLine();

        System.out.println("Please enter a forth word");
        userArray[3] = scan.nextLine();

        System.out.println("Please enter a fifth word");
        userArray[4] = scan.nextLine();

        System.out.println("Here is your array : " + Arrays.toString(userArray));

    }
}

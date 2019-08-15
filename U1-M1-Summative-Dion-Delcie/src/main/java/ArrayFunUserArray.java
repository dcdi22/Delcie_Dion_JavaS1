import java.util.Arrays;
import java.util.Scanner;

public class ArrayFunUserArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Initiating the array vvv
        int[] userArray = new int[5];

        System.out.println("Please enter a number");
        userArray[0] = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter a second number");
        userArray[1] = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter a third number");
        userArray[2] = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter a forth number");
        userArray[3] = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter a fifth number");
        userArray[4] = Integer.parseInt(scan.nextLine());

        System.out.println("Here is your array : " + Arrays.toString(userArray));

    }
}

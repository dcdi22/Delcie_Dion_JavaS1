import java.util.Scanner;

public class safeSquareRoot {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = 0;

        System.out.println("SQUARE ROOT!");
        System.out.println("Enter a number: ");
        num = Integer.parseInt(scan.nextLine());

        while(num < 0) {
            System.out.println("You can't take the square root of a negative number, silly.");
            System.out.println("Enter a number: ");
            num = Integer.parseInt(scan.nextLine());
        }

        double sqrtNum = Math.sqrt(num);
        System.out.println("The square root of " + num + " is " + sqrtNum);


    }

}

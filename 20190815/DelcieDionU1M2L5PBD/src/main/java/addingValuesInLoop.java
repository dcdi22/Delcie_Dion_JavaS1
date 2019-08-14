import java.util.Scanner;

public class addingValuesInLoop {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = 0;
        int newNum = 0;
        boolean flag = true;

        System.out.println("I will add up the numbers you give me.");
        while(flag) {
            System.out.println("Number: ");
            num = Integer.parseInt(scan.nextLine());
            if (num == 0) {
                flag = false;
            }
            else {
                newNum += num;
                System.out.println("Your total so far is " + newNum);

            }

        }
        System.out.println("\nGame Over. Your total is " + newNum);
    }

}

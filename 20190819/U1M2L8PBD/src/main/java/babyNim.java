import java.util.Scanner;

public class babyNim {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = 3;
        int b = 3;
        int c = 3;
        String userPick;
        int userAmount;


        while(!(a <= 0 && b <= 0 && c <= 0)) {
//            System.out.format("A: %\t B: %d\t C: %d\n", a, b, c);
            System.out.println("A: "+ a + "\tB: " + b + "\tC: " + c);
            System.out.println("Choose a pile: ");
            userPick = scan.nextLine().toUpperCase();
            System.out.println("How many to remove from pile " + userPick + ": ");
            userAmount = Integer.parseInt(scan.nextLine());
            if (userPick.equals("A")){
                a = a - userAmount;
            } else if (userPick.equals("B")){
                b = b - userAmount;
            } else if (userPick.equals("C")) {
                c = c - userAmount;
            } else {
                System.out.println("You did not choose a valid letter");
            }
        }
        System.out.println("\nA: "+ a + "\tB: " + b + "\tC: " + c);
        System.out.println("\nAll piles are empty. Good job!");

    }
}

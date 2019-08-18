import java.util.Scanner;

public class nim {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String player1;
        String player2;

        int a = 3;
        int b = 4;
        int c = 5;
        String userPick;
        int userAmount;
        boolean flag = true;


        System.out.println("Player 1, enter your name: ");
        player1 = scan.nextLine();
        System.out.println("Player 2, enter your name:");
        player2 = scan.nextLine();
        while(!(a <= 0 && b <= 0 && c <= 0)) {
            if (flag) {
                System.out.println("A: "+ a + "\tB: " + b + "\tC: " + c);
                System.out.println(player1 +", choose a pile: ");
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
                    System.out.println("You did not chose a valid letter");
                }
                flag = false;

            } else {
                System.out.println("A: "+ a + "\tB: " + b + "\tC: " + c);
                System.out.println(player2 +", choose a pile: ");
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
                    System.out.println("You did not chose a valid letter");
                }
                flag = true;

            }
        }
        System.out.println("\nA: "+ a + "\tB: " + b + "\tC: " + c);
        if (flag) {
            System.out.println("\n" + player1 +", there are no counters left, so you WIN!");
        } else {
            System.out.println("\n" + player2 +", there are no counters left, so you WIN!");
        }



    }
}

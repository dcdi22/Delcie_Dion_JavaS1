import java.util.Scanner;

public class aLittleQuiz {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int correct = 0;

        System.out.println("Quiz time!! \n \n" +
                "Q1) What is the capital of Georgia? \n" +
                "\t 1)Savannah" +
                "\t 2)Atlanta " +
                "\t 3)Macon");
        int q1 = Integer.parseInt(scan.nextLine());
        if (q1 == 2) {
            System.out.println("That's correct!");
            correct++;
        }
        else {
            System.out.println("Sorry, Atlanta is the capital of Georgia.");
        }

//        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        System.out.println("\nQ2) Can you store the value of 'cat' in a int variable? \n" +
                "\t 1)yes" +
                "\t 2)no ");
        int q2 = Integer.parseInt(scan.nextLine());
        if (q2 == 2) {
            System.out.println("That's correct!");
            correct++;
        }
        else {
            System.out.println("Sorry, 'cat' is a string. ints can only be stored as numbers.");
        }

//        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        System.out.println("\nQ1) What is the result pf 9+6/3? \n" +
                "\t 1)5" +
                "\t 2)11 " +
                "\t 3)15/3");
        int q3 = Integer.parseInt(scan.nextLine());
        if (q3 == 1) {
            System.out.println("That's correct!");
            correct++;
        }
        else {
            System.out.println("Sorry, the answer is 5");
        }

        System.out.println("\nOverall, you got " + correct + " out of 3 correct." +
                "\nThanks for playing!");







    }
}

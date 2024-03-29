import java.util.Scanner;

public class MonthConverterSwitch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number 1 - 12");
        int userInput = Integer.parseInt(scan.nextLine());

        // Switch looks for matching case, if it can't find
        // a case that matches userInput, prints default

        // 'break' is used to execute the statements of single case
        // break is necessary to avoid passing through to the code in the next case
        switch (userInput) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");



        }
    }
}

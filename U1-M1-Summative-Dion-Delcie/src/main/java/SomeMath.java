import java.util.Scanner;

public class SomeMath {

    public static int total5(int num1, int num2,int num3,int num4,int num5) {
        return num1+num2+num3+num4+num5;
    }

    public static double average5(int num1, int num2,int num3,int num4,int num5) {
        return (num1+num2+num3+num4+num5)/5;
    }

    public static double largest5(double num1, double num2, double num3, double num4, double num5) {
        if (num1 > num2 && num1 > num3 && num1 > num4 && num1 > num5){
            return num1;
        }
        else if (num2 > num1 && num2 > num3 && num2 > num4 && num2 > num5) {
            return num2;
        }
        else if (num3 > num1 && num3 > num2 && num3 > num4 && num3 > num5) {
            return num3;
        }
        else if (num4 > num1 && num4 > num3 && num4 > num2 && num4 > num5) {
            return num4;
        }
        else {
            return num5;
        }
    }



    public static void main(String[] args) {

        int total = total5(1,2,3,4,5);
        System.out.println(total);

        double avg = average5(1, 3, 5, 7, 9);
        System.out.println(avg);

        double largest = largest5(42.0, 35.1, 2.3, 40.2, 15.6);
        System.out.println(largest);

    }

}

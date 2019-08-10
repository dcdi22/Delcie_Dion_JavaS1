import java.util.Arrays;

public class ArrayFunReverseIt {

    public static void main(String[] args) {

        int[] firstArray = {1, 2, 3, 4, 5};
        int[] secondArray = new int[5]; // or int[] secondArrayExample = new int[firstArray.length];
        int counter = 0;

        for (int i = firstArray.length -1; i >= 0; i--) {
            secondArray[counter] = firstArray[i];
            counter++;
        }
        System.out.println("This is our original array : " + Arrays.toString(firstArray));
        System.out.println("This is our reverse array : " + Arrays.toString(secondArray));



    }
}

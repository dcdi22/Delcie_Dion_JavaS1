import java.util.Arrays;

public class ArrayFunReverseIt {

    public static void main(String[] args) {

        int[] firstArray = {1, 2, 3, 4, 5};
        int[] secondArray = new int[5];
        // or int[] secondArrayExample = new int[firstArray.length]; ^^^
        int counter = 0;

        // for loop in reverse
        /* i = 4; go from the 4th index to the 0 index
        secondArray starts ar index 0 and grabs the value of firstArray index 4
        and places the firstArray value into the secondArray index, so on and so
        forth until firstArray[i] = 0
        */
        for (int i = firstArray.length -1; i >= 0; i--) {
            secondArray[counter] = firstArray[i];
            counter++;
        }
        System.out.println("This is our original array : " + Arrays.toString(firstArray));
        System.out.println("This is our reverse array : " + Arrays.toString(secondArray));



    }
}

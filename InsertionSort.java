package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class InsertionSort {

    private int[] getInsertionSort(int[] inputArray) {

        for(int i = 0; i < inputArray.length; i++) {

            // select the hole position where number is to be inserted
            int holePosition = i;
            int valueOfIndex = inputArray[i];

            // check if previous number is larger than value to be inserted
            while(holePosition > 0 && inputArray[holePosition - 1] > valueOfIndex) {
                // swap
                int temp = inputArray[holePosition - 1];
                inputArray[holePosition - 1] = inputArray[holePosition];
                inputArray[holePosition] = temp;

                holePosition--;
            }

            System.out.println((i+1) + ": " + Arrays.toString(inputArray));
        }

        return inputArray;
    }

    @Test
    public void testSorting() {
        int[] sortedArray = {1,2,3,4,5,6};

        int[] testArray1 = {6,2,3,5,1,4};
        System.out.println("input1:" + Arrays.toString(testArray1));
        int[] resultArray1 = getInsertionSort(testArray1);
        System.out.println("result1:" + Arrays.toString(resultArray1) + "\n");
        Assert.assertArrayEquals(sortedArray,resultArray1);

        int[] testArray2 = {3,5,2,4,6,1};
        System.out.println("input2:" + Arrays.toString(testArray2));
        int[] resultArray2 = getInsertionSort(testArray2);
        System.out.println("result2:" + Arrays.toString(resultArray2));
        Assert.assertArrayEquals(sortedArray,resultArray2);
    }
}

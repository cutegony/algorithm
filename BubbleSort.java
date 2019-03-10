package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleSort {

    private int[] getBubbleSort(int[] inputArray) {
        for(int i = 0; i < inputArray.length -1; i++) {
            for(int j = 0; j < inputArray.length -1; j++) {
                // Swap
                if(inputArray[j] > inputArray[j+1]) {
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j+1];
                    inputArray[j+1] = temp;
                }
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
        int[] resultArray1 = getBubbleSort(testArray1);
        System.out.println("result1:" + Arrays.toString(resultArray1) + "\n");
        Assert.assertArrayEquals(sortedArray,resultArray1);

        int[] testArray2 = {3,5,2,4,6,1};
        System.out.println("input1:" + Arrays.toString(testArray2));
        int[] resultArray2 = getBubbleSort(testArray2);
        System.out.println("result2:" + Arrays.toString(resultArray2));
        Assert.assertArrayEquals(sortedArray,resultArray2);
    }
}

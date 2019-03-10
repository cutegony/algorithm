package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SelectionSort {

    private int[] getSelectionSort(int[] inputArray) {
        for(int i = 0; i < inputArray.length -1; i++) {

            // assume the min is the first element
            int indexOfMin = i;
            int j = i + 1;

            // compare against elements after i to find the smallest
            while(j < inputArray.length) {
                if(inputArray[j] < inputArray[indexOfMin]) {
                    // found new minimum; remember its index
                    indexOfMin = j;
                }

                j++;
            }

            // swap if index i is not index of min
            if(i != indexOfMin) {
                int temp = inputArray[i];
                inputArray[i] = inputArray[indexOfMin];
                inputArray[indexOfMin] = temp;
            }

            System.out.println((i+1) + ": " + Arrays.toString(inputArray));
        }

        return inputArray;
    }

    @Test
    public void testSorting() {
        int[] sortedArray = {1,2,3,4,5,6};

        int[] testArray1 = {6,2,3,5,1,4};
        int[] resultArray1 = getSelectionSort(testArray1);
        System.out.println("result1:" + Arrays.toString(resultArray1) + "\n");
        Assert.assertArrayEquals(sortedArray,resultArray1);

        int[] testArray2 = {3,5,2,4,6,1};
        int[] resultArray2 = getSelectionSort(testArray2);
        System.out.println("result2:" + Arrays.toString(resultArray2));
        Assert.assertArrayEquals(sortedArray,resultArray2);
    }
}

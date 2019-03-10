package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeSort {

    private int[] getMergeSort(int[] inputArray) {
        System.out.println("Splitting: " + Arrays.toString(inputArray));

        if (inputArray.length > 1) {
            int mid = inputArray.length / 2;
            int[] leftHalf = getHalfArray(inputArray, mid, true);
            int[] rightHalf = getHalfArray(inputArray, mid, false);

            getMergeSort(leftHalf);
            getMergeSort(rightHalf);

            int i = 0, j = 0, k = 0;

            while (i < leftHalf.length && j < rightHalf.length) {
                if (leftHalf[i] < rightHalf[j]) {
                    inputArray[k] = leftHalf[i];
                    i++;
                } else {
                    inputArray[k] = rightHalf[j];
                    j++;
                }

                k++;
            }

            while (i < leftHalf.length) {
                inputArray[k] = leftHalf[i];
                i++;
                k++;
            }

            while (j < rightHalf.length) {
                inputArray[k] = rightHalf[j];
                j++;
                k++;
            }
        }

        System.out.println("Merging: " + Arrays.toString(inputArray));

        return inputArray;
    }

    private int[] getHalfArray(int[] inputArray, int mid, boolean isLeft) {
        int[] resultArray = null;

        if (isLeft) {
            resultArray = new int[mid];
            for (int i = 0; i < mid; i++) {
                resultArray[i] = inputArray[i];
            }
        } else {
            int i = 0;
            resultArray = new int[inputArray.length - mid];
            for (int j = mid; j <inputArray.length; j++) {
                resultArray[i] = inputArray[j];
                i++;
            }
        }

        return resultArray;
    }

    @Test
    public void testSorting() {
        int[] sortedArray = {1,2,3,4,5,6};

        int[] testArray1 = {6,2,3,5,1,4};
        System.out.println("input1:" + Arrays.toString(testArray1));
        int[] resultArray1 = getMergeSort(testArray1);
        System.out.println("result1:" + Arrays.toString(resultArray1) + "\n");
        Assert.assertArrayEquals(sortedArray,resultArray1);

        int[] testArray2 = {3,5,2,4,6,1};
        System.out.println("input2:" + Arrays.toString(testArray2));
        int[] resultArray2 = getMergeSort(testArray2);
        System.out.println("result2:" + Arrays.toString(resultArray2));
        Assert.assertArrayEquals(sortedArray,resultArray2);
    }
}

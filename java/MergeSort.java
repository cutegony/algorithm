package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeSort {

    private int[] getMergeSort(int[] inputArray) {
        System.out.println("Splitting: " + Arrays.toString(inputArray));

        if (inputArray.length > 1) {
            // get middle index of input array
            int mid = inputArray.length / 2;

            // get left half array of input array
            int[] leftHalf = getHalfArray(inputArray, mid, true);
            // get right half array of input array
            int[] rightHalf = getHalfArray(inputArray, mid, false);

            // recursion of left half array
            getMergeSort(leftHalf);
            // recursion of right half array
            getMergeSort(rightHalf);

            int indexOfLeftHalfArray = 0;
            int indexOfRightHalfArray = 0;
            int indexOfInputArray = 0;

            // case 1. there are left half array and right half array
            while (indexOfLeftHalfArray < leftHalf.length && indexOfRightHalfArray < rightHalf.length) {
                if (leftHalf[indexOfLeftHalfArray] < rightHalf[indexOfRightHalfArray]) {
                    inputArray[indexOfInputArray] = leftHalf[indexOfLeftHalfArray];
                    indexOfLeftHalfArray++;
                } else {
                    inputArray[indexOfInputArray] = rightHalf[indexOfRightHalfArray];
                    indexOfRightHalfArray++;
                }

                indexOfInputArray++;
            }

            // case 2. there is only left half array
            while (indexOfLeftHalfArray < leftHalf.length) {
                inputArray[indexOfInputArray] = leftHalf[indexOfLeftHalfArray];
                indexOfLeftHalfArray++;
                indexOfInputArray++;
            }

            // case 3. there is only right half array
            while (indexOfRightHalfArray < rightHalf.length) {
                inputArray[indexOfInputArray] = rightHalf[indexOfRightHalfArray];
                indexOfRightHalfArray++;
                indexOfInputArray++;
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

package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class QuickSort {

    private int[] getQuickSort(int[] inputArray, int start, int end) {
        // repeat until sublist has one item
        // because the algorithm is using in-place space, we can not use inputArray.length
        // we use start abd end for sublist instead of length of inputArray
        if (start < end) {
            // get pivot using partition method
            int pivot = partition(inputArray, start, end);

            // recurse quick sort left side from pivot
            getQuickSort(inputArray, start, pivot - 1);

            // recurse quick sort right side from pivot
            getQuickSort(inputArray, pivot + 1, end);
        }

        return inputArray;
    }

    private int partition(int[] inputArray, int start, int end) {
        // use end item as initial pivot
        int pivot = end;

        // use start as initial wall and index
        int wall = start;
        int index = start;

        // temp for swap
        int temp;

        // repeat until index item hit the end of list
        while (index < pivot) {
            // if index item is smaller than pivot, swap index item with wall and move wall to right
            // this will ensure items smaller than pivot stay left side from the wall and
            // the items greater than pivot stay right side from the wall
            if(inputArray[index] < inputArray[pivot]) {
                temp = inputArray[wall];
                inputArray[wall] = inputArray[index];
                inputArray[index] = temp;

                wall++;
            }

            index++;
        }

        // when index hit the end of list, swap pivot with wall
        temp = inputArray[wall];
        inputArray[wall] = inputArray[pivot];
        inputArray[pivot] = temp;

        // now left side of wall are the items smaller than wall
        // now right side of pivot are the items greater than wall
        // wall is the new pivot
        pivot = wall;

        return pivot;
    }

    @Test
    public void testSorting() {
        int[] sortedArray = {1, 2, 5, 7, 8, 10, 14, 21};

        int[] testArray1 = {2, 1, 8, 10, 7, 21, 5, 14};
        System.out.println("input1:" + Arrays.toString(testArray1));
        int[] resultArray1 = getQuickSort(testArray1, 0, testArray1.length - 1);
        System.out.println("result1:" + Arrays.toString(resultArray1) + "\n");
        Assert.assertArrayEquals(sortedArray,resultArray1);

        int[] testArray2 = {8, 1, 2, 5, 10, 14, 7, 21};
        System.out.println("input2:" + Arrays.toString(testArray2));
        int[] resultArray2 = getQuickSort(testArray2, 0, testArray1.length - 1);
        System.out.println("result2:" + Arrays.toString(resultArray2));
        Assert.assertArrayEquals(sortedArray,resultArray2);
    }
}

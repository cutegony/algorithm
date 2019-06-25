package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HeapSort {

    private int[] getHeapSort(int[] inputArray) {

        int size = inputArray.length;
        heapify(inputArray, size);
        int end = size - 1;

        while (end >= 0) {
            swap(inputArray, 0, end);
            siftdown(inputArray, 0, end);
            end--;
        }

        return inputArray;
    }

    private void swap(int[] inputArray, int index1, int index2) {
        int tmp = inputArray[index1];
        inputArray[index1] = inputArray[index2];
        inputArray[index2] = tmp;
    }

    private void siftdown(int[] inputArray, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        if (left <= size - 1 && inputArray[left] > inputArray[index]) {
            largest = left;
        }

        if (right <= size - 1 && inputArray[right] > inputArray[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(inputArray, index, largest);
            siftdown(inputArray, largest, size);
        }
    }

    private void heapify(int[] inputArray, int size) {
        int start = (size / 2) - 1;

        while (start >= 0) {
            siftdown(inputArray, start, size);
            start--;
        }
    }

    @Test
    public void testSorting() {
        int[] sortedArray = {1,2,3,4,5,5,6};

        int[] testArray1 = {6,2,3,5,1,4,5};
        System.out.println("input1:" + Arrays.toString(testArray1));
        int[] resultArray1 = getHeapSort(testArray1);
        System.out.println("result1:" + Arrays.toString(resultArray1) + "\n");
        Assert.assertArrayEquals(sortedArray,resultArray1);

        int[] testArray2 = {3,5,2,4,6,1,5};
        System.out.println("input2:" + Arrays.toString(testArray2));
        int[] resultArray2 = getHeapSort(testArray2);
        System.out.println("result2:" + Arrays.toString(resultArray2));
        Assert.assertArrayEquals(sortedArray,resultArray2);
    }
}

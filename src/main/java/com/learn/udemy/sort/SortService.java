package com.learn.udemy.sort;

import org.apache.commons.lang3.time.StopWatch;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortService {

    public int[] sort(int[] unsorted, SortType sortType, boolean showArray) {
        StopWatch stopWatch = new StopWatch();
        int[] result = new int[0];

        stopWatch.reset();
        stopWatch.start();
        switch (sortType) {
            case BUBBLE -> result = bubbleSort(unsorted);
            case SELECTION -> result = selectionSort(unsorted);
            case INSERTION -> result = insertionSort(unsorted);
            case SHELL -> result = shellSort(unsorted);
            case MERGE -> result = mergeSort(unsorted);
        }
        stopWatch.stop();
        if (showArray) {
            System.out.println(sortType + " sorted array: " + Arrays.toString(result));
        }
        System.out.println(sortType + " sort took: " + stopWatch.getTime() + "ms");

        return result;
    }

    private int[] mergeSort(int[] unsorted) {
        int[] result = unsorted.clone();

        mergeSort(result, 0, Array.getLength(result));

        return result;
    }

    private void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(input, start, mid);
        mergeSort(input, mid, end);

        merge(input, start, mid, end);
    }

    private void merge(int[] input, int start, int mid, int end) {
        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    private int[] shellSort(int[] unsorted) {
        int[] result = unsorted.clone();

        for (int gap = result.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < result.length; i++) {
                int newElem = result[i];

                int j = i;
                while (j >= gap && result[j - gap] > newElem) {
                    result[j] = result[j - gap];
                    j -= gap;
                }

                result[j] = newElem;
            }

        }

        return result;
    }


    private int[] bubbleSort(int[] unsorted) {
        int[] result = unsorted.clone();

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length - 1; j++) {
                if (result[j] > result[j + 1]) {
                    swap(result, j, j + 1);
                }
            }
        }
        return result;
    }

    private int[] selectionSort(int[] unsorted) {
        int[] result = unsorted.clone();

        for (int i = unsorted.length - 1; i > 0; i--) {
            int largest = 0;
            for (int j = 1; j <= i; j++) {
                if (result[j] > result[largest]) {
                    largest = j;
                }
            }
            swap(result, largest, i);
        }

        return result;
    }

    private int[] insertionSort(int[] unsorted) {
        int[] result = unsorted.clone();

        for (int i = 1; i < result.length; i++) {
            int newElem = result[i];
            int switchIndex;

            for (switchIndex = i; switchIndex > 0 && result[switchIndex - 1] > newElem; switchIndex--) {
                result[switchIndex] = result[switchIndex - 1];
            }

            result[switchIndex] = newElem;
        }


        return result;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
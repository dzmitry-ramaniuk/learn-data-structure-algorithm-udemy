package com.learn.udemy;

import com.learn.udemy.sort.SortService;

import java.util.Arrays;
import java.util.Random;

import static com.learn.udemy.sort.SortType.BUBBLE;
import static com.learn.udemy.sort.SortType.INSERTION;
import static com.learn.udemy.sort.SortType.SELECTION;
import static com.learn.udemy.sort.SortType.SHELL;

public class Main {
    public static void main(String[] args) {
        SortService sortService = new SortService();

        boolean showArray = false;
        int[] unsortedArray = generateRandomArray(10000);
        if (showArray) {
            System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));
        }

        sortService.sort(unsortedArray, BUBBLE, showArray);
        sortService.sort(unsortedArray, SELECTION, showArray);
        sortService.sort(unsortedArray, INSERTION, showArray);
        sortService.sort(unsortedArray, SHELL, showArray);
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(-50, 50);
        }

        return result;
    }


}

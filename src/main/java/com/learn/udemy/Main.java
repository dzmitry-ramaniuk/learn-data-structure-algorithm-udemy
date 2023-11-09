package com.learn.udemy;

import com.learn.udemy.sort.SortService;
import com.learn.udemy.structure.DoubleLinkedList;
import com.learn.udemy.structure.SingleLinkedList;

import java.util.Arrays;
import java.util.Random;

import static com.learn.udemy.sort.SortType.BUBBLE;
import static com.learn.udemy.sort.SortType.INSERTION;
import static com.learn.udemy.sort.SortType.MERGE;
import static com.learn.udemy.sort.SortType.QUICK;
import static com.learn.udemy.sort.SortType.SELECTION;
import static com.learn.udemy.sort.SortType.SHELL;

public class Main {
    public static void main(String[] args) {
        workWithSort();
        workWithLinkedList();
    }

    private static void workWithSort() {
        SortService sortService = new SortService();

        boolean showArray = false;
        int[] unsortedArray = generateRandomArray(100000);
        if (showArray) {
            System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));
        }

        sortService.sort(unsortedArray, BUBBLE, showArray);
        sortService.sort(unsortedArray, SELECTION, showArray);
        sortService.sort(unsortedArray, INSERTION, showArray);
        sortService.sort(unsortedArray, SHELL, showArray);
        sortService.sort(unsortedArray, MERGE, showArray);
        sortService.sort(unsortedArray, QUICK, showArray);

        SingleLinkedList<String> linkedList = new SingleLinkedList<>("node 3");
        linkedList.addToFrond("node 2");
        linkedList.addToFrond("node 1");

        linkedList.printSingleList();

        System.out.println("=========");

        linkedList.addToEnd("node 4");

        linkedList.printSingleList();
    }

    private static void workWithLinkedList() {
        DoubleLinkedList<String> linkedList = new DoubleLinkedList<>("node 1");
        linkedList.addToFront("node 1.1");
        linkedList.addToFront("node 1.2");

        linkedList.addToEnd("node 2");
        linkedList.addToEnd("node 3");

        linkedList.printDoubleLinkedList();

        System.out.println("----");

        linkedList.removeHead();
        linkedList.printDoubleLinkedList();

        System.out.println("----");

        linkedList.removeTail();
        linkedList.printDoubleLinkedList();

        System.out.println("++++");
        linkedList.addToEnd("node 4");
        linkedList.printDoubleLinkedList();
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

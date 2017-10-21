package com.test;

import java.util.Arrays;

public class ShellSort {
    private static int[] theArray;
    private static int arraySize;

    ShellSort(int newArraySize) {
        arraySize = newArraySize;
        theArray = new int[arraySize];
        generateRandomArray();
    }

    public void shellSort() {
        int interval = 1;

        while (interval <= arraySize / 3) {
            interval = interval * 3 + 1;// knuth sequence
        }

        while (interval > 0) {
            for (int i = interval; i < arraySize; i++) {
                int temp = theArray[i];
                int j = i;
                while (j > interval - 1 && theArray[j - interval] >= temp) {
                    theArray[j] = theArray[j - interval];
                    j = j - interval;
                }
                theArray[j] = temp;
            }
            interval = (interval - 1) / 3;
        }
    }

    private void generateRandomArray() {
        for (int i = 0; i < arraySize; i++) {
            theArray[i] = (int) (Math.random() * 99);
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort1 = new ShellSort(100);
        shellSort1.generateRandomArray();
        System.out.println(Arrays.toString(ShellSort.theArray));
        shellSort1.shellSort();
        System.out.println(Arrays.toString(ShellSort.theArray));
    }
}

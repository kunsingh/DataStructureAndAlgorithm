package com.test;

public class CountSort {
    static void countSort(int ages[]) {
        int oldestAge = 99;
        int timesOfAge[] = new int[oldestAge + 1];
        for (int i = 0; i <= oldestAge; ++i)
            timesOfAge[i] = 0;
        for (int i = 0; i < ages.length; ++i) {
            int age = ages[i];
            if (age < 0 || age > oldestAge)
                throw new IllegalArgumentException("Out of range.");
            ++timesOfAge[age];
        }
        int index = 0;
        for (int i = 0; i <= oldestAge; ++i) {
            for (int j = 0; j < timesOfAge[i]; ++j) {
                ages[index] = i;
                ++index;
            }
        }
    }

    public static void main(String[] args) {
        int[] ages = { 10, 5, 65, 23, 0, 8, 5, 9, 7, 9, 16 };
        CountSort.countSort(ages);
        for (int i = 0; i < ages.length; i++) {
            System.out.println(ages[i]);
        }
    }
}

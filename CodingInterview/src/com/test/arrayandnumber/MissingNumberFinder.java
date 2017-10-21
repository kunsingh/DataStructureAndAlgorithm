package com.test.arrayandnumber;

public class MissingNumberFinder {

    public static int findOneMissingNumber(int[] A, int n) {
        int sum = (n * (n + 1)) / 2;
        int arraySum = 0;
        for (int i : A) {
            arraySum = arraySum + i;
        }
        return sum - arraySum;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 4, 5, 6, 7, 9, 10 };
        System.out.println(findOneMissingNumber(A, 10));
    }
}

package com.test.arrayandnumber;

public class FindLargestElementInArray {

    public int getMaxFromArray(int[] A) {
        int max = -1;
        if (A.length == 0) {
            return max;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = { 0, 50, 10, 70, 8, 5, 62, 45, 1 };
        System.out.println(new FindLargestElementInArray().getMaxFromArray(A));
    }
}

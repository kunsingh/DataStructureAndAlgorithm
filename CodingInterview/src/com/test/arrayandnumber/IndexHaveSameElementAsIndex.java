package com.test.arrayandnumber;

public class IndexHaveSameElementAsIndex {

    //Sorted array
    public static int getValue(int[] A) {
        int low = 0;
        int high = A.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] - mid == 0) {
                return mid;
            }
            if (A[mid] - mid < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = { -1, 0, 2, 5, 6, 8 };
        System.out.println(getValue(A));
    }
}

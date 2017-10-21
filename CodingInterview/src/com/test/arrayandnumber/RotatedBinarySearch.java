package com.test.arrayandnumber;

/**
 * 
 * In fact, we don�t need to know where the pivot is. Look at the middle element
 * (7). Compare it with the left most (4) and right most element (2). The left
 * most element (4) is less than (7). This gives us valuable information � All
 * elements in the bottom half must be in strictly increasing order. Therefore,
 * if the key we are looking for is between 4 and 7, we eliminate the upper
 * half; if not, we eliminate the bottom half.
 * 
 */
public class RotatedBinarySearch {

    public static int rotatedBinarySearch(int[] A, int value) {
        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (A[mid] == value) {
                return A[mid];
            }
            // the bottom half is sorted
            if (A[low] <= A[mid]) {
                if (A[low] <= value && A[mid] > value) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // the upper half is sorted
            else {
                if (A[mid] < value && value <= A[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    // increasing/decreasing
    public static int incDecBinarySearch(int[] A, int value) {
        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (A[mid] == value) {
                return A[mid];
            }
            // the bottom half is sorted
            if (A[low] <= A[mid]) {
                if (A[low] <= value && A[mid] > value) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // the upper half is sorted
            else {
                if (A[mid] < value && value <= A[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
         int[] A = { 6, 8, 1, 2, 4, 5 };
//        int[] A = { 1, 2, 3, 10, 9, 8, 7, 5, 4 };
        System.out.println(rotatedBinarySearch(A, 8));
        System.out.println(rotatedBinarySearch(A, 5));
        System.out.println(rotatedBinarySearch(A, 10));
    }
}

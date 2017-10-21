package com.test.binarysearch;

public class BinarySearch {

    public int binarySearch(int[] A, int start, int end, int value) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (A[mid] == value) {
                return mid;
            }
            if (A[mid] < value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] A = { 3, 5, 6, 8, 10, 14, 18, 19, 20 };
        System.out.println(new BinarySearch().binarySearch(A, 0, A.length-1, 8));
        System.out.println(new BinarySearch().binarySearch(A, 0, A.length-1, 15));
        System.out.println(new BinarySearch().binarySearch(A, 0, A.length-1, 19));
    }
}

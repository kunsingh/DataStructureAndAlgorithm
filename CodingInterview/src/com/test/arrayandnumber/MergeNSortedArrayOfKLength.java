package com.test.arrayandnumber;

public class MergeNSortedArrayOfKLength {
    public static void main(String[] args) {
        int[] arr1 = { 2, 4, 6, 8, 9, };
        int[] arr2 = { 3, 6, 7, 9, 22 };
        int[] arr3 = { 2, 5, 7, 8, 10 };
        int[] arr4 = { 4, 8, 23, 26, 28 };
        int[] result = mergeNArrays(new int[][] { arr1, arr2, arr3, arr4 }, 5);
        for (int i : result) {
            System.out.print("" + i + ",");
        }
    }

    private static int[] mergeNArrays(int[][] A, int n) {
        MinHeap minHeap = new MinHeap(A.length * n);
        int[] AA = new int[A.length * n];
        int k = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < A.length; i++) {
                minHeap.insertKey(A[i][j]);
            }
            AA[k++] = minHeap.extractMin();
        }
        while (minHeap.size() > 0) {
            AA[k++] = minHeap.extractMin();
        }
        return AA;
    }
}

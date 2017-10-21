package com.test.arrayandnumber;

public class MedianOfTwoSortedArray {

    public static double medianOfSortedArray(int[] a, int[] b) {
        int medianPosition = (a.length + b.length) / 2;
        int aIndex = 0;
        int bIndex = 0;
        double median = 0;
        if ((a.length + b.length) % 2 != 0){//even case
            medianPosition++;
        }
        // loop till you reach the medianIndex
        while ((aIndex + bIndex) < medianPosition) {
            if ((aIndex < a.length && bIndex < b.length && a[aIndex] <= b[bIndex]) || bIndex >= b.length) {
                median = a[aIndex];
                aIndex++;
            } else {
                median = b[bIndex];
                bIndex++;
            }
        }
        // in case of even numbers of integers
        if ((a.length + b.length) % 2 == 0) {
            if ((aIndex < a.length && bIndex < b.length && a[aIndex] <= b[bIndex]) || bIndex >= b.length) {
                median = ((median + a[aIndex]) * 1.0) / 2;
            } else {
                median = ((median + b[bIndex]) * 1.0) / 2;
            }
        }
        return median;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 8 };
        int[] B = {  2, 4, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 100 };
        System.out.println(medianOfSortedArray(A, B));
    }
}

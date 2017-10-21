package com.test.arrayandnumber;

public class RemoveDuplicateFromPrimeArray {

    static int[] getDuplicatesInPrimeArray(int[] arr) {
        int[] dup = new int[arr.length];
        int product = 1;
        int j = 0;
        for (int i : arr) {
            if (product % i == 0) {
                dup[j++] = i;
            } else {
                product = product * i;
            }
        }
        return dup;
    }

    public static void main(String[] args) {
        int[] A = getDuplicatesInPrimeArray(new int[] { 2, 3, 5, 7, 11, 13, 2, 5 });
        for (int i : A) {
            System.out.print(i + " ");
        }
    }
}

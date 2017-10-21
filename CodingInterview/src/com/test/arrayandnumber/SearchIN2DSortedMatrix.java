package com.test.arrayandnumber;

public class SearchIN2DSortedMatrix {

    public static boolean find(int matrix[][], int value) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = rows * cols - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            System.out.println(mid);
            int row = mid / cols;
            int col = mid % cols;
            System.out.println(row + "--" + col);
            int v = matrix[row][col];
            if (v == value) {
                return true;
            }
            if (v > value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(find(A, 2));
        System.out.println(find(A, 10));
    }
}

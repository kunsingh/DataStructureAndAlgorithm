package com.test.arrayandnumber;

public class SearchInPartiallySortedMatrix {

    public boolean find(int matrix[][], int value) {

        boolean found = false;
        int row = 0;
        int col = matrix[0].length;

        while (row < matrix.length && col > 0) {
            if (matrix[row][col] == value) {
                found = true;
                break;
            }
            if (matrix[row][col] > value)
                --col;
            else
                ++row;
        }
        return found;
    }
}

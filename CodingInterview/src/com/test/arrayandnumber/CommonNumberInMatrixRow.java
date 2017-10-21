package com.test.arrayandnumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CommonNumberInMatrixRow {

    public static void getCommonElement(int[][] matrix) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < matrix[0].length; i++) {
            map.put(matrix[0][i], 1);
        }
        Set<Entry<Integer, Integer>> set = map.entrySet();
        for (Entry<Integer, Integer> entry : set) {
            System.out.println(entry.getKey() + "-----" + entry.getValue());
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (map.containsKey(matrix[i][j])) {
                    map.put(matrix[i][j], map.get(matrix[i][j])+1);
                }
            }
        }

        set = map.entrySet();
        for (Entry<Integer, Integer> entry : set) {
            System.out.println(entry.getKey() + "-----" + entry.getValue());
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = i+j*j;
            }
        }
        
        matrix[0][3] = 5;
        matrix[2][0] = 5;
        matrix[3][2] = 5;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
        
        getCommonElement(matrix);
    }
}

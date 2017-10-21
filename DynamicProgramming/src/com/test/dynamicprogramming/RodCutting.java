package com.test.dynamicprogramming;

public class RodCutting {

    public static int cutRod(int price[]) {
        int[] revenue = new int[price.length + 1];
        revenue[0] = 0;
        for (int i = 1; i <= price.length; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int length = 0; length < i; length++) {
                max_val = Math.max(max_val, price[length] + revenue[i - length - 1]);
            }
            revenue[i] = max_val;
        }

        return revenue[price.length];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        System.out.println(cutRod(arr));
    }

}

package com.test.dynamicprogramming;

public class KnapSack {

    public static int getMaxValue(int value[], int weight[], int maxWeight) {
        if (value.length == 0 || weight.length == 0) {
            return 0;
        }
        //create a table of n+1 rows and w+1 column
        int[][] F = new int[value.length + 1][maxWeight + 1];
        for (int w = 0; w <= maxWeight; w++) {
            F[0][w] = 0;//fill first row with 0
        }
        for (int i = 1; i <= value.length; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (weight[i - 1] <= w)
                    F[i][w] = max(F[i - 1][w], value[i - 1] + F[i - 1][w - weight[i - 1]]);
                else
                    F[i][w] = F[i - 1][w];
            }
        }
        return F[value.length][maxWeight];
    }

    private static int max(int i, int j) {
        return i > j ? i : j;
    }

    public static int knapsack_rec(int capacity, int[] weight, int[] value, int n) {
        if (n == 0 || capacity == 0) {
            return 0;
        }
        if (weight[n - 1] > capacity) {
            return knapsack_rec(capacity, weight, value, n - 1);
        } else {
            return max(value[n - 1] + knapsack_rec(capacity - weight[n - 1], weight, value, n - 1), knapsack_rec(capacity, weight, value, n - 1));
        }
    }

    public static int knapSack_Greedy(int values[], int[] weights, int capacity) {
        int load = 0;
        int i = 0;
        int w = 0;
        while (load < capacity && i <= 4) {
            if (weights[i] <= (capacity - load)) {
                w += values[i];
                load += weights[i];
            } else {
                int r = (capacity - load) / weights[i];
                w += r * values[i];
                load += weights[i];
            }
            ++i;
        }
        return w;
    }

    public static void main(String[] args) {
        int value[] = { 60, 100, 120, 170 };
        int weight[] = { 10, 20, 30, 40 };
        int maxWeight = 50;
        System.out.println(getMaxValue(value, weight,maxWeight));
    }
}

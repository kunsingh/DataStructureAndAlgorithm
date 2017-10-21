package com.test.dynamicprogramming;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite
 * supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we
 * make the change? The order of coins doesn’t matter. For example, for N = 4
 * and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So
 * output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five
 * solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output
 * should be 5.
 * 
 */
public class NoOfChangeMakingCombinations {

    public static int getChangeMakingCombinations(int coins[], int amount) {
        int[] F = new int[amount + 1];
        F[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                F[j] = F[j] + F[j - coins[i]];// pick one coin
            }
        }

        return F[amount];
    }

    public static void main(String[] args) {
        int[] coins ={41, 34, 46, 9, 37, 32, 42, 21, 7 ,13, 1, 24, 3, 43, 2, 23, 8 ,45, 19, 30, 29, 18, 35, 11};// new int[M];
        System.out.println(NoOfChangeMakingCombinations.getChangeMakingCombinations(coins, 250));
    }
}

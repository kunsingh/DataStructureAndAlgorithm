package com.test.dynamicprogramming;

/**
 * Coin-rowproblem There is a row of n coins whose values are some positive
 * integers c1, c2, . . . , cn, not necessarily distinct. The goal is to pick up
 * the maximum amount of money subject to the constraint that no two coins
 * adjacent in the initial row can be picked up.
 * 
 * Question: There is an integer array consisting positive numbers only. Find
 * maximum possible sum of elements such that there are no 2 consecutive
 * elements present in the sum.
 * 
 */
public class CoinRow {

    public int getMaximumAmount(int[] coins) {

        assert coins.length > 0 : "no coins to select";
        
        int[] C = new int[coins.length + 1];
        for(int i=0;i<coins.length;i++){
            C[i+1] = coins[i];//make room at first place
        }

        int[] F = new int[coins.length + 1];
        F[0] = 0;
        F[1] = C[1];

        for (int i = 2; i <= coins.length; i++) {
            F[i] = max(C[i] + F[i - 2], F[i - 1]);
        }
        return F[coins.length];
    }

    private Integer max(int i, int j) {
        return i > j ? i : j;
    }

    public static void main(String[] args) {
        int[] coins = { 5, 22, 26, 10, 4, 8 };//{5,1,2,10,6,2};//
        System.out.println(new CoinRow().getMaximumAmount(coins));
    }
}

package com.test.dynamicprogramming;

/**
 * Give change for amount n using the minimum number of coins of denominations
 * d1<d2 < . . .<dm. Let C[p] be the minimum number of coins needed to make
 * change for p cents. Let x be the value of the first coin used in the optimal
 * solution. Then C[p] = 1 + C[p − x] . We will try all possible x and take the
 * minimum. C[p] = {min,i:d[i]<=p{C[P-d[i]]+1}} if P>= 0 if p = 0
 */
public class MinimumCoinChange {

    public static int getChange(int coins[], int amount) {
        int[] F = new int[amount + 1]; // table to fill minimum number of coins
        F[0] = 0;
        
        for (int amt = 1; amt <= amount; amt++) {
            int min = Integer.MAX_VALUE;
            int j = 0;
            while (j < coins.length && amt >= coins[j]) {
                min = minimum(F[amt - coins[j]], min);
                j++;
            }
            F[amt] = min + 1;// add 1 coins
        }
        return F[amount];
    }

    private static int minimum(int i, int j) {
        return i < j ? i : j;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3 };
        System.out.println(getChange(A, 10));
    }
}

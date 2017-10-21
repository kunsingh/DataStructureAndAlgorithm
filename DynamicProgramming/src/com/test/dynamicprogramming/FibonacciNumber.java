package com.test.dynamicprogramming;

import java.util.Arrays;

public class FibonacciNumber {

    private static final int MAXN = 45;
    private Integer[] f = new Integer[MAXN];

    public int fibonacci_(int n) {
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public int fibonacci(int n) {
        int back2 = 0;
        int back1 = 1;
        int next;
        for (int i = 2; i < n; i++) {
            next = back2 + back1;
            back2 = back1;
            back1 = next;

        }
        return back2 + back1;
    }

    public int fibonacci_rec(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci_rec(n - 1) + fibonacci_rec(n - 2);
    }

    public int fibonacci_optimum(int n) {

        int num = n;
        if (num <= 0) {
            return 0;
        } else if (num <= 2) {
            return 1;
        }

        int[][] number = { { 1, 1 }, { 1, 0 } };
        int[][] result = { { 1, 1 }, { 1, 0 } };

        while (num > 0) {
            if (num % 2 == 1) {
                result = MultiplyMatrix(result, number);
            }
            number = MultiplyMatrix(number, number);
            num /= 2;
        }
        return result[1][1];
    }

    public int fibonacci_Using_Matrix(int n) {
        int num = n;
        if (num <= 0) {
            return 0;
        } else if (num <= 2) {
            return 1;
        }

        int[][] result = { { 1, 1 }, { 1, 0 } };
        int[][] number = { { 1, 1 }, { 1, 0 } };

        for (int i = 2; i < num; i++) {
            result = MultiplyMatrix(result, number);
        }
        return result[0][0];
    }

    public static int[][] MultiplyMatrix(int[][] mat1, int[][] mat2) {
        return new int[][] { { mat1[0][0] * mat2[0][0] + mat1[0][1] * mat2[1][0], mat1[0][0] * mat2[0][1] + mat1[0][1] * mat2[1][1] },
                { mat1[1][0] * mat2[0][0] + mat1[1][1] * mat2[1][0], mat1[1][0] * mat2[0][1] + mat1[1][1] * mat2[1][1] } };
    }

    /**
     * Binet's formula
     */
    double fib_Binet(long n) {
        double phi = (Math.sqrt(5) + 1) / 2.0;
        return Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }

    
    public static int[] fibonacci1(int n){
        int[] f = new int[45];//after this limit it will not work
        f[0]=0;
        f[1] = 1;
        
        for(int i=2;i<n;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f;
        
    }
    public static void main(String[] args) {
        FibonacciNumber fb = new FibonacciNumber();
        // System.out.println(fb.fibonacci_optimum(70));
        System.out.println(Arrays.toString(fibonacci1(6)));
    }
}

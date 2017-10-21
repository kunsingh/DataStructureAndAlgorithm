package com.test.general;

public class NumberIsPowerOf2 {

    static boolean isPowerOf2(int x) {
        while (((x % 2) == 0) && x > 1) {
            x /= 2;
        }
        return (x == 1);
    }

    static boolean isPowerOf2_ultimate(int x) {
        return x > 0 && (x & (x - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2_ultimate(8));
    }
}

package com.test.arrayandnumber;

public class GreatestCommonDivisor {

    public static int gcdrec(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b; // base case
        }
        return gcdrec(b, a % b);
    }

    static int gcd(int a, int b) {
        while (a != 0 && b != 0) // until either one of them is 0
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a + b; // either one is 0, so return the non-zero value
    }

    public static void GCD(int a, int b) {

        int temp;
        // make a greater than b
        if (b > a) {
            temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            // gcd of b and a%b
            temp = a % b;
            // always make a greater than bf
            a = b;
            b = temp;

        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        System.out.println(gcd(16, 4));
    }
}

package com.test.arrayandnumber;

public class PowerOf2 {

    public static boolean isPoerOf2(int number) {
        if (number == 0) {
            return false;
        }
        return (number & (number - 1)) == 0;
    }

    public static boolean isPowerOf2(int number) {
        if (number == 0) {
            return false;
        }
        while (number % 2 == 0) {
            number = number / 2;
        }
        if (number > 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2(10));
    }
}

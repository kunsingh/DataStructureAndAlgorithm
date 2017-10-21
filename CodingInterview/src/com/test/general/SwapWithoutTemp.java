package com.test.general;

public class SwapWithoutTemp {

    public static void swap(int a, int b) {
        a = a - b;
        b = a + b;
        a = b - a;
        System.out.println("a: " + a + " b: " + b);
    }

    public static void main(String[] args) {
        System.out.println("a: " + 5 + " b: " + 4);
        swap(5, 4);
    }
}

package com.test.arrayandnumber;

public class LeastCommonDivisor {

    public static int findListCommonDivisor(int n, int m) {
        int result = 0;
        if (n == m) {
            result = n;
        } else if (n < m) {
            result = calculateLCD(n, m);
        } else {
            result = calculateLCD(m, n);
        }
        return result;
    }

    private static int calculateLCD(int lowerValue, int higherValue) {
        int lcd = higherValue;
        if (lcd % lowerValue == 0) {
            return higherValue;
        } else {
            int i = 2;
            while (true) {
                lcd = higherValue * i++;
                if (lcd % lowerValue == 0) {
                    break;
                }
            }
        }
        return lcd;
    }

    public static void main(String[] args) {
        System.out.println(LeastCommonDivisor.findListCommonDivisor(6, 14));
    }
}

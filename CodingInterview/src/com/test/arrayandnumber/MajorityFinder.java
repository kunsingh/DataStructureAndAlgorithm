package com.test.arrayandnumber;

public class MajorityFinder {

    public static int getMajorityNumber(int[] A) {
        int result = A[0];
        int times = 1;
        for (int i = 1; i < A.length; ++i) {
            if (times == 0) {
                result = A[i];
                times = 1;
            } else if (A[i] == result) {
                times++;
            } else
                times--;
        }
        if (!checkMajorityExistence(A, result))
            throw new IllegalArgumentException("No majority exisits.");
        return result;
    }

    static boolean checkMajorityExistence(int[] numbers, int number) {
        int times = 0;
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] == number)
                times++;
        }
        return (times * 2 > numbers.length);
    }
}

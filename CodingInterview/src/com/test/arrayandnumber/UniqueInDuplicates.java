package com.test.arrayandnumber;

public class UniqueInDuplicates {

    public static int findUnique(int[] A) {
        assert A.length > 0 : "Empty array.";
        int result = 0;
        for (int i : A) {
            result = result ^ i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 18, 2, 3, 1 };
        System.out.println(findUnique(A));
    }

    void findMissing_solution1(int numbers[], NumbersOccurringOnce missing) {
        int sum1 = 0;
        int product1 = 1;
        for (int i = 0; i < numbers.length; ++i) {
            sum1 += numbers[i];
            product1 *= numbers[i];
        }
        int sum2 = 0;
        int product2 = 1;
        for (int i = 1; i <= numbers.length + 2; ++i) {
            sum2 += i;
            product2 *= i;
        }
        int s = sum2 - sum1;
        int p = product2 / product1;
        missing.num1 = (s + (int) (Math.sqrt(s * s - 4 * p))) / 2;
        missing.num2 = s - missing.num1;
    }

    void getOnce(int numbers[], NumbersOccurringOnce once) {
        if (numbers.length < 2)
            return;
        int resultExclusiveOR = 0;

        for (int i = 0; i < numbers.length; ++i) {
            resultExclusiveOR ^= numbers[i];
        }

        int indexOf1 = findFirstBitIs1(resultExclusiveOR);

        once.num1 = once.num2 = 0;
        for (int j = 0; j < numbers.length; ++j) {
            if (isBit1(numbers[j], indexOf1))
                once.num1 ^= numbers[j];
            else
                once.num2 ^= numbers[j];
        }
    }

    // The first 1 bit from the rightmost
    int findFirstBitIs1(int num) {
        int indexBit = 0;
        while (((num & 1) == 0) && (indexBit < 32)) {
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    // check whether the bit with index indexBit is 1
    boolean isBit1(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 1;
    }
}

class NumbersOccurringOnce {
    public int num1;
    public int num2;
}
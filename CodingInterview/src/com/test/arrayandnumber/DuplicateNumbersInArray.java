package com.test.arrayandnumber;

public class DuplicateNumbersInArray {

    public static int duplicate(int numbers[]) {
        int length = numbers.length;
        for (int i = 0; i < length; ++i) {
            if (numbers[i] < 0 || numbers[i] > length - 1)
                throw new IllegalArgumentException("Invalid numbers.");
        }
        for (int i = 0; i < length; ++i) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        throw new IllegalArgumentException("No duplications.");
    }

    public static void main(String[] args) {
        System.out.println(DuplicateNumbersInArray.duplicate(new int[] { 0, 1, 2, 3, 4, 5, 4, 6, 3, 7 }));
    }
}

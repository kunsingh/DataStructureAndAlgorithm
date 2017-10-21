package com.test.arrayandnumber;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstElementInArrayThatOccursEvenOrOddNumberOfTimes {

    public enum EVENORODD {
        EVEN(new Object()), ODD(new Object());

        Object object;

        EVENORODD(Object object) {
            this.object = object;
        };
    }

    public static void main(String[] args) {
        System.out.println("First even number :" + firstElementThatOccursEvenOrOddNumberOfTimes(new int[] { 1, 2, 1, 3, 5, 2, 1 }, EVENORODD.EVEN));
        System.out.println("First even number :" + firstElementThatOccursEvenOrOddNumberOfTimes(new int[] { 1, 2, 1, 3, 5, 2, 1 }, EVENORODD.ODD));

    }

    private static Integer firstElementThatOccursEvenOrOddNumberOfTimes(int[] array, EVENORODD evenOrOdd) {

        Map<Integer, Object> map = new LinkedHashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) == EVENORODD.EVEN ? EVENORODD.ODD : EVENORODD.EVEN);
            } else {
                map.put(i, EVENORODD.ODD);
            }
        }

        for (Map.Entry<Integer, Object> entry : map.entrySet()) {
            if (entry.getValue() == evenOrOdd) {
                return entry.getKey();
            }
        }
        return -1;
    }
}

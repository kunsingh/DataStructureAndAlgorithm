package com.test.string;

public class RotationTest {

    public static boolean isRotation(String s1, String s2) {
        assert s1 != null && s2 != null;

        return isSubString(s1 + s2, s2);
    }

    private static boolean isSubString(String s1, String s2) {
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        System.out.println(isRotation("kunal", "alkun"));
    }
}

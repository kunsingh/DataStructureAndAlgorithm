package com.test.string;

public class ReplaceSpaceWithPercent20 {

    public static void replaceFun(String s) {
        int spaceCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int newLength = s.length() + (spaceCount * 3);
        char[] charArray = new char[newLength];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                charArray[j] = '%';
                charArray[j + 1] = '2';
                charArray[j + 2] = '0';
                j = j + 3;
            } else {
                charArray[j] = s.charAt(i);
                j++;
            }
        }
        System.out.println(new String(charArray));
    }

    public static void main(String[] args) {
        String str = "abc d e f";
        replaceFun(str);
    }
}

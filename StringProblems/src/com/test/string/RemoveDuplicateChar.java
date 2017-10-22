package com.test.string;

public class RemoveDuplicateChar {

    public static String removeDuplicateChar(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            if (!newString.contains(s.charAt(i) + "")) {
                newString = newString + s.charAt(i);
            }
        }
        return newString;
    }

    public static char[] removeDuplicates(char[] str) {
        if (str == null)
            return null;
        int len = str.length;
        if (len < 2)
            return str;

        int tail = 1;

        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (str[i] == str[j])
                    break;
            }
            if (j == tail) {
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0;
        return str;
    }

    public static void main(String[] args) {
        String s = "I am a good boy";

        System.out.println(RemoveDuplicateChar.removeDuplicateChar(s));
        System.out.println(RemoveDuplicateChar.removeDuplicates(new char[] { 'a', 'v', 'v', 's', 'a' }));
    }
}

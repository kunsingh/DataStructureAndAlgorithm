package com.test.string;

public class StringHasAllUniqueChar {

    private static final char[] charArray = new char[256];

    public static boolean checkForUniqueCharacter1(String s) {
        assert s != null && s.length() > 0 && s.length() < 256;
        
        
        for (int i = 0; i < s.length(); i++) {
            if (charArray[s.charAt(i)] == '\0') {
                charArray[s.charAt(i)] = s.charAt(i);
            } else {
                return false;
            }
        }
        return true;
    }

    private static final boolean[] boolArray = new boolean[256];

    public static boolean checkForUniqueCharacter2(String s) {
        assert s != null && s.length() < 256;
        
        for (int i = 0; i < s.length(); i++) {
            if (boolArray[s.charAt(i)]) {
                return false;
            } else {
                boolArray[s.charAt(i)] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkForUniqueCharacter2("kunal1234"));
    }
}

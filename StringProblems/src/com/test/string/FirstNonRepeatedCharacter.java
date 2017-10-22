package com.test.string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

    public static char firstNonRepeatedCharacter(String word) {
        Map<Character, Integer> characterCount = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (characterCount.containsKey(c)) {
                characterCount.put(c, characterCount.get(c) + 1);
            } else {
                characterCount.put(c, 1);
            }
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (characterCount.get(c) == 1) {
                return c;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatedCharacter("aaabbeedceffghhi"));
    }
}

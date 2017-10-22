package com.test.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class StringPermutation {

    private static int count = 0;
    private boolean[] used;
    private StringBuilder out = new StringBuilder();
    private final String in;

    public StringPermutation(final String str) {
        in = str;
        used = new boolean[in.length()];
    }

    public void permute() {
        if (out.length() == in.length()) {
            count++;
            System.out.println(out + "--" + count);
            return;
        }
        for (int i = 0; i < in.length(); ++i) {
            if (used[i]) {
                continue;
            }
            out.append(in.charAt(i));
            used[i] = true;
            permute();
            used[i] = false;
            out.setLength(out.length() - 1);
            System.out.println("I am here");
        }
    }

    public void permute(String string) {
        if (null == string || string.isEmpty()) {
            return;
        }

        List<String> stringList = new LinkedList<String>();
        stringList.add(String.valueOf(string.charAt(0))); // add the first
                                                          // element to

        List<String> tempList = new LinkedList<String>();

        for (int i = 1; i < string.length(); i++) {
            for (int j = 0; j < stringList.size(); j++) {
                tempList.addAll(merge(string.charAt(i), stringList.get(j)));
            }
            stringList.clear();
            stringList.addAll(tempList);
            tempList.clear();
        }

        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }
    }

    /**
     * helper method that appends the given character at each position in the
     * given string and returns a set of such modified strings - set removes
     * duplicates if any(in case a character is repeated)
     */
    private Set<String> merge(Character c, String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Set<String> set = new HashSet<String>();
        StringBuilder sb = null;

        for (int i = 0; i <= s.length(); i++) {
            sb = new StringBuilder();
            sb.append(s.substring(0, i) + c + s.substring(i, s.length()));
            set.add(sb.toString());
        }

        return set;
    }

    public static void main(String[] args) {
        new StringPermutation("kunal").permute("kunal");
    }
}

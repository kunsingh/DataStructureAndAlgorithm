package com.test.string;

public class StringHasDuplicateChar {

	public static boolean isDuplicateExist(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isDuplicateExist2(String s) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			if (char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(StringHasDuplicateChar.isDuplicateExist2("kunal"));
	}
}

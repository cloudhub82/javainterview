package com.assignment.string;

public class Sample {

	public static void main(String[] args) {

		String str = "madams";
		System.out.print(isPalindromRecursive(0, str.length() - 1, str));

	}

	private static boolean isPalindromRecursive(int i, int j, String str) {

		if (i >= j)
			return true;

		if (str.charAt(i) != str.charAt(j))
			return false;

		i++;
		j--;

		return isPalindromRecursive(i, j, str);

	}

	private static void isPalindromSimple() {
		// Methods for Palindrome String in Java
		String str = "MADAM";
		int len = str.length() - 1;
		boolean palindrom = true;
		System.out.println(len);

		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) == str.charAt(len - i)) {
				continue;
			} else {
				palindrom = false;
			}
		}

		System.out.println(palindrom);
	}

	private static void insertString() {
		/*
		 * Given a String, the task is to insert another string in between the given
		 * String at a particular specified index in Java.
		 * 
		 * Input: originalString = "GeeksGeeks", stringToBeInserted = "For", index = 4
		 * Output: "GeeksForGeeks"
		 */

		String originalString = "GeeksGeeks";
		String stringToBeInserted = "For";
		String newString = "";
		String newString1 = "";
		int index = 4;
		int len = originalString.length();

		System.out.println(
				originalString.substring(0, index + 1) + stringToBeInserted + originalString.substring(index + 1));

		for (int i = 0; i < len; i++) {
			newString = newString + originalString.charAt(i);
			if (i == index) {
				newString = newString + stringToBeInserted;
			}
		}
		System.out.println(newString);
		StringBuffer newStringBuffer = new StringBuffer("GeeksGeeks");
		newStringBuffer.insert(index + 1, stringToBeInserted);
		System.out.println(newStringBuffer);
	}
}

package com.assignment.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {

	public static void main(String[] args) {

		

	}

	private static void reverString() {
		String input = "GeeksforGeeks";

		// getBytes() method to convert string
		// into bytes[].
		byte[] strAsByteArray = input.getBytes();
		int len = strAsByteArray.length;
		byte[] result = new byte[strAsByteArray.length];

		for (int i = 0; i < strAsByteArray.length; i++)
			System.out.print(strAsByteArray[i] + " ");

		for (int i = 0; i < len; i++) {
			result[i] = strAsByteArray[len - i - 1];
		}

		System.out.println("******************************************");

		for (int i = 0; i < strAsByteArray.length; i++)
			System.out.print(result[i] + " ");

		System.out.println(new String(result));
		
		
		char[] charr = { 'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's' };

		// string
		String str = Stream.of(charr).map(arr -> new String(arr)).peek(arr -> System.out.println("ppppppppppppppp"+arr))
				.collect(Collectors.joining());
	}

	private static void reverseStringSimple() {
		String str1 = "RAY";
		String str2 = "";
		for (int i = 0; i < str1.length(); i++) {

			char ch = str1.charAt(i);
			str2 = ch + str2;

		}

		System.out.println(str2);
	}

	private static boolean isAnagramHashMap() {

		String str1 = "RAY";
		String str2 = "TAR";
		if (str1.length() != str2.length()) {
			return false;
		}
		Map<Character, Integer> charMap = new HashMap<>();

		for (int i = 0; i < str1.length(); i++) {
			if (charMap.containsKey(str1.charAt(i))) {
				charMap.put(str1.charAt(i), charMap.get(str1.charAt(i)) + 1);
			} else {
				charMap.put(str1.charAt(i), 1);
			}

		}

		for (int i = 0; i < str2.length(); i++) {
			if (charMap.containsKey(str2.charAt(i))) {
				charMap.put(str1.charAt(i), charMap.get(str1.charAt(i)) - 1);
			}

		}

		for (Entry<Character, Integer> set : charMap.entrySet()) {
			if (charMap.get(set.getKey()) != 0) {
				return false;
			}
		}

		return true;

	}

	private static boolean isAnagramSimple() {

		String str1 = "RAT";
		String str2 = "TAR";
		int NO_OF_CHARS = 256;
		int[] countArr = new int[NO_OF_CHARS];
		/*
		 * str1 = str1.toLowerCase(); str2 = str2.toLowerCase();
		 */

		if (str1.length() != str2.length()) {
			return false;
		}

		for (int k = 0; k < str1.length(); k++) {
			countArr[str1.charAt(k)]++;
			countArr[str2.charAt(k)]--;
		}

		for (int j = 0; j < NO_OF_CHARS; j++) {
			if (countArr[j] != 0) {
				return false;
			}
		}

		return true;

	}

	private static void toCharArray(String str) {

		// Converts the string into
		// char array
		char[] arr = str.toCharArray();

		// Printing the characters using for-each loop
		for (char e : arr)
			System.out.print(e + " ");
	}

	/*
	 * String str = "madams"; System.out.print(isPalindromRecursive(0, str.length()
	 * - 1, str));
	 */
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

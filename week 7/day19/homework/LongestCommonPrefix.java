//Q5. Longest Common Prefix
//Problem Description
//
//Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in the array.
//
//Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
//
//For Example: longest common prefix of "abcdefgh" and "abcefgh" is "abc".
//
//
//
//Problem Constraints
//
//0 <= sum of length of all strings <= 1000000
//
//
//
//Input Format
//
//The only argument given is an array of strings A.
//
//
//
//Output Format
//
//Return the longest common prefix of all strings in A.
//
//
//
//Example Input
//
//Input 1:
//
//A = ["abcdefgh", "aefghijk", "abcefgh"]
//Input 2:
//
//A = ["abab", "ab", "abcd"];
//
//
//Example Output
//
//Output 1:
//
//"a"
//Output 2:
//
//"ab"
//
//
//Example Explanation
//
//Explanation 1:
//
//Longest common prefix of all the strings is "a".
//Explanation 2:
//
//Longest common prefix of all the strings is "ab".

package day19.homework;

import java.util.ArrayList;
import java.util.Collections;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(ArrayList<String> A) {

		Collections.sort(A);

		StringBuilder result = new StringBuilder();

		String firstStr = A.get(0);
		String lastStr = A.get(A.size() - 1);

		for (int i = 0; i < firstStr.length() && i < lastStr.length(); i++) {
			if (firstStr.charAt(i) == lastStr.charAt(i)) {
				result.append(firstStr.charAt(i));
			} else {
				break;
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {
		ArrayList<String> A = new ArrayList<>();
//		["abcdefgh", "aefghijk", "abcefgh"]
		A.add("abcdefgh");
		A.add("aefghijk");
		A.add("abcefgh");
		System.out.println(longestCommonPrefix(A));
	}
}

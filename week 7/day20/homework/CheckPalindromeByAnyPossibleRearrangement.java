//Q2. Check Palindrome!
//Problem Description
//
//Given a string A consisting of lowercase characters.
//
//Check if characters of the given string can be rearranged to form a palindrome.
//
//Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
//
//
//
//Problem Constraints
//
//1 <= |A| <= 105
//
//A consists only of lower-case characters.
//
//
//
//Input Format
//
//First argument is an string A.
//
//
//
//Output Format
//
//Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
//
//
//
//Example Input
//
//Input 1:
//
// A = "abcde"
//Input 2:
//
// A = "abbaee"
//
//
//Example Output
//
//Output 1:
//
// 0
//Output 2:
//
// 1
//
//
//Example Explanation
//
//Explanation 1:
//
// No possible rearrangement to make the string palindrome.
//Explanation 2:
//
// Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.

package day20.homework;

import java.util.HashMap;
import java.util.Map;

public class CheckPalindromeByAnyPossibleRearrangement {
	public static int solve(String A) {
		boolean isOddFreqCount = false;

		Map<Character, Integer> freqMap = new HashMap<>();

		for (Character c : A.toCharArray()) {
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
		}

		for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			if ((entry.getValue() & 1) == 1) {
				if (!isOddFreqCount) {
					isOddFreqCount = true;
				} else {
					return 0;
				}
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		System.out.println("abcde is not a palindrome : " + solve("abcde"));
		System.out.println("abbaee is a palindrome : " + solve("abbaee"));
	}
}

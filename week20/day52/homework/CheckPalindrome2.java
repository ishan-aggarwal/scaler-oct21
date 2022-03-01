package day52.homework;

import java.util.HashMap;
import java.util.Map;

//Q3. Check Palindrome - II

//Problem Description
//Given a string A consisting of lowercase characters.
//
//Check if characters of the given string can be rearranged to form a palindrome.
//
//Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
//
//
//
//Problem Constraints
//1 <= |A| <= 105
//
//A consists only of lower-case characters.
//
//
//
//Input Format
//First argument is an string A.
//
//
//
//Output Format
//Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
//
//
//
//Example Input
//Input 1:
//
// A = "abcde"
//Input 2:
//
// A = "abbaee"
//
//
//Example Output
//Output 1:
//
// 0
//Output 2:
//
// 1
//
//
//Example Explanation
//Explanation 1:
//
// No possible rearrangement to make the string palindrome.
//Explanation 2:
//
// Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.

public class CheckPalindrome2 {

	public static int solve(String A) {
		// TC - O(N)
		// SC - O(N)
		// Idea is to iterate over the string and prepare a frequency map for each of
		// the character in the string
		// in case there are more than one character with odd frequency count
		// return 0 as it is not possible to rearrange the array in to palindrome
		// otherwise return 1

		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		// O(N) operation
		// where N is the length of the string
		for (Character c : A.toCharArray()) {
			charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
		}

		int countOdds = 0;

		// check for odd frequency count for all the keys in the hashmap
		for (Character c : charFrequencyMap.keySet()) {
			if ((charFrequencyMap.get(c) & 1) == 1) {
				countOdds++;
			}
		}

		if (countOdds > 1) {
			return 0;
		}

		return 1;
	}

	public static void main(String[] args) {
		String A = "abbaee";
		System.out.println(solve(A));

		String A1 = "abcde";
		System.out.println(solve(A1));
	}
}

package leetcode.april.challenge;

//680. Valid Palindrome II
//Easy

public class Day2_ValidPalindromeII {
	public boolean validPalindrome(String s) {

		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			// Found a mismatched pair - try both deletions at ith pointer and jth pointer
			// in case another mis match found in calling function simply return false
			// as only one deletion was allowed
			if (s.charAt(i) != s.charAt(j)) {
				return (checkPalindrome(s, i, j - 1) || checkPalindrome(s, i + 1, j));
			}

			i++;
			j--;
		}
		return true;
	}

	private boolean checkPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}
		return true;
	}
}
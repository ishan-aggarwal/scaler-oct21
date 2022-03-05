package leetcode.march;

// https://leetcode.com/problems/is-subsequence/
// 392. Is Subsequence
// Easy

// Good approach
class CheckSubsequence_Day2 {
	public static boolean isSubsequence(String s, String t) {

		// base case
		if (s.length() == 0) {
			return true;
		}

		// index pointer for string s
		int sIdx = 0;

		// index pointer for string t
		// iterate over the string t and start matching the character with s pointer
		// if the character matches increase the s pointer
		for (int i = 0; i < t.length(); i++) {
			if (t.charAt(i) == s.charAt(sIdx)) {
				sIdx++;

				// if s pointer is equal to length of string
				// then return true
				if (sIdx == s.length()) {
					return true;
				}
			}
		}

		// in case the t string is exhausted return false
		return false;
	}

	public static void main(String[] args) {
		String s = "abc", t = "ahbgdc";
		System.out.println(isSubsequence(s, t));
	}
}
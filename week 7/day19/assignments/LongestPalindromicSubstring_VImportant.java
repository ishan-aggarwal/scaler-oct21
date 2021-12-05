//Q7. Longest Palindromic Substring
//Problem Description
//
//Given a string A of size N, find and return the longest palindromic substring in A.
//
//Substring of string A is A[i...j] where 0 <= i <= j < len(A)
//
//Palindrome string:
//A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
//
//Incase of conflict, return the substring which occurs first ( with the least starting index).
//
//
//
//Problem Constraints
//
//1 <= N <= 10000
//
//
//
//Input Format
//
//First and only argument is a string A.
//
//
//
//Output Format
//
//Return a string denoting the longest palindromic substring of string A.
//
//
//
//Example Input
//
//A = "aaaabaaa"
//
//
//Example Output
//
//"aaabaaa"
//
//
//Example Explanation
//
//We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".

package day19.assignments;

public class LongestPalindromicSubstring_VImportant {
	public static String longestPalindrome(String A) {

		String result = new String();
		String oddResult = new String();
		String evenResult = new String();

		for (int i = 0; i < A.length(); i++) {

			oddResult = expand(A, i, i);
			evenResult = expand(A, i, i + 1);

			if (oddResult.length() > evenResult.length() && oddResult.length() > result.length()) {
				result = oddResult;
			} else if (evenResult.length() > oddResult.length() && evenResult.length() > result.length()) {
				result = evenResult;
			}

		}

		return result;
	}

	public static String expand(String A, int start, int end) {

		int i = start;
		int j = end;

		while (i >= 0 && j < A.length() && A.charAt(i) == A.charAt(j)) {
			i--;
			j++;
		}

		return A.substring(i + 1, j);
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aaaabaaa"));
	}
}

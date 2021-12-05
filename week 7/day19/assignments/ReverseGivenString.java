//Q1. Reverse the String
//Problem Description
//
//Given a string A of size N.
//
//Return the string A after reversing the string word by word.
//
//NOTE:
//
//A sequence of non-space characters constitutes a word.
//Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
//If there are multiple spaces between words, reduce them to a single space in the reversed string.
//
//
//Problem Constraints
//
//1 <= N <= 3 * 105
//
//
//
//Input Format
//
//The only argument given is string A.
//
//
//
//Output Format
//
//Return the string A after reversing the string word by word.
//
//
//
//Example Input
//
//Input 1:
//    A = "the sky is blue"
//Input 2:
//    A = "this is ib"  
//
//
//Example Output
//
//Output 1:
//    "blue is sky the"
//Output 2:
//    "ib is this"    
//
//
//Example Explanation
//
//Explanation 1:
//    We reverse the string word by word so the string becomes "the sky is blue".
//Explanation 2:
//    We reverse the string word by word so the string becomes "this is ib".

package day19.assignments;

public class ReverseGivenString {
	public static String solve(String A) {

		A = A.trim();
		String reverseString = reverse(A, 0, A.length() - 1);
		StringBuilder result = new StringBuilder();

		int start = 0;
		for (int i = 0; i < reverseString.length(); i++) {
			if (reverseString.charAt(i) == ' ') {
				result.append(reverse(reverseString, start, i - 1));
				result.append(" ");
				start = i + 1;
			} else if (i == reverseString.length() - 1) {
				result.append(reverse(reverseString, start, i));
			}
		}

		return result.toString();

	}

	public static String reverse(String A, int start, int end) {

		StringBuilder sb = new StringBuilder();
		for (int j = end; j >= start; j--) {
			sb.append(A.charAt(j));
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		System.out.println(solve("this is ib"));
	}
}

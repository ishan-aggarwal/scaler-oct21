package day54.homework;

//Q1. Smallest Prefix String

//Problem Description
//Given 2 strings A and B of size N and M respectively consisting of lowercase alphabets, find the lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
//Note: The answer string has to start with a non-empty prefix of string A followed by a non-empty prefix of string B.
//
//
//
//Problem Constraints
//1 <= N, M <= 100000
//
//
//
//Input Format
//The first argument is a string A of size N.
//The second argument is a string B of size M.
//
//
//
//Output Format
//Return lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
//
//
//
//Example Input
//Input 1:
//
// A = "abba"
// B = "cdd"
//Input 2:
//
// A = "acd"
// B = "bay"
//
//
//Example Output
//Output 1:
//
// "abbac"
//Output 2:
//
// "ab"
//
//
//Example Explanation
//Explanation 1:
//
// We can concatenate prefix of A i.e "abba" and prefix of B i.e "c".
// The lexicographically smallest string will be "abbac".
//Explanation 2:
//
// We can concatenate prefix of A i.e "a" and prefix of B i.e "b".
// The lexicographically smallest string will be "ab".

public class SmallestPrefixString {

	// TC - O(N)
	// SC - O(1)
	public static String smallestPrefix(String A, String B) {

//		StringBuilder sb = new StringBuilder();
//		int aIdx = 0;
//		sb.append(A.charAt(aIdx++));
//
//		while (aIdx < A.length()) {
//			if (A.charAt(aIdx) >= B.charAt(0)) {
//				sb.append(B.charAt(0));
//				break;
//			} else {
//				sb.append(A.charAt(aIdx));
//				aIdx++;
//			}
//		}
//
//		if (aIdx == A.length()) {
//			sb.append(B.charAt(0));
//		}
//
//		return sb.toString();

		StringBuilder ans = new StringBuilder();
		int idxA = 0;
		ans.append(A.charAt(idxA++));
		while (idxA < A.length() && A.charAt(idxA) < B.charAt(0)) {
			ans.append(A.charAt(idxA));
			idxA++;
		}
		ans.append(B.charAt(0));
		return ans.toString();

	}

	public static void main(String[] args) {
		String A = "a";
		String B = "a";
		System.out.println(smallestPrefix(A, B));
	}
}

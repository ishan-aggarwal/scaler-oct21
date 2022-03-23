package day54.homework;

//Q4. Count A
//Problem Description
//You are given a string A. Find the number of substrings that start and end with 'a'.
//
//
//
//Problem Constraints
//1 <= |A| <= 105
//
//The string will have only lowercase English letters.
//
//
//
//Input Format
//Given the only argument is a String A.
//
//
//
//Output Format
//Return number of substrings that start and end with 'a'.
//
//
//
//Example Input
//Input 1:
//
// A = "aab"
//Input 2:
//
// A = "bcbc"
//
//
//Example Output
//Output 1:
//
// 3
//Output 2:
//
// 0
//
//
//Example Explanation
//Explanation 1:
//
// Substrings that start and end with 'a' are:
//    1. "a"
//    2. "aa"
//    3. "a"
//Explanation 2:
//
// There are no substrings that start and end with 'a'.

public class CountASubstrings {
	public static int solve(String A) {

		// since we know the total number of sub-arrays of given array of length N are
		// {N * (N+1) / 2}
		// then using the same formula
		int aCount = 0;
		for (char c : A.toCharArray()) {
			if (c == 'a')
				aCount++;
		}
		return (aCount * (aCount + 1) / 2);
	}

	public static void main(String[] args) {
		System.out.println(solve("aaba"));
	}
}

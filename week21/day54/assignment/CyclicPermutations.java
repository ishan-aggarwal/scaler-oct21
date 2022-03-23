package day54.assignment;

//Q1. Cyclic Permutations

//Problem Description
//
//Given two binary strings A and B, count how many cyclic permutations of B when taken XOR with A give 0.
//
//NOTE: If there is a string, S0, S1, ... Sn-1 , then it's cyclic permutation is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.
//
//
//
//Problem Constraints
//
//1 ≤ length(A) = length(B) ≤ 105
//
//
//
//Input Format
//
//First argument is a string A.
//Second argument is a string B.
//
//
//
//Output Format
//
//Return an integer denoting the required answer.
//
//
//
//Example Input
//
//Input 1:
//
// A = "1001"
// B = "0011"
//Input 2:
//
// A = "111"
// B = "111"
//
//
//Example Output
//
//Output 1:
//
// 1
//Output 2:
//
// 3
//
//
//Example Explanation
//
//Explanation 1:
//
// 4 cyclic permutations of B exists: "0011", "0110", "1100", "1001".  
// There is only one cyclic permutation of B i.e. "1001" which has 0 xor with A.
//Explanation 2:
//
// All cyclic permutations of B are same as A and give 0 when taken xor with A. So, the ans is 3.

public class CyclicPermutations {
	public static int solve(String A, String B) {
		StringBuilder builder = new StringBuilder();
		builder.append(A);
		builder.append("|");
		builder.append(B);
		builder.append(B.substring(0, B.length() - 1));
		int[] lps = generateLPS(builder.toString());
		int count = 0;
		for (int i = 0; i < lps.length; i++) {
			if (lps[i] == A.length()) {
				count++;
			}
		}
		return count;
	}

	private static int[] generateLPS(String A) {
		int[] lps = new int[A.length()];
		int i = 1, j = 0;
		while (i < A.length()) {
			if (A.charAt(i) == A.charAt(j)) {
				lps[i++] = ++j;
			} else {
				if (j == 0) {
					lps[i++] = 0;
				} else {
					j = lps[j - 1];
				}
			}
		}
		return lps;
	}

	public static void main(String[] args) {
		String A = "1001";
		String B = "0011";
		System.out.println(solve(A, B));
	}
}

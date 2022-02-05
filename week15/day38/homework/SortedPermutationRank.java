package day38.homework;

//Q1. Sorted Permutation Rank

//Problem Description
//
//Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
//Assume that no characters are repeated.
//
//Note: The answer might not fit in an integer, so return your answer % 1000003
//
//
//
//Problem Constraints
//
//1 <= |A| <= 1000
//
//
//
//Input Format
//
//First argument is a string A.
//
//
//
//Output Format
//
//Return an integer denoting the rank of the given string.
//
//
//
//Example Input
//
//Input 1:
//
//A = "acb"
//Input 2:
//
//A = "a"
//
//
//Example Output
//
//Output 1:
//
//2
//Output 2:
//
//1
//
//
//Example Explanation
//
//Explanation 1:
//
//Given A = "acb".
//The order permutations with letters 'a', 'c', and 'b' : 
//abc
//acb
//bac
//bca
//cab
//cba
//So, the rank of A is 2.
//Explanation 2:
//
//Given A = "a".
//Rank is clearly 1.

public class SortedPermutationRank {
	public static int findRank(String A) {
		int length = A.length();
		long modulo = 1000003L;
		long answer = 1;
		long[] pFactorial = new long[1000];
		pFactorial[0] = 1;
		for (int i = 1; i < pFactorial.length; i++) {
			pFactorial[i] = (pFactorial[i - 1] * i) % modulo;
		}

		for (int i = 0; i < length; i++) {
			int count = 0;
			for (int j = i + 1; j < length; j++) {
				if (A.charAt(i) > A.charAt(j)) {
					count++;
				}
			}
			answer = (answer + count * pFactorial[length - 1 - i]) % modulo;
		}
		return (int) (answer % modulo);
	}

	public static void main(String[] args) {
		System.out.println(findRank("A"));
	}
}

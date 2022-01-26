package day35.assignment;

//Q5. Pair Sum divisible by M

//Problem Description
//
//Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
//
//Since the answer may be large, return the answer modulo (109 + 7).
//
//
//
//Problem Constraints
//
//1 <= length of the array <= 100000
//1 <= A[i] <= 109
//1 <= B <= 106
//
//
//
//Input Format
//
//The first argument given is the integer array A.
//The second argument given is the integer B.
//
//
//
//Output Format
//
//Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).
//
//
//
//Example Input
//
//Input 1:
//
// A = [1, 2, 3, 4, 5]
// B = 2
//Input 2:
//
// A = [5, 17, 100, 11]
// B = 28
//
//
//Example Output
//
//Output 1:
//
// 4
//Output 2:
//
// 1
//
//
//Example Explanation
//
//Explanation 1:
//
// All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5). 
// So total 4 pairs.

public class PairSumDivisibleByM {
	public static int solve(int[] A, int B) {

		int[] freq = new int[B];
		long answer = 0;
		int modulo = 1000000007;

		for (int x : A) {
			freq[x % B]++;
		}

		answer = answer + (1l * freq[0] * (freq[0] - 1)) / 2;
		answer %= modulo;

		for (int i = 1; i <= B / 2; i++) {
			int other = B - i;
			if (i == other) {
				answer = answer + (1l * freq[i] * (freq[i] - 1)) / 2;
			} else {
				answer = answer + (1l * freq[i] * freq[B - i]);
			}
			answer %= modulo;
		}

		return (int) answer;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 , 6};
		int B = 2;
		System.out.println(solve(A, B));
	}
}

package day40.homework;

//Q3. Different Bits Sum Pairwise

//Problem Description
//
//We define f(X, Y) as number of different corresponding bits in binary representation of X and Y.
//For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.
//
//You are given an array of N positive integers, A1, A2 ,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.
//
//
//
//Problem Constraints
//
//1 <= N <= 105
//
//1 <= A[i] <= 231 - 1
//
//
//
//Input Format
//
//First and only argument of input contains a single integer array A.
//
//
//
//Output Format
//
//Return a single integer denoting the sum.
//
//
//
//Example Input
//
//Input 1:
//
// A = [1, 3, 5]
//Input 2:
//
// A = [2, 3]
//
//
//Example Output
//
//Ouptut 1:
//
// 8
//Output 2:
//
// 2
//
//
//Example Explanation
//
//Explanation 1:
//
// f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5) 
// = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8
//Explanation 2:
//
// f(2, 2) + f(2, 3) + f(3, 2) + f(3, 3) = 0 + 1 + 1 + 0 = 2
//
//
//See Expected Output
//Your input
//4 1 2 3 5
//Output
//20

public class DifferentBitsSumPairwise {
	public static int cntBits(int[] A) {

		int n = A.length;
		int modulo = 1000000007;
		long answer = 0L;

		for (int i = 0; i < 32; i++) {
			int mask = (1 << i);
			int countSetBits = 0;
			int countUnsetBits = 0;
			for (int j = 0; j < n; j++) {
				if (checkBit(A[j], mask)) {
					countSetBits++;
				}
			}
			countUnsetBits = n - countSetBits;
			answer += 1l * 2 * countSetBits * countUnsetBits;
			answer %= modulo;
		}

		return (int) answer;
	}

	public static boolean checkBit(int num, int mask) {
		return (num & (mask)) != 0 ? true : false;
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 5 };
		System.out.println(cntBits(A));
	}

}

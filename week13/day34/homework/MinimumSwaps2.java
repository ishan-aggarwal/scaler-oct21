package day34.homework;

//Q3. Minimum Swaps 2

//Problem Description
//
//Given an array of integers A of size N that is a permutation of [0, 1, 2, �, (N-1)]. It is allowed to swap any two elements (not necessarily consecutive).
//
//Find the minimum number of swaps required to sort the array in ascending order.
//
//
//
//Problem Constraints
//
//1 <= N <= 100000
//0 <= A[i] < N
//
//
//
//Input Format
//
//The only argument given is the integer array A.
//
//
//
//Output Format
//
//Return the minimum number of swaps.
//
//
//
//Example Input
//
//Input 1:
//
//A = [1, 2, 3, 4, 0]
//Input 2:
//
//A = [2, 0, 1, 3]
//
//
//Example Output
//
//Output 1:
//
//4
//Output 2:
//
//2
//
//
//Example Explanation
//
//Explanation 1:
//
// If you swap (1, 2) -> (2, 3) -> (4, 0) -> (3, 0). You will get a sorted array.
// You cannot sort it with lesser swaps.
//Explanation 2:
//
// You cannot sort it with lesser than 2 swaps.

public class MinimumSwaps2 {
	public static int solve(int[] A) {

		int n = A.length;
		int minSwaps = 0;
		for (int idx = 0; idx < n; idx++) {
			if (idx == A[idx]) {
				continue;
			}
			int index = A[idx];
			swap(A, idx, index);
			idx--;
			minSwaps++;
		}
		return minSwaps;
	}

	private static void swap(int[] A, int i, int index) {
		int temp = A[i];
		A[i] = A[index];
		A[index] = temp;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 0 };
		System.out.println(solve(A));

		int[] B = { 2, 0, 1, 3 };
		System.out.println(solve(B));

		int[] C = { 0, 1, 2 };
		System.out.println(solve(C));

		int[] D = { 3, 0, 1, 2 };
		System.out.println(solve(D));
	}
}

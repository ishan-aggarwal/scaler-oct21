package day44.assignment;

//Q3. Array with consecutive elements
//Problem Description
//
//Given an array of positive integers A, check and return whether the array elements are consecutive or not.
//NOTE: Try this with O(1) extra space.
//
//
//
//Problem Constraints
//
//1 <= length of the array <= 100000
//1 <= A[i] <= 10^9
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
//Return 1 if the array elements are consecutive else return 0.
//
//
//
//Example Input
//
//Input 1:
//
// A = [3, 2, 1, 4, 5]
//Input 2:
//
// A = [1, 3, 2, 5]
//
//
//Example Output
//
//Output 1:
//
// 1
//Output 2:
//
// 0
//
//
//Example Explanation
//
//Explanation 1:
//
// As you can see all the elements are consecutive, so we return 1.
//Explanation 2:
//
// Element 4 is missing, so we return 0.

public class ArrayWithConsecutiveElements {
	public static int solve(int[] A) {
		int minElement = findMin(A);
		int xor = 0;
		for (int x : A) {
			xor ^= minElement ^ x;
			minElement++;
		}

		if (xor == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	private static int findMin(int[] A) {
		int min = Integer.MAX_VALUE;
		for (int x : A) {
			min = Math.min(min, x);
		}
		return min;
	}

	public static void main(String[] args) {
		int[] A = { 3, 2, 1, 4, 5 };
		int[] B = { 11, 9, 10 };
		int[] C = { 1, 3, 2, 5 };

		int[] D = { -1, -3, -2, -4 };
		int[] E = { -1, 3, 0, 2, 1 };
		int[] F = { -1, 3, 0, 2 };

		System.out.println(solve(A));
		System.out.println(solve(B));
		System.out.println(solve(C));
		System.out.println(solve(D));
		System.out.println(solve(E));
		System.out.println(solve(F));

	}
}

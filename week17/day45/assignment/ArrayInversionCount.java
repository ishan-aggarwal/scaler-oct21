package day45.assignment;

//Q1. Inversion count in an array

//Problem Description
//Given an array of integers A. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
//
//
//
//Problem Constraints
//1 <= length of the array <= 100000
//
//1 <= A[i] <= 10^9
//
//
//
//Input Format
//The only argument given is the integer array A.
//
//
//
//Output Format
//Return the number of inversions of A modulo (109 + 7).
//
//
//
//Example Input
//Input 1:
//
//A = [3, 2, 1]
//Input 2:
//
//A = [1, 2, 3]
//
//
//Example Output
//Output 1:
//
//3
//Output 2:
//
//0
//
//
//Example Explanation
//Explanation 1:
//
// All pairs are inversions.
//Explanation 2:
//
// No inversions.

public class ArrayInversionCount {

	private static int merge(int[] A, int l, int y, int r) {

		int count = 0;
		int a = l, b = y, c = 0;
		int[] temp = new int[r - l + 1];
		while (a < y && b <= r) {
			if (A[a] <= A[b]) {
				temp[c++] = A[a++];
			} else {
				temp[c++] = A[b++];
				count += y - a;
			}
		}

		while (a < y) {
			temp[c++] = A[a++];
		}

		while (b <= r) {
			temp[c++] = A[b++];
		}

		for (int i = l; i <= r; ++i) {
			A[i] = temp[i - l];
		}

		return count;
	}

	private static int sort(int[] A, int l, int r) {
		if (l == r) {
			return 0;
		}
		int mid = (l + r) / 2;
		int leftCount = sort(A, l, mid);
		int rightCount = sort(A, mid + 1, r);
		int count = merge(A, l, mid + 1, r);
		return leftCount + rightCount + count;
	}

	public static int solve(int[] A) {
		int answer = sort(A, 0, A.length - 1);
		return answer;
	}

	public static void main(String[] args) {
		int[] A = { 3, 2, 1 };
		System.out.println(solve(A));

		for (int x : A) {
			System.out.print(x + " ");
		}
		System.out.println();
		int[] B = { 10, 3, 8, 15, 6, 12, 2, 18, 7, 1 };
		System.out.println(solve(B));

		for (int x : B) {
			System.out.print(x + " ");
		}
		System.out.println();

		int[] C = { 8, 1, 3, 6, 11, 2, 4, 9, 7, 6 };
		System.out.println(solve(C));
		for (int x : C) {
			System.out.print(x + " ");
		}

	}
}

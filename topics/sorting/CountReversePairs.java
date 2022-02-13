package day45.homework;

import javax.naming.ldap.Rdn;

//Q2. Reverse pairs

//Problem Description
//
//Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
//Return the number of important reverse pairs in the given array A.
//
//
//
//Problem Constraints
//
//1 <= length of the array <= 105
//
//-2 * 109 <= A[i] <= 2 * 109
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
//Return the number of important reverse pairs in the given array A.
//
//
//
//Example Input
//
//Input 1:
//
// A = [1, 3, 2, 3, 1]
//Input 2:
//
// A = [4, 1, 2]
//
//
//Example Output
//
//Output 1:
//
// 2
//Output 2:
//
// 1
//
//
//Example Explanation
//
//Explanation 1:
//
// There are two pairs which are important reverse i.e (3, 1) and (3, 1).
//Explanation 2:
//
// There is only one pair i.e (4, 1).

public class CountReversePairs {
	public static int solve(int[] A) {
		return mergeSort(A, 0, A.length - 1);
	}

	private static int mergeSort(int[] A, int l, int r) {
		if (l == r) {
			return 0;
		}
		int mid = l + (r - l) / 2;
		int lCount = mergeSort(A, l, mid);
		int rCount = mergeSort(A, mid + 1, r);
		int mCount = mergeReversePairs(A, l, mid + 1, r);
		return lCount + rCount + mCount;
	}

	private static int mergeReversePairs(int[] A, int l, int y, int r) {
		int count = 0;
		for (int i = l, j = y; i < y; ++i) {
			while (j <= r && A[i] > (1l * 2 * A[j])) {
				j++;
			}
			count += (j - y);
		}

		int[] temp = new int[r - l + 1];
		int a = l, b = y, c = 0;
		while (a < y && b <= r) {
			if (A[a] < A[b]) {
				temp[c++] = A[a++];
			} else {
				temp[c++] = A[b++];
			}
		}

		while (a < y) {
			temp[c++] = A[a++];
		}

		while (b <= r) {
			temp[c++] = A[b++];
		}

		for (int idx = l; idx <= r; idx++) {
			A[idx] = temp[idx - l];
		}
		return count;
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 2, 3, 1 };
		System.out.println(solve(A));

		int[] b = { 4, 1, 1, 2 };
		System.out.println(solve(b));
	}
}

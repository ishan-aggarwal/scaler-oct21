package day44.assignment;

// Given an array of size N.
// Given that the subarray from l, (y-1) and subarray from y,r are sorted
// 0 <= l <= y <= r < N
// Sort the subarray from l to r

public class MergeSortArraysWithSortedSubParts {

	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public static void mergeSortedSubArrays(final int[] A, int l, int y, int r) {
		int size = r - l + 1;
		int[] c = new int[size];
		int ptr1 = l, ptr2 = y, idx = 0;

		while (ptr1 < y && ptr2 <= r) {
			if (A[ptr1] < A[ptr2]) {
				c[idx++] = A[ptr1++];
			} else {
				c[idx++] = A[ptr2++];
			}
		}

		while (ptr1 < y) {
			c[idx++] = A[ptr1++];
		}

		while (ptr2 < y) {
			c[idx++] = A[ptr2++];
		}

		for (int i = l; i <= r; i++) {
			A[i] = c[i - l];
		}
	}

	// TC - O(N) (r - l + 1)
	// SC - O(N) (r - l + 1)
	public static void main(String[] args) {
		int[] A = { 8, 1, 3, 6, 11, 2, 4, 9, 7, 6 };
		int l = 2, y = 5, r = 7;
		mergeSortedSubArrays(A, l, y, r);
		for (int x : A) {
			System.out.print(x + " ");
		}
	}
}

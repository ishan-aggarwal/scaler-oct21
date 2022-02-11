package day44.assignment;

// Given an array of size N.
// Sort the array in less than O(N^2) TC
public class MergeSort_NotComplete {

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

		for (int i = 0; i < r - l + 1; i++) {
			A[i + l] = c[i];
		}
	}

	public static void mergeSort(final int[] A, int l, int r) {
		if (l >= r) {
			return;
		}
		int mid = l + (r - l) / 2;
		mergeSort(A, l, mid);
		mergeSort(A, mid + 1, r);
		mergeSortedSubArrays(A, l, mid + 1, r);
	}

	// TC - O(N)
	// SC - O(N)
	public static void main(String[] args) {
		int[] A = { 8, 1, 3, 6, 11, 2, 4, 9, 7, 6 };
		int n = A.length;
		mergeSort(A, 0, n - 1);
		for (int x : A) {
			System.out.print(x + " ");
		}
	}
}

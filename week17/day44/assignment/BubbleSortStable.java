package day44.assignment;

// Given an array of N elements, swapping of non-consecutive indices is not allowed.
// Sort the array in ascending order.

public class BubbleSortStable {

	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public static void selectionSortStable(final int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = 0; j < A.length - 1 - i; j++) {
				if (A[j] > A[j + 1]) {
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
			}
		}
	}

	// This algorithm is called as bubble sort, TC - // O(N^2)
	// here only the consecutive elements are swapped and after each iteration the
	// largest element settles at the end
	// SC - O(1) [In place sorting algorithm]
	// stable sort
	public static void main(String[] args) {
		int[] A = { 4, 6, 2, 4, 10, 1 };
		selectionSortStable(A);

		for (int x : A) {
			System.out.print(x + " ");
		}
	}
}

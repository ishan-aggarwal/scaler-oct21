package day44.assignment;

public class SelectionSortUnstable {

	private static void swap(final int[] A, int one, int other) {
		int temp = A[one];
		A[one] = A[other];
		A[other] = temp;
	}

	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public static void selectionSort(final int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			int min = A[i], minIndex = i;
			for (int j = i; j < A.length; j++) {
				if (A[j] < min) {
					min = A[j];
					minIndex = j;
				}
			}
			swap(A, i, minIndex);
		}
	}

	// This algorithm is called as selection sort, best part is there are only N-1
	// swaps which is very good
	// O(N^2)
	// SC - O(1) [In place sorting algorithm]
	// Not stable algorithm
	public static void main(String[] args) {
		int[] A = { 2, 1, 4, 3, 2, -1, 10, 15, 0 };
		selectionSort(A);

		for (int x : A) {
			System.out.print(x + " ");
		}
	}
}

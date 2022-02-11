package day44.assignment;

public class SelectionSortStable {

	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public static void selectionSortStable(final int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			int min = A[i], minIndex = i;
			for (int j = i; j < A.length; j++) {
				if (A[j] < min) {
					min = A[j];
					minIndex = j;
				}
			}

			// shift elements from i to minIndex one position right
			// and then put min at ith location
			int pos = minIndex;
			while (pos > i) {
				A[pos] = A[pos - 1];
				pos--;
			}
			A[i] = min;
		}
	}

	// This algorithm is called as selection sort, TC - // O(N^2)
	// here instead of swapping we are shifting the elements to make it stable sort
	// SC - O(1) [In place sorting algorithm]
	public static void main(String[] args) {
		int[] A = { 4, 6, 2, 4, 10, 1 };
		selectionSortStable(A);

		for (int x : A) {
			System.out.print(x + " ");
		}
	}
}

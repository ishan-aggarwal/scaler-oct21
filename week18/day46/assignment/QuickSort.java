package day46.assignment;

//Q2. QuickSort

//Problem Description
//
//Given an integer array A, sort the array using QuickSort.
//
//
//
//Problem Constraints
//
//1 <= |A| <= 105
//
//1 <= A[i] <= 109
//
//
//
//Input Format
//
//First argument is an integer array A.
//
//
//
//Output Format
//
//Return the sorted array.
//
//
//
//Example Input
//
//Input 1:
//
// A = [1, 4, 10, 2, 1, 5]
//Input 2:
//
// A = [3, 7, 1]
//
//
//Example Output
//
//Output 1:
//
// [1, 1, 2, 4, 5, 10]
//Output 2:
//
// [1, 3, 7]
//
//
//Example Explanation
//
//Explanation 1:
//
// Return the sorted array.

public class QuickSort {
	public int[] solve(int[] A) {
		quickSort(A, 0, A.length - 1);
		return A;
	}

	private void quickSort(int[] A, int left, int right) {
		if (left >= right) {
			return;
		}
		int index = rearrange(A, left, right);
		quickSort(A, left, index - 1);
		quickSort(A, index + 1, right);
	}

	private int rearrange(int[] A, int left, int right) {

		int p1 = left + 1, p2 = right;

		while (p1 <= p2) {
			if (A[p1] <= A[left]) {
				p1++;
			} else if (A[p2] > A[left]) {
				p2--;
			} else {
				int temp = A[p1];
				A[p1] = A[p2];
				A[p2] = temp;
				p1++;
				p2--;
			}
		}

		// swap element at left with element at p2
		int temp = A[left];
		A[left] = A[p2];
		A[p2] = temp;

		// return p2
		return p2;
	}
}

package day47.assignment;

//Q4. Find local minima (Google)

//Problem Description
//
// Given an array of integers A, with N distinct elements (Imp)
// Find any one local minima inside the array
// No smaller than all available neighbors

// if A[i] is local minima
// then A[i-1] > A[i] && A[i+1] > A[i]

// TC - O(Log N)

// Binary search - 
// 1.) search + sorted data
// 2.) search + TC (log N) 
// 3.) search/find + TC - N LogN or K logN or N logk

public class LocalMinima {
	// similarly we can prepare logic for local minima as well.
	public static int localMinima(int[] A) {
		int n = A.length;
		if (n == 1) {
			return A[0];
		}
		// important step to handle the edge cases with ease
		if (A[0] < A[1]) {
			return A[0];
		}
		if (A[n - 1] < A[n - 2]) {
			return A[n - 1];
		}

		int l = 1, r = n - 2;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
				return A[mid];
			} else if (A[mid - 1] < A[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] A = { 12, 6, 1, 0, 9, 15, 18 };
		System.out.println(localMinima(A));
	}
}

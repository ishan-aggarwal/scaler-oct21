package day47.assignment;

//Q3. Find a peak element

//Problem Description
//
//Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.
//
//For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
//
//NOTE: Users are expected to solve this in O(log(N)) time.
//
//
//
//Problem Constraints
//
//1 <= |A| <= 100000
//
//1 <= A[i] <= 109
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
//Return the peak element.
//
//
//
//Example Input
//
//Input 1:
//
//A = [1, 2, 3, 4, 5]
//Input 2:
//
//A = [5, 17, 100, 11]
//
//
//Example Output
//
//Output 1:
//
// 5
//Output 2:
//
// 100
//
//
//Example Explanation
//
//Explanation 1:
//
// 5 is the peak.
//Explanation 2:
//
// 100 is the peak.

public class LocalMaxima {
	// similarly we can prepare logic for local minima as well.
	public static int solve(int[] A) {
		int n = A.length;
		if (n == 1) {
			return A[0];
		}
		// important step to handle the edge cases with ease
		if (A[0] > A[1]) {
			return A[0];
		}
		if (A[n - 1] > A[n - 2]) {
			return A[n - 1];
		}

		int l = 1, r = n - 2;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
				return A[mid];
			} else if (A[mid] < A[mid + 1]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] A = { 5, 17, 100, 11 };
		System.out.println(solve(A));
	}
}

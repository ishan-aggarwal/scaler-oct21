package day44.assignment;

//Q2. Kth Smallest Element

//Problem Description
//
//Find the Bth smallest element in given array A .
//
//NOTE: Users should try to solve it in <= B swaps.
//
//
//
//Problem Constraints
//
//1 <= |A| <= 100000
//
//1 <= B <= min(|A|, 500)
//
//1 <= A[i] <= 109
//
//
//
//Input Format
//
//First argument is vector A.
//
//Second argument is integer B.
//
//
//
//Output Format
//
//Return the Bth smallest element in given array.
//
//
//
//Example Input
//
//Input 1:
//
//A = [2, 1, 4, 3, 2]
//B = 3
//Input 2:
//
//A = [1, 2]
//B = 2
//
//
//Example Output
//
//Output 1:
//
// 2
//Output 2:
//
// 2
//
//
//Example Explanation
//
//Explanation 1:
//
// 3rd element after sorting is 2.
//Explanation 2:
//
// 2nd element after sorting is 2.

public class KthSmallestElement {

	private static void swap(final int[] A, int one, int other) {
		int temp = A[one];
		A[one] = A[other];
		A[other] = temp;
	}

	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public static int kthsmallest(final int[] A, int B) {
		for (int i = 0; i < B; i++) {
			int min = A[i], minIndex = i;
			for (int j = i; j < A.length; j++) {
				if (A[j] < min) {
					min = A[j];
					minIndex = j;
				}
			}
			swap(A, i, minIndex);
		}
		return A[B - 1];
	}

	// This algorithm is same as selection sort
	// here we are doing maximum B swaps TC - O(BN)
	// SC - O(1) [In place sorting algorithm]
	// Not stable algorithm
	public static void main(String[] args) {
		int[] A = { 2, 1, 4, 3, 2 };
		int B = 3;
		System.out.println(kthsmallest(A, B));
	}
}

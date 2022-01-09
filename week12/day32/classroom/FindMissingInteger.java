package day32.classwork;

//Q5. First Missing Integer

//Problem Description
//
//Given an unsorted integer array A of size N. Find the first missing positive integer.
//
//Note: Your algorithm should run in O(n) time and use constant space.
//
//
//
//Problem Constraints
//
//1 <= N <= 1000000
//
//-109 <= A[i] <= 109
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
//Return an integer denoting the first missing positive integer.
//
//
//
//Example Input
//
//Input 1:
//
//[1, 2, 0]
//Input 2:
//
//[3, 4, -1, 1]
//Input 3:
//
//[-8, -7, -6]
//
//
//Example Output
//
//Output 1:
//
//3
//Output 2:
//
//2
//Output 3:
//
//1
//
//
//Example Explanation
//
//Explanation 1:
//
//A = [1, 2, 0]
//First positive integer missing from the array is 3.

public class FindMissingInteger {
	public static int firstMissingPositive(int[] A) {

		int n = A.length;

		// make all the negative and zero elements as (n+1)
		// if the total size is n and there are elements with value (n+1) in it as well,
		// then that means we will have something missing
		// between the range 1 to N itself
		for (int i = 0; i < n; i++) {
			if (A[i] <= 0) {
				A[i] = n + 1;
			}
		}

		// if the element value at ith index is in the range of 1.N
		// then turn the corresponding index element as negative
		for (int i = 0; i < n; i++) {
			if (Math.abs(A[i]) <= n) {
				A[Math.abs(A[i]) - 1] = -1 * Math.abs(A[Math.abs(A[i]) - 1]);
			}
		}

		// return the first index position which is still positive
		// otherwise return (n+1)
		for (int i = 0; i < n; i++) {
			if (A[i] > 0) {
				return (i + 1);
			}
		}

		return (n + 1);
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 0 };
		System.out.println(firstMissingPositive(A));

		int[] B = { -8, -7, -6 };
		System.out.println(firstMissingPositive(B));
	}
}

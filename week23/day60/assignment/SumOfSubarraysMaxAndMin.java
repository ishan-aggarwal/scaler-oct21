package day60.assignment;

import java.util.Arrays;
import java.util.Stack;

//Q4. MAX and MIN

//Given an array of integers A.
//
//value of a array = max(array) - min(array).
//
//Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
//
//
//
//Problem Constraints
//1 <= |A| <= 100000
//
//1 <= A[i] <= 1000000
//
//
//
//Input Format
//The first and only argument given is the integer array A.
//
//
//
//Output Format
//Return the sum of values of all possible subarrays of A modulo 109+7.
//
//
//
//Example Input
//Input 1:
//
// A = [1]
//Input 2:
//
// A = [4, 7, 3, 8]
//
//
//Example Output
//Output 1:
//
// 0
//Output 2:
//
// 26
//
//
//Example Explanation
//Explanation 1:
//
//Only 1 subarray exists. Its value is 0.
//Explanation 2:
//
//value ( [4] ) = 4 - 4 = 0
//value ( [7] ) = 7 - 7 = 0
//value ( [3] ) = 3 - 3 = 0
//value ( [8] ) = 8 - 8 = 0
//value ( [4, 7] ) = 7 - 4 = 3
//value ( [7, 3] ) = 7 - 3 = 4
//value ( [3, 8] ) = 8 - 3 = 5
//value ( [4, 7, 3] ) = 7 - 3 = 4
//value ( [7, 3, 8] ) = 8 - 3 = 5
//value ( [4, 7, 3, 8] ) = 8 - 3 = 5
//sum of values % 10^9+7 = 26

public class SumOfSubarraysMaxAndMin {

	// Brute force approach is to iterate over all sub-arrays
	// O(N^2)
	// for each sub-array find the min and max
	// O(N)
	// finally do sum after finding max and min
	// ans += (max - min)
	// total complexity - O(N^3)

	// so we should think better
	// about contribution technique
	// For every element
	// find count of sub-array in which it is max
	// find count of sub-array in which it is min

	public static int solve(int[] A) {
		long answer = 0;
		int modulo = 10 ^ 9 + 7;

		int[] nsl = nsl(A);
		int[] ngl = ngl(A);
		int[] nsr = nsr(A);
		int[] ngr = ngr(A);

		for (int i = 0; i < A.length - 1; i++) {
			long maxTotal = (1l * A[i] * (ngr[i] - i) * (i - ngl[i])) % modulo;
			long minTotal = (1l * A[i] * (nsr[i] - i) * (i - nsl[i])) % modulo;
			answer = (answer + (maxTotal - minTotal) % modulo) % modulo;
		}

		return (int) answer;

	}

	// prepare nearest greater on the right
	public static int[] ngr(int[] A) {
		int[] ngr = new int[A.length];
		Stack<Integer> stack = new Stack<>();
		int idx = A.length - 1;
		for (int i = A.length - 1; i >= 0; --i) {
			while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				ngr[idx--] = A.length;
			} else {
				ngr[idx--] = stack.peek();
			}
			// as current element can be smaller for the elements coming on left
			stack.push(i);
		}
		// 1, -1, -1
		// 2, 5, 3
		System.out.println(Arrays.toString(ngr));
		return ngr;
	}

	// prepare nearest smallest on the right
	public static int[] nsr(int[] A) {
		int[] nsr = new int[A.length];
		Stack<Integer> stack = new Stack<>();
		int idx = A.length - 1;
		for (int i = A.length - 1; i >= 0; --i) {
			while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				nsr[idx--] = A.length;
			} else {
				nsr[idx--] = stack.peek();
			}
			// as current element can be smaller for the elements coming on left
			stack.push(i);
		}
		// -1, 2, -1
		// 2, 5, 3
		System.out.println(Arrays.toString(nsr));
		return nsr;
	}

	// prepare nearest smallest on the left
	public static int[] nsl(int[] A) {
		int[] nsl = new int[A.length];
		Stack<Integer> stack = new Stack<>();
		int idx = 0;
		for (int i = 0; i < A.length; ++i) {
			while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				nsl[idx++] = -1;
			} else {
				nsl[idx++] = stack.peek();
			}
			// as current element can be smaller for the elements coming on right
			stack.push(i);
		}
		// -1, 0, 0
		System.out.println(Arrays.toString(nsl));
		return nsl;
	}

	// prepare nearest greater on the left
	public static int[] ngl(int[] A) {
		int[] ngl = new int[A.length];
		Stack<Integer> stack = new Stack<>();
		int idx = 0;
		for (int i = 0; i < A.length; ++i) {
			while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				ngl[idx++] = -1;
			} else {
				ngl[idx++] = stack.peek();
			}
			// as current element can be greater for the elements coming on right
			// so push index for current element
			stack.push(i);
		}
		// -1, -1, 1
		System.out.println(Arrays.toString(ngl));
		return ngl;
	}

	public static void main(String[] args) {
		int[] A = { 2, 5, 3 };
		System.out.println(solve(A));
		int[] B = { 4, 7, 3, 8 };
		System.out.println(solve(B));
	}
}

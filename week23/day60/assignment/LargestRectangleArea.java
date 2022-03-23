package day60.assignment;

import java.util.Arrays;
import java.util.Stack;

//Q3. Largest Rectangle in Histogram

//Problem Description
//Given an array of integers A.
//
//A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
//
//Find the area of the largest rectangle formed by the histogram.
//
//
//
//Problem Constraints
//1 <= |A| <= 100000
//
//1 <= A[i] <= 1000000000
//
//
//
//Input Format
//The only argument given is the integer array A.
//
//
//
//Output Format
//Return the area of the largest rectangle in the histogram.
//
//
//
//Example Input
//Input 1:
//
// A = [2, 1, 5, 6, 2, 3]
//Input 2:
//
// A = [2]
//
//
//Example Output
//Output 1:
//
// 10
//Output 2:
//
// 2
//
//
//Example Explanation
//Explanation 1:
//
//The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
//Explanation 2:
//
//Largest rectangle has area 2.

public class LargestRectangleArea {
	public static int largestRectangleArea(int[] A) {
		if (A.length == 1) {
			return A[0];
		}

		long maxArea = Long.MIN_VALUE;
		int[] nsl = computeNearestSmallestLeft(A);
		int[] nsr = computeNearestSmallestRight(A);

		for (int i = 0; i < A.length; i++) {
			int height = A[i];
			int width = nsr[i] - nsl[i] - 1;
			maxArea = Math.max(maxArea, 1l * width * height);
		}
		return (int) maxArea;
	}

	private static int[] computeNearestSmallestRight(int[] A) {
		int[] nsr = new int[A.length];
		Stack<Integer> stack = new Stack<>();

		int idx = A.length - 1;
		for (int i = A.length - 1; i >= 0; i--) {

			while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				nsr[idx--] = A.length;
			} else {
				nsr[idx--] = stack.peek();
			}

			stack.push(i);
		}
//		System.out.println(Arrays.toString(nsr));
		return nsr;

	}

	private static int[] computeNearestSmallestLeft(int[] A) {
		int[] nsl = new int[A.length];
		Stack<Integer> stack = new Stack<>();

		int idx = 0;
		for (int i = 0; i < A.length; i++) {

			while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				nsl[idx++] = -1;
			} else {
				nsl[idx++] = stack.peek();
			}

			stack.push(i);
		}
//		System.out.println(Arrays.toString(nsl));
		return nsl;
	}

	public static void main(String[] args) {
		int[] A = { 2, 1, 5, 6, 2, 3 };
		// nsl -1 -1 1 2 1 4
		// nsr 1 -1 4 4 -1 -1
		System.out.println(largestRectangleArea(A));

		int[] A1 = { 1 };
		// nsl -1 -1 1 2 1 4
		// nsr 1 -1 4 4 -1 -1
		System.out.println(largestRectangleArea(A1));
	}
}

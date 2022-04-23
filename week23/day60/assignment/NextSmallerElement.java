package day60.assignment;

import java.util.Arrays;
import java.util.Stack;

// Q1. Given an array of positive integers.
// For every index i,
// find the nearest element on the left side of i
// which is smaller than A[i]

public class NextSmallerElement {

	// TC - O(N) -
	// TC is O(N) only reason being that all the elements are iterated once
	// and pushed into the stack once
	// and only once they are removed from the stack, if needed
	// so at max each element can be touched twice one while pushing and one during
	// pop out operation
	// SC - O(N) - for maintaining the elements in the stack
	// and for storing the result array and returning it back
	public static int[] nextSmallerElement(int[] A) {

		Stack<Integer> stack = new Stack<>();
		int[] res = new int[A.length];
		int idx = A.length - 1;

		// Brute force solution -> TC - O(N^2)
		// for (int i = 0; i < A.length; ++i) {
		// traverse from (i - 1) to 0
		// to find 1st element smaller then A[i]
		// }

		// start iterating over the input array
		for (int i = A.length - 1; i >= 0; --i) {

			// while stack holds elements greater than equal to current element
			// keep popping the element from the stack
			// even if it is equal to currently coming element
			// still remove the element from the stack
			// as it can not be the solution - we need to find the nearest smallest
			while (!stack.isEmpty() && stack.peek() >= A[i]) {
				stack.pop();
			}

			// if there is no smaller element on left side
			// means the stack space is empty
			// put -1
			if (stack.isEmpty()) {
				res[idx--] = -1;
			} else {
				// else use the top most element of the stack and put in the result array
				res[idx--] = stack.peek();
			}

			// insert the current element into the stack
			// as it might be solution for elements on right
			stack.push(A[i]);

		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 4, 2, 5, 10, 8, 2 };
		// 2, -1, 2, 8, 2 , -1
		int[] res = nextSmallerElement(A);
		System.out.println(Arrays.toString(res));
	}

}
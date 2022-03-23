package day60.assignment;

import java.util.Arrays;
import java.util.Stack;

// Q1. Given an array of positive integers.
// For every index i,
// find the nearest element on the left side of i
// which is smaller than A[i]

//Q2. Nearest Smaller Element
//Problem Description
//Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
//
//More formally,
//
//G[i] for an element A[i] = an element A[j] such that
//
//j is maximum possible AND
//
//j < i AND
//
//A[j] < A[i]
//
//Elements for which no smaller element exist, consider the next smaller element as -1.
//
//
//
//Problem Constraints
//1 <= |A| <= 100000
//
//-109 <= A[i] <= 109
//
//
//
//Input Format
//The only argument given is integer array A.
//
//
//
//Output Format
//Return the integar array G such that G[i] contains the nearest smaller number than A[i]. If no such element occurs G[i] should be -1.
//
//
//
//Example Input
//Input 1:
//
// A = [4, 5, 2, 10, 8]
//Input 2:
//
// A = [3, 2, 1]
//
//
//Example Output
//Output 1:
//
// [-1, 4, -1, 2, 2]
//Output 2:
//
// [-1, -1, -1]
//
//
//Example Explanation
//Explanation 1:
//
//index 1: No element less than 4 in left of 4, G[1] = -1
//index 2: A[1] is only element less than A[2], G[2] = A[1]
//index 3: No element less than 2 in left of 2, G[3] = -1
//index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
//index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
//Explanation 2:
//
//index 1: No element less than 3 in left of 3, G[1] = -1
//index 2: No element less than 2 in left of 2, G[2] = -1
//index 3: No element less than 1 in left of 1, G[3] = -1

public class PreviousSmallerElement {

	// TC - O(N) -
	// TC is O(N) only reason being that all the elements are iterated once
	// and pushed into the stack once
	// and only once they are removed from the stack, if needed
	// so at max each element can be touched twice one while pushing and one during
	// pop out operation
	// SC - O(N) - for maintaining the elements in the stack
	// and for storing the result array and returning it back
	public static int[] nearestSmallestElement(int[] A) {

		Stack<Integer> stack = new Stack<>();
		int[] res = new int[A.length];
		int idx = 0;

		// Brute force solution -> TC - O(N^2)
		// for (int i = 0; i < A.length; ++i) {
		// traverse from (i - 1) to 0
		// to find 1st element smaller then A[i]
		// }

		// start iterating over the input array
		for (int x : A) {

			// while stack holds elements greater than equal to current element
			// keep popping the element from the stack
			// even if it is equal to currently coming element
			// still remove the element from the stack
			// as it can not be the solution - we need to find the nearest smallest
			while (!stack.isEmpty() && stack.peek() >= x) {
				stack.pop();
			}

			// if there is no smaller element on left side
			// means the stack space is empty
			// put -1
			if (stack.isEmpty()) {
				res[idx++] = -1;
			} else {
				// else use the top most element of the stack and put in the result array
				res[idx++] = stack.peek();
			}

			// insert the current element into the stack
			// as it might be solution for elements on right
			stack.push(x);

		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 4, 2, 5, 10, 8, 2 };
		int[] res = nearestSmallestElement(A);
		System.out.println(Arrays.toString(res));
	}

}

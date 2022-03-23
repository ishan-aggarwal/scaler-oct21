package day59.homework;

import java.util.Arrays;
import java.util.Stack;

//Q4. Sort stack using another stack
//Problem Description
//Given a stack of integers A, sort it using another stack.
//
//Return the array of integers after sorting the stack using another stack.
//
//
//
//Problem Constraints
//1 <= |A| <= 5000
//
//0 <= A[i] <= 109
//
//
//
//Input Format
//The only argument is a stack given as an integer array A.
//
//
//
//Output Format
//Return the array of integers after sorting the stack using another stack.
//
//
//
//Example Input
//Input 1:
//
// A = [5, 4, 3, 2, 1]
//Input 2:
//
// A = [5, 17, 100, 11]
//
//
//Example Output
//Output 1:
//
// [1, 2, 3, 4, 5]
//Output 2:
//
// [5, 11, 17, 100]
//
//
//Example Explanation
//Explanation 1:
//
// Just sort the given numbers.
//Explanation 2:
//
// Just sort the given numbers.

public class SortStackUsingAnotherStack {

	private static Stack<Integer> stack = new Stack<>();
	private static Stack<Integer> otherStack = new Stack<>();

	public static int[] solve(int[] A) {

		int[] res = new int[A.length];

		for (int x : A) {
			if (stack.isEmpty()) {
				stack.push(x);
			} else {
				while (!stack.isEmpty() && x > stack.peek()) {
					otherStack.push(stack.pop());
				}
				stack.push(x);
				while (!otherStack.isEmpty()) {
					stack.push(otherStack.pop());
				}
			}
		}

		int idx = 0;
		while (!stack.isEmpty()) {
			res[idx++] = stack.pop();
		}

		return res;
	}

	public static void main(String[] args) {
		int[] A = { 7, 2, 11, 5, 1, 9 };
		System.out.println(Arrays.toString(solve(A)));
	}
}

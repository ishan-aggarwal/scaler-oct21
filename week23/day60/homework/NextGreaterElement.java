package day60.homework;

import java.util.Arrays;
import java.util.Stack;

//Q3. Next Greater

//Problem Description
//Given an array A, find the next greater element G[i] for every element A[i] in the array.
//The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.
//
//More formally:
//
//G[i] for an element A[i] = an element A[j] such that 
//    j is minimum possible AND 
//    j > i AND
//    A[j] > A[i]
//Elements for which no greater element exists, consider the next greater element as -1.
//
//
//
//Problem Constraints
//1 <= |A| <= 105
//
//1 <= A[i] <= 107
//
//
//
//Input Format
//The first and the only argument of input contains the integer array, A.
//
//
//
//Output Format
//Return an integer array representing the next greater element for each index in A.
//
//
//
//Example Input
//Input 1:
//
// A = [4, 5, 2, 10] 
//Input 2:
//
// A = [3, 2, 1] 
//
//
//Example Output
//Output 1:
//
// [5, 10, 10, -1] 
//Output 2:
//
// [-1, -1, -1] 
//
//
//Example Explanation
//Explanation 1:
//
//For 4, the next greater element towards its right is 5.
//For 5 and 2, the next greater element towards their right is 10.
//For 10, there is no next greater element towards its right.
//Explanation 2:
//
//As the array is in descending order, there is no next greater element for all the elements. 

public class NextGreaterElement {
	public static int[] nextGreater(int[] A) {
		int[] res = new int[A.length];
		Stack<Integer> stack = new Stack<>();
		int idx = A.length - 1;
		for (int i = A.length - 1; i >= 0; --i) {

			while (!stack.isEmpty() && stack.peek() <= A[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				res[idx--] = -1;
			} else {
				res[idx--] = stack.peek();
			}

			stack.push(A[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] A = { 4, 5, 2, 10 };
		int[] res = nextGreater(A);
		System.out.println(Arrays.toString(res));
	}
}

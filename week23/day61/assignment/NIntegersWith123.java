package day61.assignment;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//Q2. N integers containing only 1, 2 & 3
//Problem Description
//Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
//
//NOTE: All the A integers will fit in 32-bit integers.
//
//
//
//Problem Constraints
//1 <= A <= 29500
//
//
//
//Input Format
//The only argument given is integer A.
//
//
//
//Output Format
//Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.
//
//
//
//Example Input
//Input 1:
//
// A = 3
//Input 2:
//
// A = 7
//
//
//Example Output
//Output 1:
//
// [1, 2, 3]
//Output 2:
//
// [1, 2, 3, 11, 12, 13, 21]
//
//
//Example Explanation
//Explanation 1:
//
// Output denotes the first 3 integers that contains only digits 1, 2 and 3.
//Explanation 2:
//
// Output denotes the first 3 integers that contains only digits 1, 2 and 3.

public class NIntegersWith123 {

	// This approach is called BFS approach
	// TC and SC - O(N)
	public static int[] solve(int A) {
		int[] res = new int[A];
		int idx = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);

		while (idx < A && !queue.isEmpty()) {
			int head = queue.poll();
			res[idx++] = head;

			queue.add(head * 10 + 1);
			queue.add(head * 10 + 2);
			queue.add(head * 10 + 3);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] ans = solve(7);
		System.out.println(Arrays.toString(ans));
	}
}

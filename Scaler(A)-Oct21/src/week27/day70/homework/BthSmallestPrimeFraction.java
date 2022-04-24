package week27.day70.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Q3. B-th Smallest Prime Fraction

//Problem Description
//Given a sorted array of integers A which contains 1 and some number of primes.
//Then, for every p < q in the list, we consider the fraction p / q.
//
//What is the B-th smallest fraction considered?
//
//Return your answer as an array of integers, where answer[0] = p and answer[1] = q.
//
//
//
//Problem Constraints
//1 <= length(A) <= 2000
//1 <= A[i] <= 30000
//1 <= B <= length(A)*(length(A) - 1)/2
//
//
//
//Input Format
//The first argument of input contains the integer array, A.
//The second argument of input contains an integer B.
//
//
//
//Output Format
//Return an array of two integers, where answer[0] = p and answer[1] = q.
//
//
//
//Example Input
//Input 1:
//
// A = [1, 2, 3, 5]
// B = 3
//Input 2:
//
// A = [1, 7]
// B = 1
//
//
//Example Output
//Output 1:
//
// [2, 5]
//Output 2:
//
// [1, 7]
//
//
//Example Explanation
//Explanation 1:
//
// The fractions to be considered in sorted order are:
// [1/5, 1/3, 2/5, 1/2, 3/5, 2/3]
// The third fraction is 2/5.
//Explanation 2:
//
// The fractions to be considered in sorted order are:
// [1/7]
// The first fraction is 1/7.

public class BthSmallestPrimeFraction {

	// Java | TC : O(N + B*log N) | SC : O(N) | B-th Smallest Prime Fraction
	public static int[] solve(int[] A, int B) {
		PriorityQueue<Double> minHeap = new PriorityQueue<>();
		Map<Double, int[]> indexMap = new HashMap<>();
		int n = A.length;
		for (int i = 0; i < n - 1; i++) {
			double fraction = 1D * A[i] / A[n - 1];
			minHeap.add(fraction);
			indexMap.put(fraction, new int[] { i, n - 1 });
		}

		while (B != 1) {
			int[] temp = indexMap.remove(minHeap.poll());

			// since we already traversed the array from left to right...
			// now we want to do it from right to left as well to find the correct entry
			// for every p < q in the list
			if ((temp[1] - 1) > temp[0]) {
				double fraction = 1D * A[temp[0]] / A[temp[1] - 1];
				minHeap.add(fraction);
				indexMap.put(fraction, new int[] { temp[0], temp[1] - 1 });
			}
			B--;
		}

		int[] ans = indexMap.get(minHeap.peek());
		return new int[] { A[ans[0]], A[ans[1]] };
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 5 };
		int B = 3;
		System.out.println(Arrays.toString(solve(A, B)));
	}
}

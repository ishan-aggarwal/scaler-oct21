/**
 * Given an array of size N. Find the max subarray sum of length k.
 * 
 * Amazon and paytm
 * 
 * O(N) with constant space
 */

package day10.classroom;

import java.util.Arrays;
import java.util.List;

public class MaxSubarraySumWithGivenLength {

	public static void main(String[] args) {

		Integer A[] = { 3, 7, 1, 6, 8, -2, 9 };
		List<Integer> list = Arrays.asList(A);
		int res = solve(list, 3);
		System.out.println(res);
	}

	private static int solve(List<Integer> list, int k) {

		int size = list.size();
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;

		for (int i = 0; i < k; i++) {
			currentSum += list.get(i);
		}
		maxSum = currentSum;

		for (int i = 1; i <= size - k; i++) {
			currentSum += list.get(i + k - 1) - list.get(i - 1);
			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
		}
		return maxSum;
	}
}

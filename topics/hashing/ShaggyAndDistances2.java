package day52.assignment;

import java.util.HashMap;
import java.util.Map;

//Google

//Problem Description
// Given an array of size N, return the maximum distance between any two duplicate elements
// i, j where i != j and A[i] = A[j], return the maximum distance between any such pairs

public class ShaggyAndDistances2 {

	// TC - O(N) and SC - O(N)
	// Intuition is that we use a map to get O(1) access to the index of the
	// element.
	// For every element we need the index of the first occurrence of it to maximize
	// our result
	public static int solve(int[] A) {
		int ans = Integer.MIN_VALUE;
		Map<Integer, Integer> firstOccurenceIndexMap = new HashMap<>();

		// O(N) operation iteration over the array
		for (int i = 0; i < A.length; ++i) {
			// O(1) lookup operation for map
			if (firstOccurenceIndexMap.containsKey(A[i])) {
				ans = Math.max(ans, Math.abs(i - firstOccurenceIndexMap.get(A[i])));
			} else {
				// again O(1) operation to put an element
				firstOccurenceIndexMap.put(A[i], i);
			}

		}
		if (ans == Integer.MIN_VALUE) {
			return -1;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] A = { 7, 1, 3, 4, 1, 7 };
		System.out.println(solve(A));
		int[] A1 = { 1, 1 };
		System.out.println(solve(A1));
	}
}

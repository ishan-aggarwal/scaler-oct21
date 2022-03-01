package day52.assignment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Q3. Sub-array with 0 sum - Amazon, MS, Adobe

//Problem Description
//
//Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
//
//If the given array contains a sub-array with sum zero return 1 else return 0.
//
//
//
//Problem Constraints
//
//1 <= |A| <= 100000
//
//-10^9 <= A[i] <= 10^9
//
//
//
//Input Format
//
//The only argument given is the integer array A.
//
//
//
//Output Format
//
//Return whether the given array contains a subarray with a sum equal to 0.
//
//
//
//Example Input
//
//Input 1:
//
// A = [1, 2, 3, 4, 5]
//Input 2:
//
// A = [-1, 1]
//
//
//Example Output
//
//Output 1:
//
// 0
//Output 2:
//
// 1
//
//
//Example Explanation
//
//Explanation 1:
//
// No subarray has sum 0.
//Explanation 2:
//
// The array has sum 0.

public class SubarrayWithZeroSum {

	// Important point here is to check for overflow condition
	// consider taking the sum variable as long
	// Set should of long as well
	// TC - O(N)
	// SC - O(N) because of the set we are taking to store the sums

	public static int solve(int[] A) {

		Set<Long> psSumSet = new HashSet<>();
		long sum = 0;

		// O(N) operation as we are iterating over the array only once
		for (int x : A) {
			sum += x;

			// lookup in the set is also an O(1) operation in average case
			if (x == 0 || sum == 0 || psSumSet.contains(sum)) {
				return 1;
			}

			// add the sum to the set
			psSumSet.add(sum);
		}
		return 0;

//		long[] ps = new long[A.length];
//		ps[0] = A[0];
//
//		// O(N) - TC step to build the prefix sum array
//		for (int i = 1; i < A.length; i++) {
//			ps[i] = ps[i - 1] + A[i];
//		}
//
//		Set<Long> psSumSet = new HashSet<>();
//		for (long x : ps) {
//			if (x == 0 || psSumSet.contains(x)) {
//				return 1;
//			}
//			psSumSet.add(x);
//		}
//		return 0;
	}

//	public static int solve(int[] A) {
//		int[] ps = new int[A.length + 1];
//		ps[0] = 0;
//
//		// O(N) - TC step to build the prefix sum array
//		for (int i = 0; i < A.length; i++) {
//			ps[i + 1] = ps[i] + A[i];
//		}
//
//		Map<Integer, Boolean> psRepeateCheckMap = new HashMap<>();
//		for (int x : ps) {
//			if (psRepeateCheckMap.containsKey(x)) {
//				return 1;
//			}
//			psRepeateCheckMap.put(x, true);
//		}
//		return 0;
//	}

	// Count the number of sub-arrays with zero sum
	public static int followup1(int[] A) {

		// 1.) count the number of duplicate pairs in the PS array
		// 2.) Handle the edge case where PS[i] == 0, it will mean the overall sum from
		// 0 to ith index is 0.
		// so count should be increased in these two cases

		Set<Long> psSumSet = new HashSet<>();
		long sum = 0;
		int count = 0;

		// O(N) operation as we are iterating over the array only once
		for (int x : A) {
			sum += x;

			// handle the edge case where sum till ith index is 0
			if (sum == 0) {
				count++;
			}

			// lookup in the set is also an O(1) operation in average case
			// here we are checking if there is any range subarray where the overall sum of
			// range is 0
			if (psSumSet.contains(sum)) {
				count++;
			}

			// add the sum to the set
			psSumSet.add(sum);
		}
		return count;
	}

	// return the longest subarray (s,e) with zero sum
	public static int followup2(int[] A) {

		// 1.) Duplicate pairs with max distance in the PS array
		// 2.) Handle the edge case where PS[i] == 0, it means the distance of i from
		// index 0.

		Map<Long, Integer> psFirstIndexMap = new HashMap<>();
		long sum = 0;
		int answer = Integer.MIN_VALUE;

		// O(N) operation as we are iterating over the array only once
		for (int i = 0; i < A.length; i++) {
			sum += A[i];

			if (sum == 0) {
				answer = Math.max(answer, i + 1);
			}

			if (psFirstIndexMap.containsKey(sum)) {
				answer = Math.max(answer, i - psFirstIndexMap.get(sum) + 1);
			} else {
				// add the sum to the map for the first time only in order to maintain the
				// maximum gap
				psFirstIndexMap.put(sum, i);
			}
		}

		if (answer == Integer.MIN_VALUE) {
			return -1;
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		System.out.println(solve(A));
		System.out.println(followup1(A));
		System.out.println(followup2(A));

		int[] A1 = { -1, 1, 0 };
		System.out.println(solve(A1));
		System.out.println(followup1(A1));
		System.out.println(followup2(A1));
	}
}

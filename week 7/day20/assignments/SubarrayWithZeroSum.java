//Q4. Sub-array with 0 sum
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

package day20.assignments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarrayWithZeroSum {
	public static int solve(List<Integer> A) {

		Map<Long, Integer> prefixSumFrequencyMap = new HashMap<>();

		long sum = 0;
		for (Integer element : A) {

			if (element == 0) {
				return 1;
			}

			sum += element;

			if (sum == 0) {
				return 1;
			}

			prefixSumFrequencyMap.put(sum, prefixSumFrequencyMap.getOrDefault(sum, 0) + 1);
		}

		for (Map.Entry<Long, Integer> entry : prefixSumFrequencyMap.entrySet()) {
			if (entry.getValue() >= 2) {
				return 1;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		Integer[] A = { -1, 1 };
		List<Integer> list = Arrays.asList(A);
		System.out.println(solve(list));
	}
}

package day32.homework;

//Q2. Max Non Negative SubArray

//Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
//
//The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
//
//Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
//
//Find and return the required subarray.
//
//NOTE:
//
//    1. If there is a tie, then compare with segment's length and return segment which has maximum length.
//    2. If there is still a tie, then return the segment with minimum starting index.
//
//
//Input Format:
//
//The first and the only argument of input contains an integer array A, of length N.
//Output Format:
//
//Return an array of integers, that is a subarray of A that satisfies the given conditions.
//Constraints:
//
//1 <= N <= 1e5
//-INT_MAX < A[i] <= INT_MAX
//Examples:
//
//Input 1:
//    A = [1, 2, 5, -7, 2, 3]
//
//Output 1:
//    [1, 2, 5]
//
//Explanation 1:
//    The two sub-arrays are [1, 2, 5] [2, 3].
//    The answer is [1, 2, 5] as its sum is larger than [2, 3].
//
//Input 2:
//    A = [10, -1, 2, 3, -4, 100]
//
//Output 2:
//    [100]
//
//Explanation 2:
//    The three sub-arrays are [10], [2, 3], [100].
//    The answer is [100] as its sum is larger than the other two.

import java.util.ArrayList;
import java.util.List;

public class MaxNonNegativeSubArray {
	public static int[] maxset(int[] A) {

		// result is used to store the final result array
		List<Integer> result = new ArrayList<>();

		// is used to store the current result
		List<Integer> currentResult = new ArrayList<>();

		long sum = 0;
		long currentSum = 0;

		// iterate over the entire array
		for (int i = 0; i < A.length; i++) {

			// if element is greater than equal to zero include in the current result and
			// current sum
			if (A[i] >= 0) {
				currentResult.add(A[i]);
				currentSum += A[i];
			} else if (!currentResult.isEmpty()) { // else check for the desired conditions provided
				if (sum < currentSum || (sum == currentSum && currentResult.size() > result.size())) {
					sum = currentSum;
					result = new ArrayList<>(currentResult);
				}
				currentResult.clear();
				currentSum = 0;
			}
		}

		// lets say the last element has the highest value and will overcome the current
		// max sum, so this condition is important
		if (sum < currentSum || (sum == currentSum && currentResult.size() > result.size())) {

			// map the Integer to int and return in an array
			return currentResult.stream().mapToInt(i -> i).toArray();
		}

		// map the Integer to int and return in an array
		return result.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 5, -7, 2, 3 };

		int[] res = maxset(A);
		for (int x : res) {
			System.out.print(x + " ");
		}
	}
}

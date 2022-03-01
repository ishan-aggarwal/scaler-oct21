package day52.assignment;

//Q4. Largest Continuous Sequence Zero Sum

//Problem Description
//
//Given an array A of N integers.
//
//Find the largest continuous sequence in a array which sums to zero.
//
//
//
//Problem Constraints
//
//1 <= N <= 106
//
//-107 <= A[i] <= 107
//
//
//
//Input Format
//
//Single argument which is an integer array A.
//
//
//
//Output Format
//
//Return an array denoting the longest continuous sequence with total sum of zero.
//
//NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
//
//
//
//Example Input
//
//A = [1,2,-2,4,-4]
//
//
//Example Output
//
//[2,-2,4,-4]
//
//
//Example Explanation
//
//[2,-2,4,-4] is the longest sequence with total sum of zero.

import java.util.HashMap;
import java.util.Map;

public class LSWithZeroSum {
	public static int[] lszero(int[] A) {

		// 1.) Duplicate pairs with max distance in the PS array
		// 2.) Handle the edge case where PS[i] == 0, it means the distance of i from
		// index 0.

		Map<Long, Integer> psFirstIndexMap = new HashMap<>();
		long sum = 0;
		int answer = Integer.MIN_VALUE;
		int start = -1, end = -1;

		// O(N) operation as we are iterating over the array only once
		for (int i = 0; i < A.length; i++) {
			sum += A[i];

			if (sum == 0) {
				answer = Math.max(answer, i + 1);
				if (answer == i + 1) {
					start = 0;
					end = i;
				}
			}

			if (psFirstIndexMap.containsKey(sum)) {
				if (i - psFirstIndexMap.get(sum) > answer) {
					answer = i - psFirstIndexMap.get(sum);
					start = psFirstIndexMap.get(sum) + 1;
					end = i;
				}
			} else {
				// add the sum to the map for the first time only in order to maintain the
				// maximum gap
				psFirstIndexMap.put(sum, i);
			}
		}

		if (answer == Integer.MIN_VALUE) {
			return new int[] {};
		}

		int[] result = new int[end - start + 1];
		for (int i = start; i <= end; i++) {
			result[i - start] = A[i];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, -3, 3 };
		int[] result = lszero(A);
		for (int x : result) {
			System.out.print(x + " ");
		}

		System.out.println();
		int[] A1 = { 1, 2, -2, 4, -4 };
		int[] result1 = lszero(A1);
		for (int x : result1) {
			System.out.print(x + " ");
		}

		System.out.println();
		int[] A2 = { -19, 8, 2, -8, 19, 5, -2, -23 };
		int[] result2 = lszero(A2);
		for (int x : result2) {
			System.out.print(x + " ");
		}
	}
}

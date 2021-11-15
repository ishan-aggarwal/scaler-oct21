/*
 * Given and array find an equilibrium index in the array 
 * 
 * EI -> index i for which sum of all elements on the left = sum of all the elements on the right
 * 
 * Amazon, Direct i
 * 
 * Time complexity
 * O ( N ) - where N is the size of the array used for preparing prefix sum and then finding the index
 * 
 * Space Complexity
 * O ( N ) - where N is the size of the array used for storing the prefix sum array
 * 
 */

package day11.classroom;

import java.util.Arrays;
import java.util.List;

public class FindEquilibriumIndex {

	public static void main(String[] args) {

		Integer[] A = { 1, 2, 3, 4, 8, 10 };
		List<Integer> list = Arrays.asList(A);

		System.out.println(solve(list));

		Integer[] B = { -7, 1, 5, 2, -4, 3, 0 };
		list = Arrays.asList(B);

		System.out.println(solve(list));

	}

	private static int solve(List<Integer> list) {
		if (list == null) {
			return -1;
		}
		if (list.isEmpty()) {
			return -1;
		}
		int size = list.size();
		int[] prefixSum = preparePrefixSum(list);

		if (prefixSum[size - 1] - prefixSum[0] == 0) {
			return 0;
		}

		int leftSum, rightSum;
		for (int i = 1; i < size; i++) {
			leftSum = prefixSum[i - 1];
			rightSum = prefixSum[size - 1] - prefixSum[i];
			if (leftSum == rightSum) {
				return i;
			}
		}

		return -1;
	}

	private static int[] preparePrefixSum(List<Integer> list) {

		int[] prefixSum = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			prefixSum[i] = 0;
		}
		prefixSum[0] = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			prefixSum[i] = list.get(i) + prefixSum[i - 1];
		}
		return prefixSum;
	}
}

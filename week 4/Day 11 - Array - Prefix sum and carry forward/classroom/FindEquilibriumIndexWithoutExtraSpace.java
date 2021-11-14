/*
 * Given and array find an equilibrium index in the array without using extra space
 * 
 * EI -> index i for which sum of all elements on the left = sum of all the elements on the right
 * 
 * Amazon, Direct i
 * 
 * Time complexity
 * O ( N ) - where N is the size of the array used for finding right sum and then finding the index
 * 
 */

package day11.classroom;

import java.util.Arrays;
import java.util.List;

public class FindEquilibriumIndexWithoutExtraSpace {

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

		int leftSum = 0;
		int rightSum = 0;
		for (int i = 0; i < size; i++) {
			rightSum += list.get(i);
		}

		if (0 == rightSum - list.get(0)) {
			return 0;
		}

		for (int i = 1; i < size; i++) {
			leftSum += list.get(i - 1);
			if (leftSum == rightSum - leftSum - list.get(i)) {
				return i;
			}
		}
		return -1;
	}
}

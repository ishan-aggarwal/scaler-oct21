/**
 * Given an array of size N. Return the total sum of all possible sub-arrays
 * 
 * element at index i can come in how many sub arrays
 * start [0, i] = (i-0+1)= (i+1)
 * end   [i, n-1] = (n-1-i+1) = (n-i)
 * 
 * TC : O(n) - here we are finding how many times an element has contributed to the overall sum 
 */

package day10.classroom;

import java.util.Arrays;
import java.util.List;

public class PrintTotalSumOfAllSubarrays {

	public static void main(String[] args) {

		Integer A[] = { 3, 7, 1, 6, 8, -2, 9 };
		List<Integer> list = Arrays.asList(A);
		solve(list);
	}

	private static void solve(List<Integer> list) {
		long sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i) * 1l * (i + 1) * (list.size() - i);
		}

		System.out.println(sum);
	}
}

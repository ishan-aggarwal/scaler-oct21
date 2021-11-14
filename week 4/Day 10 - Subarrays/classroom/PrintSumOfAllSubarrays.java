/**
 * Given an array of size N. Print sum of all sub-arrays of an array.
 * 
 * TC : O (N^2) and space complexity is constant
 */

package day10.classroom;

import java.util.Arrays;
import java.util.List;

public class PrintSumOfAllSubarrays {

	public static void main(String[] args) {

		Integer A[] = { 3, 7, 1, 6, 8, -2, 9 };
		List<Integer> list = Arrays.asList(A);
		solve(list);
	}

	private static void solve(List<Integer> list) {
		int sum, overallSum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum = 0;
			for (int j = i; j < list.size(); j++) {
				sum += list.get(j);
				overallSum += sum;
				System.out.print(sum + ", ");
			}
			System.out.println();
		}
		System.out.println(overallSum);
	}
}

/*
 * Given an array and Q queries 
 * In every query you get the start and end index of a sub-array
 * Print the sum of the sub-arrays for every query.
 * 
 * Amazon
 * 
 * Time complexity
 * O ( N + Q ) - where N is the size of the array used for preparing prefix sum
 * 			- and Q is the size of the queries
 * 
 * Space Complexity
 * O ( N ) - where N is the size of the array used for storing the prefix sum array
 * 
 */

package day11.classroom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReturnSumOfSubarrayWithQQueries {

	public static void main(String[] args) {

		Integer[] A = { -3, 6, 2, 4, 5, 2, 8, -9, 3, 1 };
		List<Integer> list = Arrays.asList(A);

		ArrayList<ArrayList<Integer>> queries = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(1);
		al1.add(3);

		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(2);
		al2.add(7);

		ArrayList<Integer> al3 = new ArrayList<Integer>();
		al3.add(0);
		al3.add(2);

		queries.add(al1);
		queries.add(al2);
		queries.add(al3);

		ArrayList<Integer> result = solve(list, queries);
		for (Integer value : result) {
			System.out.print(value + " ");
		}

	}

	private static ArrayList<Integer> solve(List<Integer> list, ArrayList<ArrayList<Integer>> queries) {
		ArrayList<Integer> result = new ArrayList<>();

		if (list == null || queries == null) {
			return null;
		}

		if (list.isEmpty() || queries.isEmpty()) {
			return result;
		}

		int[] prefixSum = preparePrefixSum(list);

		int start, end, answer;
		for (ArrayList<Integer> eachQ : queries) {
			start = eachQ.get(0);
			end = eachQ.get(1);

			if (start > 0) {
				answer = prefixSum[end] - prefixSum[start - 1];
			} else {
				answer = prefixSum[end];
			}
			result.add(answer);
		}

		return result;
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

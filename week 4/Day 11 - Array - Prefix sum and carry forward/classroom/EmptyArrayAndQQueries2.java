/*
 * Given an array of size N initialized by 0
 * Given Q queries having an index se, e and a value v
 * Add v to all the index from s to N-1
 * return the final state of the array
 * 
 * overall time complexity -> O(N) + O(Q)
 * Space complexity -> O(N) for result array
 * 
 * This technique is called lazy propagation
 * 
 */

package day11.classroom;

import java.util.ArrayList;
import java.util.List;

public class EmptyArrayAndQQueries2 {

	public static void main(String[] args) {

		Integer[] A = { 0, 0, 0, 0, 0, 0 };

		ArrayList<ArrayList<Integer>> queries = new ArrayList<>();
		ArrayList<Integer> q1 = new ArrayList<>();
		ArrayList<Integer> q2 = new ArrayList<>();
		ArrayList<Integer> q3 = new ArrayList<>();

		q1.add(2);
		q1.add(4);
		q1.add(2);

		q2.add(1);
		q2.add(3);
		q2.add(1);

		q3.add(0);
		q3.add(3);
		q3.add(5);

		queries.add(q1);
		queries.add(q2);
		queries.add(q3);

		List<Integer> res = solve(A, queries);
		System.out.println(res.toString());

	}

	private static List<Integer> solve(Integer[] a, ArrayList<ArrayList<Integer>> queries) {
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < a.length; i++) {
			res.add(0);
		}

		int startIndex, endIndex, value;
		for (ArrayList<Integer> eachQ : queries) {
			startIndex = eachQ.get(0);
			endIndex = eachQ.get(1);
			value = eachQ.get(2);
			res.set(startIndex, res.get(startIndex) + value);
			if (endIndex < a.length - 1) {
				res.set(endIndex + 1, res.get(endIndex + 1) + (-1 * value));
			}
		}

		for (int i = 1; i < a.length; i++) {
			res.set(i, res.get(i) + res.get(i - 1));
		}

		return res;
	}

}

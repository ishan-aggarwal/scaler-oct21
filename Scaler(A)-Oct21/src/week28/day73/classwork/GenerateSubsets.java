package week28.day73.classwork;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateSubsets {

	public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> current = new ArrayList<Integer>();
		int start = 0;
		generate(start, current, ans, a);
		return ans;
	}

	// TC - N * 2^N
	// SC - O(N) + O(N)
	public static void generate(int idx, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> ans,
			ArrayList<Integer> a) {

		if (idx == a.size()) {
			ans.add(new ArrayList<>(current));
			return;
		}

		current.add(a.get(idx));
		generate(idx + 1, current, ans, a);

		current.remove(current.size() - 1);
		generate(idx + 1, current, ans, a);
	}

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
		System.out.println(solve(a));
	}

}

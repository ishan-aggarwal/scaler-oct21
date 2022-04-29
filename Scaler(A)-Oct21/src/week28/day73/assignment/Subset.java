package week28.day73.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Q1. Subset
//Problem Description
//Given a set of distinct integers A, return all possible subsets.
//
//NOTE:
//
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//Also, the subsets should be sorted in ascending ( lexicographic ) order.
//The list is not necessarily sorted.
//
//
//Problem Constraints
//1 <= |A| <= 16
//INTMIN <= A[i] <= INTMAX
//
//
//Input Format
//First and only argument of input contains a single integer array A.
//
//
//
//Output Format
//Return a vector of vectors denoting the answer.
//
//
//
//Example Input
//Input 1:
//
//A = [1]
//Input 2:
//
//A = [1, 2, 3]
//
//
//Example Output
//Output 1:
//
//[
//    []
//    [1]
//]
//Output 2:
//
//[
// []
// [1]
// [1, 2]
// [1, 2, 3]
// [1, 3]
// [2]
// [2, 3]
// [3]
//]
//
//
//Example Explanation
//Explanation 1:
//
// You can see that these are all possible subsets.
//Explanation 2:
//
//You can see that these are all possible subsets.

public class Subset {

	// Overall TC - O(N * 2^N)
	// Overall SC - O(N) height of the recursion stack + O(2^N) for storing the
	// subsets
	static void solve(int idx, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> A) {
		if (idx == A.size()) {
			ans.add(new ArrayList<>(cur)); // TC - O(N)
			return;
		}

		// TC - O(2^N)
		solve(idx + 1, cur, ans, A); // not take
		int element = A.get(idx);
		cur.add(element); // DO
		solve(idx + 1, cur, ans, A); // take
		cur.remove(cur.size() - 1); // UNDO

//			Another way
//        if (idx == A.size()) {
//        	ans.add(new ArrayList<Integer>(cur));
//            return;
//        }
//
//        cur.add(A.get(idx));
//        solve(idx + 1, cur, ans, A); // Take
//        cur.remove(cur.size() - 1);  // Undo last step
//        solve(idx + 1, cur, ans, A); // Not take

	}

	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		Collections.sort(A);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> cur = new ArrayList<>();
		solve(0, cur, ans, A);
		// sort list of list
		Collections.sort(ans, (ArrayList<Integer> first, ArrayList<Integer> second) -> {
			for (int i = 0; i < first.size() && i < second.size(); i++) {
				if (first.get(i) < second.get(i))
					return -1;
				if (first.get(i) > second.get(i))
					return 1;
			}
			if (first.size() > second.size())
				return 1;
			return -1;
		});
		return ans;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
		System.out.println(subsets(A));
	}
}

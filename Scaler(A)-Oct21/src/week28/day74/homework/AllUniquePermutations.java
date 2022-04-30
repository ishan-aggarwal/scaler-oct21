package week28.day74.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// https://leetcode.com/problems/permutations-ii/submissions/
//Q2. All Unique Permutations
//Problem Description
//Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
//
//NOTE: No 2 entries in the permutation sequence should be the same.
//
//WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
//If you do, we will disqualify your submission retroactively and give you penalty points.
//
//
//Problem Constraints
//1 <= |A| <= 9
//
//0 <= A[i] <= 10
//
//
//
//Input Format
//Only argument is an integer array A of size N.
//
//
//
//Output Format
//Return a 2-D array denoting all possible unique permutation of the array.
//
//
//
//Example Input
//Input 1:
//
//A = [1, 1, 2]
//Input 2:
//
//A = [1, 2]
//
//
//Example Output
//Output 1:
//
//[ [1,1,2]
//  [1,2,1]
//  [2,1,1] ]
//Output 2:
//
//[ [1, 2]
//  [2, 1] ]
//
//
//Example Explanation
//Explanation 1:
//
// All the possible unique permutation of array [1, 1, 2].
//Explanation 2:
//
// All the possible unique permutation of array [1, 2].

public class AllUniquePermutations {
	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> curr = new ArrayList<Integer>(A);
		Collections.sort(curr);
		solve(0, A, curr, ans);
		return ans;
	}

	private static void solve(int idx, ArrayList<Integer> a, ArrayList<Integer> curr,
			ArrayList<ArrayList<Integer>> ans) {

		if (idx == a.size()) {
			if (!ans.contains(curr)) {
				ans.add(new ArrayList<>(curr));
			}
			return;
		}

		for (int i = idx; i < a.size(); i++) {
			swap(curr, i, idx);
			solve(idx + 1, a, curr, ans);
			swap(curr, i, idx);
		}

	}

	private static void swap(ArrayList<Integer> curr, int i, int idx) {
		int temp = curr.get(i);
		curr.set(i, curr.get(idx));
		curr.set(idx, temp);
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 2));
		System.out.println(permute(A));
	}
}

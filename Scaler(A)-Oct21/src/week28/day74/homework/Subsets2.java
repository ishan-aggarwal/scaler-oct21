package week28.day74.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Q1. Subsets II
//Problem Description
//
//Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.
//
//NOTE:
//
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//The subsets must be sorted lexicographically.
//
//
//Problem Constraints
//
//0 <= N <= 16
//
//
//
//Input Format
//
//Only argument is an integer array A of size N.
//
//
//
//Output Format
//
//Return a 2-D vector denoting all the possible subsets.
//
//
//
//Example Input
//
//Input 1:
//
// A = [1, 2, 2]
//Input 2:
//
// A = [1, 1]
//
//
//Example Output
//
//Output 1:
//
// [
//    [],
//    [1],
//    [1, 2],
//    [1, 2, 2],
//    [2],
//    [2, 2]
// ]
//Output 2:
//
// [
//    [],
//    [1],
//    [1, 1]
// ]
//
//
//Example Explanation
//
//Explanation 1:
//
//All the subsets of the array [1, 2, 2] in lexicographically sorted order.

public class Subsets2 {
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> curr = new ArrayList<Integer>();

		Collections.sort(A);
		findSubsets(0, curr, ans, A);

		Collections.sort(ans, (ArrayList<Integer> first, ArrayList<Integer> second) -> {
			int i = 0, j = 0;
			while (i < first.size() && j < second.size()) {
				if (first.get(i) < second.get(j)) {
					return -1;
				} else if (first.get(i) > second.get(j)) {
					return 1;
				}
				i++;
				j++;
			}
			if (first.size() > second.size())
				return 1;
			return -1;
		});

		return ans;
	}

	private static void findSubsets(int idx, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans,
			ArrayList<Integer> a) {
		if (idx == a.size()) {
			if (!ans.contains(curr)) {
				ans.add(new ArrayList<>(curr));
			}
			return;
		}

		int element = a.get(idx);
		curr.add(element);
		findSubsets(idx + 1, curr, ans, a);

		curr.remove(curr.size() - 1);
		findSubsets(idx + 1, curr, ans, a);
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 2));
		System.out.println(subsetsWithDup(A));
	}
}

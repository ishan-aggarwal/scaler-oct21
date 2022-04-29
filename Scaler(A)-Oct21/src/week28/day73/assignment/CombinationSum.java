package week28.day73.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Q2. Combination Sum
//Problem Description
//Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.
//
//The same repeated number may be chosen from A unlimited number of times.
//
//Note:
//
//1) All numbers (including target) will be positive integers.
//
//2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//
//3) The combinations themselves must be sorted in ascending order.
//
//4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
//
//5) The solution set must not contain duplicate combinations.
//
//
//
//Problem Constraints
//1 <= |A| <= 20
//
//1 <= A[i] <= 50
//
//1 <= B <= 500
//
//
//
//Input Format
//The first argument is an integer array A.
//
//The second argument is integer B.
//
//
//
//Output Format
//Return a vector of all combinations that sum up to B.
//
//
//
//Example Input
//Input 1:
//
//A = [2, 3]
//B = 2
//Input 2:
//
//A = [2, 3, 6, 7]
//B = 7
//
//
//Example Output
//Output 1:
//
//[ [2] ]
//Output 2:
//
//[ [2, 2, 3] , [7] ]
//
//
//Example Explanation
//Explanation 1:
//
//All possible combinations are listed.
//Explanation 2:
//
//All possible combinations are listed.

public class CombinationSum {

	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {

		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> curr = new ArrayList<Integer>();

		Collections.sort(A);

		solve(0, 0, curr, subsets, A, B);

		Collections.sort(subsets, (ArrayList<Integer> first, ArrayList<Integer> second) -> {

			int i = 0, j = 0;
			while (i < first.size() && j < second.size()) {
				if (first.get(i) < second.get(j)) {
					return -1;
				}
				if (first.get(i) > second.get(j)) {
					return 1;
				}
				i++;
				j++;
			}
			if (first.size() > second.size()) {
				return 1;
			}
			return -1;
		});

		return subsets;
	}

	private static void solve(int idx, int currSum, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> subsets,
			ArrayList<Integer> A, int target) {

		// base conditions
		if (idx >= A.size()) {
			if (currSum == target && !subsets.contains(curr)) {
				subsets.add(new ArrayList<>(curr));
			}
			return;
		}

		if (currSum == target && !subsets.contains(curr)) {
			subsets.add(new ArrayList<>(curr));
			return;
		}

		if (currSum > target) {
			return;
		}

		// initializing k = idx will eliminate the duplicates
//		for (int k = idx; k < A.size(); k++) {
//			// add
//			curr.add(A.get(k));
//			currSum += A.get(k);
//
//			solve(k, currSum, curr, subsets, A, target);
//
//			// remove
//			curr.remove(curr.size() - 1);
//			currSum -= A.get(k);
//		}

		// This way without loop is also working
		currSum += A.get(idx);
		curr.add(A.get(idx));
		solve(idx, currSum, curr, subsets, A, target); // take element at index and re-consider it

		currSum -= A.get(idx); // remove the last inserted element when the current sum has increased target
		curr.remove(curr.size() - 1);
		solve(idx + 1, currSum, curr, subsets, A, target); // take element at index and re-consider it
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 3, 6, 7));
		System.out.println(combinationSum(A, 7));
	}
}

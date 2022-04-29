package week28.day73.classwork;

import java.util.ArrayList;
import java.util.Arrays;

//	Q4. Count all subsets of an array whose sum is equal to given target.
public class CountSubsetsWithGivenSum {

	public static int solve(ArrayList<Integer> a, int target) {
		int start = 0;
		int currSum = 0;
		int ans = countSubsets(start, a, currSum, target);
		return ans;
	}

	// TC - 2^N
	// SC - O(N)
	public static int countSubsets(int idx, ArrayList<Integer> a, int currSum, int target) {

		if (idx == a.size()) {
			if (currSum == target) {
				return 1;
			} else {
				return 0;
			}
		}

		currSum += a.get(idx); // consider current element in current sum
		int x = countSubsets(idx + 1, a, currSum, target);

		currSum -= a.get(idx); // undo last consideration
		int y = countSubsets(idx + 1, a, currSum, target);

		return x + y;
	}

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(5, 2, 7));
		System.out.println(solve(a, 7));
	}

}

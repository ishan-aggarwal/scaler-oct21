package hashing;

// https://leetcode.com/problems/two-sum/
// 1. Two Sum
// Easy

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> elementPositionMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (elementPositionMap.containsKey(target - nums[i])) {
				int otherPosition = elementPositionMap.get(target - nums[i]);
				return new int[] { i, otherPosition };
			}
			elementPositionMap.put(nums[i], i);
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] result = twoSum(nums, target);
		System.out.println(result[0] + " " + result[1]);
	}
}
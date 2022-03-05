package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

// 1365. How Many Numbers Are Smaller Than the Current Number
// Easy

public class NumbersSmallerThanCurrent {
	public static int[] smallerNumbersThanCurrent(int[] nums) {

		// create a duplicate array of original nums array
		int[] dupArray = Arrays.copyOf(nums, nums.length);
		Map<Integer, Integer> positionMap = new HashMap<>();

		// idea is to sort the array and when the elements are arranged in increasing
		// order
		Arrays.sort(nums);

		// note their indexes in a position map
		// index of the element represents the number of elements smaller than that
		// element
		// in case their are duplicate elements as well, we will overrite the map with
		// the smallest possible index

		for (int i = nums.length - 1; i >= 0; i--) {
			positionMap.put(nums[i], i);
		}

		// finally iterate over the dup array to find the number of elements lesser than
		// element
		int idx = 0;
		for (int x : dupArray) {
			nums[idx++] = positionMap.get(x);
		}

		// return result
		return nums;
	}

	public static void main(String[] args) {
		int[] A = { 8, 1, 2, 2, 3 };
		int[] result = smallerNumbersThanCurrent(A);

		System.out.println(Arrays.toString(result));
	}
}
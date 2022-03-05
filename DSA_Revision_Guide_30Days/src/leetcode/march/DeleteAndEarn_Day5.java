package leetcode.march;

import java.util.HashMap;
import java.util.Map;

//740. Delete and Earn

// https://leetcode.com/problems/delete-and-earn/

//Medium
//
//You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
//
//Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
//Return the maximum number of points you can earn by applying the above operation some number of times.
//
// 
//
//Example 1:
//
//Input: nums = [3,4,2]
//Output: 6
//Explanation: You can perform the following operations:
//- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
//- Delete 2 to earn 2 points. nums = [].
//You earn a total of 6 points.
//Example 2:
//
//Input: nums = [2,2,3,3,3,4]
//Output: 9
//Explanation: You can perform the following operations:
//- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
//- Delete a 3 again to earn 3 points. nums = [3].
//- Delete a 3 once more to earn 3 points. nums = [].
//You earn a total of 9 points.
// 
//
//Constraints:
//
//1 <= nums.length <= 2 * 104
//1 <= nums[i] <= 104

class DeleteAndEarn_Day5 {
	public static int deleteAndEarn(int[] nums) {

//		The idea is a simple trick. First, you notice that at every single element in our original nums array, 
//		you have 2 choices: To earn or not to earn. Based on problem, whichever element you earn, 
//		you must delete any values of nums[i]-1 and nums[i]+1. 
//		It helps to assume a sorted array so that you can place elements in ascending order to visualize the problem. 
//		You notice there that if you earn an element, you cannot earn its immediate unequal neighbors on both sides.
//
//		You also notice that if you have duplicate values in nums array, if you earn one of them, 
//		you end up earning all of them. This is because you have deleted its neighbors and 
//		therefore make its remaining duplicates "undeletable". This is important because you notice the problem 
//		simplifies to which values can earn you the largest total.
//
//		So I aggregated the sums into a sums array to map each value (array's index) with the total sum 
//		you can earn by deleting all elements of that value (array's value). 
//		Then write a for loop to compute the maximum sum ending at i At each step, 
//		your sum can either depend on your previous sum or the prior plus the current. 
//		You use a greedy algorithm to always pick the maximum value for each i.
//
//		*** Notice that when you create sums array, it naturally orders (sorts) the elements for you
//		in ascending order so you can traverse it and get its immediate unequal neighbors on both sides in O(1).
//
//		sum[i] = Max(sum[i-1], sum[i-2] + sum[i])

		int[] sum = new int[10002];

		for (int i = 0; i < nums.length; i++) {
			sum[nums[i]] += nums[i];
		}

		// starting i from 2, since we are checking for (i - 2)th element
		for (int i = 2; i < sum.length; i++) {
			sum[i] = Math.max(sum[i - 1], sum[i - 2] + sum[i]);
		}
		return sum[10001];
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 3, 3, 3, 4 };
		System.out.println(deleteAndEarn(nums));
	}
}
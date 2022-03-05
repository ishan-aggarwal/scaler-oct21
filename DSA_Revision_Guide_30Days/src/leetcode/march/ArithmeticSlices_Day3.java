package leetcode.march;

// 413. Arithmetic Slices
// https://leetcode.com/problems/arithmetic-slices/
// Medium

//An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

//For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
//Given an integer array nums, return the number of arithmetic subarrays of nums.
//A subarray is a contiguous subsequence of the array.
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//Output: 3
//Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
//Example 2:
//
//Input: nums = [1]
//Output: 0
//
//Constraints:
//
//1 <= nums.length <= 5000
//-1000 <= nums[i] <= 1000

class ArithmeticSlices_Day3 {
	public static int numberOfArithmeticSlices(int[] nums) {

		int length = nums.length;

		// if length is less than 3, than return 0
		if (length < 3) {
			return 0;
		}

		// current subarray count
		// total represents the answer
		int count = 0, total = 0;

		// since length is minimum 3, so start idx with 2
		// check for the condition that difference of consecutive elements on left and
		// right are same or not
		// nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]
		// if difference is same increase the current count by 1...
		// and add the current count to overall answer
		// in case difference is not same the current count has to be reset to zero
		// as it can not contribute in subarray (as subarray elements are consecutive in
		// nature)

		for (int i = 2; i < length; i++) {
			if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
				count++;
			} else {
				// total += (count + 1) * count / 2;
				count = 0;
			}
			total += count;
		}

		// finally return the answer
		// return total + (count + 1) * count / 2;
		return total;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(numberOfArithmeticSlices(nums));
	}
}
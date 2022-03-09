package dp;

import java.util.Arrays;

class HouseRobber1_198 {
	public static int rob(int[] nums) {

		// solution
		// TC - O(N) and SC - O(N) as a DP array is created based on greedy approach
//		if (nums.length == 1) {
//			return nums[0];
//		}
//
//		int dp[] = new int[nums.length];
//		dp[0] = nums[0];
//		dp[1] = Math.max(nums[0], nums[1]);
//
//		for (int i = 2; i < nums.length; ++i) {
//			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
//		}
//
//		return dp[nums.length - 1];

		// solution with constant space complexity
		// by maintaining two variables

//		int prevMax = 0;
//		int currMax = 0;
//		for (int x : nums) {
//			int temp = currMax;
//			currMax = Math.max(prevMax + x, currMax);
//			prevMax = temp;
//		}
//		return currMax;

		return robRange(nums, 0, nums.length - 1);
	}

	private static int robRange(int[] nums, int start, int end) {
		int[] numsNew = Arrays.copyOfRange(nums, start, end + 1);
		int[] dp = new int[numsNew.length];
		if (numsNew.length == 0)
			return 0;
		if (numsNew.length == 1)
			return numsNew[0];
		dp[0] = numsNew[0];
		dp[1] = Math.max(numsNew[0], numsNew[1]);
		for (int i = 2; i < numsNew.length; i++) {
			dp[i] = Math.max(dp[i - 2] + numsNew[i], dp[i - 1]);
		}
		return dp[numsNew.length - 1];
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, 1, 2 };
		System.out.println(rob(nums));

	}
}
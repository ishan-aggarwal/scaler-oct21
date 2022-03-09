package dp;

import java.util.Arrays;

class HouseRobber2_213 {
	public static int rob(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return nums[0];
		}
		return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
	}

	private static int robRange(int[] nums, int start, int end) {
		int[] numsNew = Arrays.copyOfRange(nums, start, end + 1);
		int[] dp = new int[numsNew.length];
		if (numsNew.length == 0) {
			return 0;
		}
		if (numsNew.length == 1) {
			return numsNew[0];
		}
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
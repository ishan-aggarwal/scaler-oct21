// 300. Longest Increasing Subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/

class LISLength {
	public static int lengthOfLIS(int[] nums) {

		int size = nums.length;
		int[] out = new int[size];
		int lisLength = 0;
		out[0] = 1;

		for (int i = 1; i < size; i++) {
			out[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] >= nums[i]) {
					continue;
				}
				out[i] = Math.max(out[i], out[j] + 1);
			}
			if (out[i] > lisLength) {
				lisLength = out[i];
			}
		}
		return lisLength;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(nums));
	}
}
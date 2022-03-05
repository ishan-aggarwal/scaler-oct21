package trees;

class Solution {
	public static int numberOfArithmeticSlices(int[] nums) {

		int length = nums.length;

		if (length < 3) {
			return 0;
		}

		int count = 0, total = 0;
		for (int i = 2; i < length; i++) {
			if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
				count++;
			} else {
				total += (count + 1) * count / 2;
				count = 0;
			}
		}
		return total + (count + 1) * count / 2;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 7, 9 };
		System.out.println(numberOfArithmeticSlices(nums));
	}
}
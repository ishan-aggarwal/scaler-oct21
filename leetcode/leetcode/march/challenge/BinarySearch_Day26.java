package leetcode.march.challenge;

class BinarySearch_Day26 {

	// TC - O(LogN)
	public int search(int[] nums, int target) {

		int left = 0, right = nums.length - 1;

		// while left is less than equal to right
		while (left <= right) {

			// calculate mid
			int mid = left + (right - left) / 2;

			// check if mid is equal to target
			if (nums[mid] == target) {
				return mid; // return mid
			} else if (nums[mid] > target) { // check if target is less than mid element
				right = mid - 1; // shift right to mid - 1 position
			} else {
				left = mid + 1; // shift left to mid + 1 position
			}
		}

		// return -1 if left ptr passes right ptr
		return -1;
	}
}
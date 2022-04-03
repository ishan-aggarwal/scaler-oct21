package others;

//https://leetcode.com/problems/kth-largest-element-in-an-array/

// Idea - application of binary search
// To find the kth smallest element or largest element
// we need to count exactly the number of elements less than that value
// in order to do a count check it will take O(n^2) iterations
// so to optimize it, we need to find the max and min elements of the array
// once max and min elements are identified use that as a search space [min, max] in original array
// calculate mid element every time and check the count of elements less than mid
// in this way we would be able to reduce the time complexity to O(N * log(range)) 
// how to identify the search space

// same code will work for both repeated and non-repeated characters

class KthLargestElementInArray {

	// overall TC - O(N * log(range))
	public static int findKthLargest(int[] nums, int k) {
		int n = nums.length - 1;
		int x = n - k + 1;
		int ans = -1;

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		// TC - O(N)
		for (int i = 0; i < nums.length; ++i) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}

		int l = min, r = max;

		// TC - O (log(range)) where range -> (max - min)
		while (l <= r) {
			int mid = l + (r - l) / 2;
			int count = countSmallElements(nums, mid); // step takes O(N) time
			// reason for merging the if condition is to handle the duplicates as well
			if (count <= x) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return ans;
	}

	private static int countSmallElements(int[] nums, int ele) {
		int count = 0;
		for (int x : nums) {
			if (x < ele) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;
		System.out.println(findKthLargest(nums, k));
	}
}
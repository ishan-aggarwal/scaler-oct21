package others;

// https://leetcode.com/problems/container-with-most-water/

//Idea - two pointer approach 
//Since the array is not sorted and we need to find the maximum area of water...
//It requires two parameters (height and width) both. We need to some how reduce this selection criteria to only 1.
//
//Width will be maximum between the farthest points of the array.
//So lets take two pointers to point to those indexes 0 and n-1
//Now which pointer should we move... the one with less height we should ignore that element because it can not give a higher answer with any of the other indices of the array (as width will be further reduced).
//So based on this idea we should proceed.

class ContainerWithMostWater {

	// TC - O(N) and SC - O(1)
	public static int maxArea(int[] height) {
		int ans = 0;
		for (int i = 0, j = height.length - 1; i < j;) {

			int current = (j - i) * Math.min(height[i], height[j]);
			ans = Math.max(ans, current);
			if (height[i] < height[j]) {
				i++;
			} else if (height[i] > height[j]) {
				j--;
			} else {
				i++;
				j--;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height));
	}
}
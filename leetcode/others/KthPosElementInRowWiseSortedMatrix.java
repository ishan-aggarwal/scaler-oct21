package others;

class KthPosElementInRowWiseSortedMatrix {

	// TC - O(log(range) * (n log m))
	public static int find(int A[][], int k) {

		// find the range space to be used for performing binary search operation
		int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
		int rows = A.length;
		int cols = A[0].length;
		for (int i = 0; i < rows; ++i) {
			low = Math.min(low, A[i][0]);
			high = Math.max(high, A[i][cols - 1]);
		}

		int answer = -1;
		// TC - O (log (max - min))
		while (low <= high) {
			int mid = low + (high - low) / 2;
			// count of smaller elements can again be done using BS
			// because the given input arrays are sorted
			// so instead of doing linear search to count the smaller elements
			// we can do binary search operation to find the total elements less than given
			// element
			int count = 0;
			for (int i = 0; i < rows; ++i) {
				count += countSmaller(A[i], mid); // TC - O(log n)
			}
			if (count <= k) {
				answer = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return answer;
	}

	// count smaller is like finding floor or Upper bound
	private static int countSmaller(int[] arr, int ele) {
		int ans = -1;
		int l = 0, r = arr.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == ele) {
				return mid;
			} else if (arr[mid] > ele) {
				r = mid - 1;
			} else {
				ans = mid + 1; // reason for selecting mid+1 here is
				// because it is 0 based
				// lets say first element is smaller than the ele
				// then ans would be returned as 0 instead of 1
				l = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {

		int[][] A = { { 1, 2, 5, 8 }, { 3, 6, 7, 9 } };
		int k = 5;

		System.out.println(find(A, k));
	}
}

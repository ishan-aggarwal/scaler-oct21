package others;

class KthPosElementTwoSortedArrays {

	// overall TC - O(log(range) * (log m + log n))
	// TC - O(log(range) * (log mn))
	public static int find(int A[], int B[], int m, int n, int k) {

		// find the range space to be used for performing binary search operation
		int low = Math.min(A[0], B[0]);
		int high = Math.max(A[m - 1], B[n - 1]);
		int answer = -1;
		// TC - O (log (max - min))
		while (low <= high) {
			int mid = low + (high - low) / 2;
			// count of smaller elements can again be done using BS
			// because the given input arrays are sorted
			// so instead of doing linear search to count the smaller elements
			// we can do binary search operation to find the total elements less than given
			// element
			int count = countSmaller(A, mid); // TC - O(log m)
			count += countSmaller(B, mid); // TC - O(log n)
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
		int[] A = { 1, 2, 5, 8 };
		int[] B = { 3, 6, 7, 9, 10 };
		int k = 5;

		System.out.println(find(A, B, A.length, B.length, k));
	}
}

package day47.assignment;

// Q5. Given a sorted array of N elements
// find the floor of a given target k

// greatest element <= k

// -5,2,3,4,9,10,11,15,18
// k = 20 -> 18
// k = 2  -> 2
// K = 5  -> 4
// k = 14 -> 11

public class FloorCalculate {

	private static int findFloor(int[] A, int k) {
		int ans = Integer.MIN_VALUE;
		int l = 0, r = A.length - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (A[mid] == k) {
				return A[mid];
			} else if (A[mid] > k) {
				r = mid - 1;
			} else {
				ans = A[mid];
				l = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] A = { -5, 2, 3, 4, 9, 10, 11, 15, 18 };
		System.out.println(findFloor(A, 14));
	}

}

package day47.assignment;

// Q7. Given a sorted array of N elements
// find the ceil of a given target k

// smallest element >= k

// -5,2,3,4,9,10,11,15,18
// k = 20 -> Integer.MAX_VALUE
// k = 2  -> 2
// K = 5  -> 9
// k = 14 -> 15

public class CeilCalculate {

	private static int findFloor(int[] A, int k) {
		int ans = Integer.MAX_VALUE;
		int l = 0, r = A.length - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (A[mid] == k) {
				return A[mid];
			} else if (A[mid] > k) {
				ans = A[mid];
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] A = { -5, 2, 3, 4, 9, 10, 11, 15, 18 };
		System.out.println(findFloor(A, 14));
		System.out.println(findFloor(A, 5));
		System.out.println(findFloor(A, 2));
		System.out.println(findFloor(A, 50));
	}
}

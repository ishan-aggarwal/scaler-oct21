package day47.assignment;

// Q6. Given a sorted array of N elements
// find the floor of a given target k

// greatest element <= k

// -5,2,3,4,9,10,11,15,18
// k = 20 -> 18
// k = 2  -> 2
// K = 5  -> 4
// k = 14 -> 11

public class BinarySearch {

	private static int search(int[] A, int k) {
		int l = 0, r = A.length - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (A[mid] == k) {
				return mid;
			} else if (A[mid] > k) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] A = { -5, 2, 3, 4, 9, 10, 11, 15, 18 };
		System.out.println(search(A, 14));
		System.out.println(search(A, 11));
	}

}

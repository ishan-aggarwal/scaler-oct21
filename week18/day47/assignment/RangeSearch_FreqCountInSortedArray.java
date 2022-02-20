package day47.assignment;

//Q2. Search for a Range (Amazon)

//Problem Description
//Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
//
//
//
//Problem Constraints
//1 <= N <= 106
//
//1 <= A[i], B <= 109
//
//
//
//Input Format
//The first argument given is the integer array A.
//The second argument given is the integer B.
//
//
//
//Output Format
//Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
//
//
//
//Example Input
//Input 1:
//
// A = [5, 7, 7, 8, 8, 10]
// B = 8
//Input 2:
//
// A = [5, 17, 100, 111]
// B = 3
//
//
//Example Output
//Output 1:
//
// [3, 4]
//Output 2:
//
// [-1, -1]
//
//
//Example Explanation
//Explanation 1:
//
// First occurence of 8 in A is at index 3
// Second occurence of 8 in A is at index 4
// ans = [3, 4]
//Explanation 2:
//
// There is no occurence of 3 in the array.

public class RangeSearch_FreqCountInSortedArray {
	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public static int[] searchRange(final int[] A, int B) {

		int[] result = { -1, -1 };

		int first = findFirstOccurence(A, B);
		if (first == -1) {
			return result;
		}
		int last = findLastOccurence(A, B);
		result[0] = first;
		result[1] = last;

		return result;
	}

	private static int findFirstOccurence(int[] A, int B) {
		int index = -1;
		int l = 0, r = A.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (A[mid] == B) {
				index = mid;
				r = mid - 1;
			} else if (A[mid] > B) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return index;
	}

	private static int findLastOccurence(int[] A, int B) {
		int index = -1;
		int l = 0, r = A.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (A[mid] == B) {
				index = mid;
				l = mid + 1;
			} else if (A[mid] > B) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] A = { 5, 7, 7, 8, 8, 10 };
		int[] result = searchRange(A, 8);
		System.out.println(result[0] + " " + result[1]);
	}
}

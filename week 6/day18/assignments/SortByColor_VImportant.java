//Q1. Sort by Color
//Problem Description
//
//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//Note: Using library sort function is not allowed.
//
//
//
//Problem Constraints
//
//1 <= N <= 1000000
//0 <= A[i] <= 2
//
//
//Input Format
//
//First and only argument of input contains an integer array A.
//
//
//Output Format
//
//Return an integer array in asked order
//
//
//Example Input
//
//Input 1 :
//    A = [0 1 2 0 1 2]
//Input 2:
//
//    A = [0]
//
//
//Example Output
//
//Output 1:
//    [0 0 1 1 2 2]
//Output 2:
//
//    [0]
//
//
//Example Explanation
//
//Explanation 1:
//    [0 0 1 1 2 2] is the required order.

package day18.assignments;

public class SortByColor_VImportant {
	public static int[] sortColors(int[] A) {

		int low = 0;
		int mid = 0;
		int high = A.length - 1;
		int temp;

		while (mid <= high) {

			if (A[mid] == 0) {
				temp = A[mid];
				A[mid] = A[low];
				A[low] = temp;
				low++;
				mid++;
			} else if (A[mid] == 1) {
				mid++;
			} else {
				temp = A[high];
				A[high] = A[mid];
				A[mid] = temp;
				high--;
			}
		}

		return A;
	}

	public static void main(String[] args) {
		int[] A = { 0, 1, 2, 0, 1, 2 };

		int[] res = sortColors(A);
		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}
}

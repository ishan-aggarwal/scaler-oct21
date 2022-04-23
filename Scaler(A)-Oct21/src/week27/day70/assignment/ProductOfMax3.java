package week27.day70.assignment;

import java.util.Arrays;

//Q3. Product of Max 3

//Problem Description
//Given an integer array A of size N.
//
//You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.
//
//Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.
//
//
//
//Problem Constraints
//1 <= N <= 105
//0 <= A[i] <= 103
//
//
//
//Input Format
//First and only argument is an integer array A.
//
//
//
//Output Format
//Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.
//
//
//
//Example Input
//Input 1:
//
// A = [1, 2, 3, 4, 5]
//Input 2:
//
// A = [10, 2, 13, 4]
//
//
//Example Output
//Output 1:
//
// [-1, -1, 6, 24, 60]
//Output 2:
//
// [-1, -1, 260, 520]
//
//
//Example Explanation
//Explanation 1:
//
// For i = 1, ans = -1
// For i = 2, ans = -1
// For i = 3, ans = 1 * 2 * 3 = 6
// For i = 4, ans = 2 * 3 * 4 = 24
// For i = 5, ans = 3 * 4 * 5 = 60
//
// So, the output is [-1, -1, 6, 24, 60].
// 
//Explanation 2:
//
// For i = 1, ans = -1
// For i = 2, ans = -1
// For i = 3, ans = 10 * 2 * 13 = 260
// For i = 4, ans = 10 * 13 * 4 = 520
//
// So, the output is [-1, -1, 260, 520].

public class ProductOfMax3 {
	public static int[] solve(int[] A) {
		int heap[] = new int[3];
		int res[] = new int[A.length];
		int mul = 1;
		for (int i = 0; i < 3; i++) {
			heap[i] = A[i];
			mul = mul * A[i];
			res[i] = -1;
		}
		res[2] = mul;
		heapifyDown(heap, 3, 0);
		for (int i = 3; i < A.length; i++) {
			if (A[i] > heap[0]) {
				mul = mul / heap[0];
				mul = mul * A[i];
				heap[0] = A[i];
				heapifyDown(heap, 3, 0);
			}
			res[i] = mul;
		}
		return res;
	}

	private static void heapifyDown(int heap[], int size, int idx) {
		while (idx < size) {
			int min = idx;
			int l = 2 * idx + 1;
			int r = 2 * idx + 2;
			if (l < size && heap[min] > heap[l])
				min = l;
			if (r < size && heap[min] > heap[r])
				min = r;

			if (min == idx) {
				return;
			}

			int temp = heap[idx];
			heap[idx] = heap[min];
			heap[min] = temp;
			idx = min;
		}
	}

//	private static void heapifyDown(int heap[], int size, int idx) {
//
//		if (idx >= size) {
//			return;
//		}
//
//		int min = idx;
//		int l = 2 * idx + 1;
//		int r = 2 * idx + 2;
//		if (l < size && heap[min] > heap[l])
//			min = l;
//		if (r < size && heap[min] > heap[r])
//			min = r;
//
//		if (min == idx) {
//			return;
//		}
//
//		int temp = heap[idx];
//		heap[idx] = heap[min];
//		heap[min] = temp;
//		idx = min;
//		heapifyDown(heap, size, idx);
//	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(solve(A)));
	}

}

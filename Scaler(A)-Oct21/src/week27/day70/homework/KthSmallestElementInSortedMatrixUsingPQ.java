package week27.day70.homework;

import java.util.Collections;
import java.util.PriorityQueue;

//Q4. Kth Smallest Element in a Sorted Matrix

//Problem Description
//Given a sorted matrix of integers A of size N x M and an integer B.
//
//Each of the rows and columns of matrix A is sorted in ascending order, find the Bth smallest element in the matrix.
//
//NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.
//
//
//
//Problem Constraints
//1 <= N, M <= 500
//
//1 <= A[i] <= 109
//
//1 <= B <= N * M
//
//
//
//Input Format
//The first argument given is the integer matrix A.
//The second argument given is an integer B.
//
//
//
//Output Format
//Return the B-th smallest element in the matrix.
//
//
//
//Example Input
//Input 1:
//
// A = [ [9, 11, 15],
//       [10, 15, 17] ] 
// B = 6
//Input 2:
//
// A = [  [5, 9, 11],
//        [9, 11, 13],
//        [10, 12, 15],
//        [13, 14, 16],
//        [16, 20, 21] ]
// B = 12
//
//
//Example Output
//Output 1:
//
// 17
//Output 2:
//
// 16
//
//
//Example Explanation
//Explanation 1:
//
// 6th smallest element in the sorted matrix is 17.
//Explanation 2:
//
// 12th smallest element in the sorted matrix is 16.

public class KthSmallestElementInSortedMatrixUsingPQ {
	public static int solve(int[][] A, int B) {
		// we need MAX HEAP
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int ans = 0;

		// lets add elements into heap
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				int currEle = A[i][j];
				// Add to heap if heap size is less than required size
				if (maxHeap.size() < B) {
					maxHeap.add(currEle);
				} else {
					// check if highest element is > currElem, remove it since we need smallest
					if (maxHeap.peek() > currEle) {
						maxHeap.remove();
						maxHeap.add(currEle);
					}
				}
			}
		}
		if (maxHeap.size() > 0)
			ans = maxHeap.poll();
		return ans;
	}

	public static void main(String[] args) {
		int[][] A = { { 9, 11, 15 }, { 10, 15, 17 } };
		int B = 6;
		System.out.println(solve(A, B));
	}
}

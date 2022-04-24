package week27.day71.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//Q3. Special Median
//Problem Description
//You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:
//
//There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
//There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
//The Median is the middle element in the sorted list of elements. If the number of elements is even then the median will be (sum of both middle elements) / 2.
//
//Return 1 if the array is special else return 0.
//
//NOTE:
//
//For A[0] consider only the median of elements [A[1], A[2], ..., A[N-1]] (as there are no elements to the left of it)
//For A[N-1] consider only the median of elements [A[0], A[1], ...., A[N-2]]
//
//
//Problem Constraints
//1 <= N <= 1000000.
//A[i] is in the range of a signed 32-bit integer.
//
//
//
//Input Format
//The first and only argument is an integer array A.
//
//
//
//Output Format
//Return 1 if the given array is special else return 0.
//
//
//
//Example Input
//Input 1:
//
// A = [4, 6, 8, 4]
//Input 2:
//
// A = [2, 7, 3, 1]
//
//
//Example Output
//Output 1:
//
// 1
//Output 2:
//
// 0
//
//
//Example Explanation
//Explantion 1:
//
// Here, 6 is equal to the median of [8, 4].
//Explanation 2:
//
// No element satisfies any condition.

public class SpecialMedian {
	public static int solve(ArrayList<Integer> A) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		maxHeap.add(A.get(0));
		int median = maxHeap.peek();
		for (int i = 1; i < A.size(); i++) {
			if (median == A.get(i)) {
				return 1;
			}
			if (!maxHeap.isEmpty() && A.get(i) < median) {
				maxHeap.add(A.get(i));
			} else {
				minHeap.add(A.get(i));
			}
			if (maxHeap.size() - minHeap.size() > 1) {
				minHeap.add(maxHeap.poll());
			} else if (minHeap.size() - maxHeap.size() > 1) {
				maxHeap.add(minHeap.poll());
			}
			if (maxHeap.size() == minHeap.size()) {
				median = (maxHeap.peek() + minHeap.peek()) / 2;
			} else {
				median = maxHeap.peek();
			}
		}

		maxHeap.removeAll(maxHeap);
		minHeap.removeAll(minHeap);

		maxHeap.add(A.get(A.size() - 1));
		median = maxHeap.peek();
		for (int i = A.size() - 2; i >= 0; i--) {
			if (median == A.get(i)) {
				return 1;
			}
			if (!maxHeap.isEmpty() && A.get(i) < median) {
				maxHeap.add(A.get(i));
			} else {
				minHeap.add(A.get(i));
			}
			if (maxHeap.size() - minHeap.size() > 1) {
				minHeap.add(maxHeap.poll());
			} else if (minHeap.size() - maxHeap.size() > 1) {
				maxHeap.add(minHeap.poll());
			}
			if (maxHeap.size() == minHeap.size()) {
				median = (maxHeap.peek() + minHeap.peek()) / 2;
			} else {
				median = maxHeap.peek();
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] a = { 4, 6, 8, 4 };
		ArrayList<Integer> A = new ArrayList<>();
		for (int e : a)
			A.add(e);

		System.out.println(solve(A));
	}
}

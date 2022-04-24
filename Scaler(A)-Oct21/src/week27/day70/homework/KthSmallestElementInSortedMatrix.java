package week27.day70.homework;

import java.util.ArrayList;
import java.util.List;

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

public class KthSmallestElementInSortedMatrix {

	public static void main(String[] args) {
		int[][] A = { { 9, 11, 15 }, { 10, 15, 17 } };
		int B = 6;
		System.out.println(solve(A, B));
	}

	public static int solve(int[][] A, int K) {
		int answer = -1;
		MinHeap<Pair> minHeap = new MinHeap<Pair>();
		int rowsCount = A.length;
		int colsCount = A[0].length;

		// maintain the heap of size N = no of rows
		int i = 0;
		while (i < rowsCount) {
			Pair pair = new Pair(A[i][0], i, 0);
			i++;
			minHeap.insert(pair);
		}
		// extract minimum K-1 times
		while (K > 1) {
			// find min and insert the next element from same array
			Pair currMin = minHeap.getMinimum();
			if (currMin.j == colsCount - 1) {
				// no more elements to from current row/sorted array
			} else {
				Pair nextEleInSameRow = new Pair(A[currMin.i][currMin.j + 1], currMin.i, currMin.j + 1);
				minHeap.insert(nextEleInSameRow);
			}
			K--;
		}
		// extract last element from heap which is Bth smallest
		Pair KthMin = minHeap.getMinimum();
		answer = KthMin.key;
		return answer;
	}

	static class Pair implements Comparable<Pair> {
		int key;
		int i;
		int j;

		public Pair(int key, int i, int j) {
			this.key = key;
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Pair o2) {
			if (this.key > o2.key)
				return 1;
			else if (this.key < o2.key)
				return -1;
			return 0;
		}
	}

	static class MinHeap<T extends Comparable<T>> {
		List<T> heap;

		public MinHeap() {
			heap = new ArrayList<T>();
		}

		public int size() {
			return heap.size();
		}

		public List<T> getHeap() {
			return heap;
		}

		public boolean isEmpty() {
			if (heap.size() == 0) {
				return true;
			}
			return false;
		}

		public void insert(T x) {

			heap.add(x);
			int i = this.heap.size() - 1;
			while (i > 0) {
				int parentIndex = (i - 1) / 2;
				if (heap.get(i).compareTo(heap.get(parentIndex)) < 0) {
					swap(i, parentIndex);
					i = parentIndex;
				} else {
					return;
				}
			}
		}

		public T getMinimum() {
			T x = null;
			if (!isEmpty()) {
				x = heap.get(0);
				// swap last element and x
				swap(0, heap.size() - 1);
				heap.remove(heap.size() - 1);

				int i = 0;
				while ((2 * i) + 1 < heap.size()) {
					int leftChildIndex = (2 * i) + 1;
					int rightChildIndex = (2 * i) + 2;
					T min = null;

					// find minimum out of 3
					min = heap.get(i).compareTo(heap.get(leftChildIndex)) < 0 ? heap.get(i) : heap.get(leftChildIndex);
					if (rightChildIndex < heap.size()) {
						min = heap.get(rightChildIndex).compareTo(min) < 0 ? heap.get(rightChildIndex) : min;
					}

					if (min == heap.get(i)) {
						break;
					} else if (min == heap.get(leftChildIndex)) {
						swap(i, leftChildIndex);
						i = leftChildIndex;
					} else if (rightChildIndex < heap.size() && min == heap.get(rightChildIndex)) {
						swap(i, rightChildIndex);
						i = rightChildIndex;
					}
				}

			}
			return x;
		}

		public T peekMin() {
			return heap.get(0);
		}

		private void swap(int i, int j) {
			T temp = heap.get(i);
			heap.set(i, heap.get(j));
			heap.set(j, temp);
		}
	}

}

package week27.day70.assignment;

import java.util.PriorityQueue;

//Q4. Maximum array sum after B negations

//Problem Description
//Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].
//
//You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.
//
//
//
//Problem Constraints
//1 <= length of the array <= 5*105
//1 <= B <= 5 * 106
//-100 <= A[i] <= 100
//
//
//
//Input Format
//The first argument given is an integer array A.
//The second argument given is an integer B.
//
//
//
//Output Format
//Return an integer denoting the maximum array sum after B modifications.
//
//
//
//Example Input
//Input 1:
//
// A = [24, -68, -29, -9, 84]
// B = 4
//Input 2:
//
// A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
// B = 10
//
//
//Example Output
//Output 1:
//
// 196
//Output 2:
//
// 362
//
//
//Example Explanation
//Explanation 1:
//
// Final array after B modifications = [24, 68, 29, -9, 84]
//Explanation 2:
//
// Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]

public class MaxArraySumAfterBNegations {

	public static int solve1(int[] A, int B) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		int res = 0;

		// add all the elements to min PQ
		for (int a : A) {
			pQueue.add(a);
		}

		// perform inserting negation B times in PQ
		while (B > 0) {
			pQueue.add(pQueue.poll() * -1);
			B--;
		}

		// while the size for pq is not zero
		// extract the elements and add to result
		while (pQueue.size() != 0) {
			res = res + pQueue.poll();
		}
		return res;
	}

	public static int solve(int[] A, int B) {
		// Idea: build a min heap and for every iteration remove min and insert its
		// negation into heap
		// after all the iteration is complete. extract every element from heap and
		// return total sum.

		MinHeap heap = new MinHeap(A.length);
		// build heap
		for (int i = 0; i < A.length; i++) {
			heap.insert(A[i]);
		}
		// perform B operation
		for (int i = 1; i <= B; i++) {
			int min = heap.getMinimum();
			int x = -min;
			heap.insert(x);
		}

		// get total sum of remaining elements in heap
		int sum = 0;
		while (!heap.isEmpty()) {
			sum += heap.getMinimum();
		}
		return sum;
	}

	static class MinHeap {
		int[] heap;
		int size;

		public MinHeap(int size) {
			this.heap = new int[size];
			this.size = 0;
		}

		public int getSize() {
			return size;
		}

		public int[] getHeap() {
			return this.heap;
		}

		public boolean isEmpty() {
			if (this.size == 0) {
				return true;
			}
			return false;
		}

		public boolean isFull() {
			if (this.size == heap.length) {
				return true;
			}
			return false;
		}

		// proculate up/ shift up
		// move min element to root/parent
		public void insert(int x) {
			// insert x into last position
			if (!isFull()) {
				heap[size] = x;
				size++;

				int i = size - 1;
				while (i > 0) {
					int parentIndex = (i - 1) / 2;
					if (heap[i] < heap[parentIndex]) {
						swap(i, parentIndex);
						i = parentIndex;
					} else {
						return;
					}
				}
			}
		}

		public int getMinimum() {
			int x = -1;
			if (!isEmpty()) {
				x = heap[0];
				// swap last element and x
				swap(0, size - 1);
				heap[size - 1] = -1;
				size--;

				int i = 0;

				while (i < size) {
					int min = i;
					int l = 2 * i + 1;
					int r = 2 * i + 2;
					if (l < size && heap[l] < heap[min]) {
						min = l;
					}
					if (r < size && heap[r] < heap[min]) {
						min = r;
					}
					if (min == i) {
						break;
					}

					swap(i, min);
					i = min;
				}
			}
			return x;
		}

		private void swap(int i, int j) {
			int temp = heap[i];
			heap[i] = heap[j];
			heap[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] A = { 24, -68, -29, -9, 84 };
		int B = 4;
		System.out.println(solve(A, B));
		System.out.println(solve1(A, B));
	}
}

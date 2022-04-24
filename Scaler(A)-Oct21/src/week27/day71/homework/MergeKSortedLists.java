package week27.day71.homework;

import java.util.ArrayList;
import java.util.List;

//Q4. Merge K Sorted Lists
//Problem Description
//Given a list containing head pointers of N sorted linked lists.
//Merge these given sorted linked lists and return them as one sorted list.
//
//
//
//Problem Constraints
//1 <= total number of elements in given linked lists <= 100000
//
//
//
//Input Format
//The first and only argument is a list containing N head pointers.
//
//
//
//Output Format
//Return a pointer to the head of the sorted linked list after merging all the given linked lists.
//
//
//
//Example Input
//Input 1:
//
// 1 -> 10 -> 20
// 4 -> 11 -> 13
// 3 -> 8 -> 9
//Input 2:
//
// 10 -> 12
// 13
// 5 -> 6
//
//
//Example Output
//Output 1:
//
// 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
//Output 2:
//
// 5 -> 6 -> 10 -> 12 ->13
//
//
//Example Explanation
//Explanation 1:
//
// The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
//Explanation 2:
//
// The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.

public class MergeKSortedLists {

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// Java | Merge K Sorted Lists | using Min Heap custom implementation
	// Approach: using Min Heap to sort the K lists
	// TC: O(N) - to iterate each node of a given list
	// SC: O(N * log K) - the size of the heap will be at max K at any point
	public ListNode mergeKLists(ArrayList<ListNode> list) {

		// Min Heap of size K where (K = size of list)
		MinHeap<NodeItem> minHeap = new MinHeap<NodeItem>();

		// store heads of all lists into heap
		for (ListNode node : list) {
			minHeap.insert(new NodeItem(node.val, node));
		}

		// initialize head and temp pointers
		ListNode head = null;
		ListNode temp = head;

		// get min element from heap and append to next of result linked list
		while (!minHeap.isEmpty()) {
			// get minimum node from heap
			ListNode x = minHeap.getMinimum().node;

			// add next available node of the current minimum node into the heap
			ListNode nextNode = x.next;
			if (nextNode != null) {
				minHeap.insert(new NodeItem(nextNode.val, nextNode));
			}

			// attach the node x at end to the result list
			if (head == null) {
				head = x;
				temp = head;
			} else {
				temp.next = x;
				temp = temp.next;
			}
		}
		return head;
	}

	// custom node type which stores value and linked list node
	class NodeItem implements Comparable<NodeItem> {
		int value;
		ListNode node;

		public NodeItem(int value, ListNode node) {
			this.value = value;
			this.node = node;
		}

		@Override
		public int compareTo(NodeItem o) {
			return this.value - o.value;
		}
	}

	// Min Heap implementation
	public class MinHeap<T extends Comparable<T>> {
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

	public static void main(String[] args) {

	}
}

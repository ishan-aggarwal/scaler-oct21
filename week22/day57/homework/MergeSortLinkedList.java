package day57.homework;

//Q1. Sort List

//Problem Description
//
//Sort a linked list, A in O(n log n) time using constant space complexity.
//
//
//
//Problem Constraints
//
//0 <= |A| = 105
//
//
//
//Input Format
//
//The first and the only arugment of input contains a pointer to the head of the linked list, A.
//
//
//
//Output Format
//
//Return a pointer to the head of the sorted linked list.
//
//
//
//Example Input
//
//Input 1:
//
//A = [3, 4, 2, 8]
//Input 2:
//
//A = [1]
//
//
//Example Output
//
//Output 1:
//
//[2, 3, 4, 8]
//Output 2:
//
//[1]
//
//
//Example Explanation
//
//Explanation 1:
//
// The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
//Explanation 2:
//
// The sorted form of [1] is [1].

public class MergeSortLinkedList {

	// Definition for singly-linked list.
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode sortList(ListNode A) {
		return mergeSort(A);
	}

	// divide and conquer
	public static ListNode mergeSort(ListNode A) {

		// base case where the list is null or has just one node
		if (A == null || A.next == null) {
			return A;
		}

		// find the first mid node
		ListNode mid = findFirstMid(A);

		// start of the second sub list
		ListNode h2 = mid.next;

		// mark the end of first list so that it does not turn to be an infinite
		// use-case
		mid.next = null;

		// call merge sort on first sub-list
		ListNode l1 = mergeSort(A);

		// call merge sort on second sub-list
		ListNode l2 = mergeSort(h2);

		// finally call the merge function to merge the two sorted lists together
		return merge(l1, l2);
	}

	// find the first mid node of the linked list
	public static ListNode findFirstMid(ListNode A) {
		if (A == null || A.next == null) {
			return A;
		}
		ListNode sp = A;
		ListNode fp = A;
		while (fp != null && fp.next != null && fp.next.next != null) {
			sp = sp.next;
			fp = fp.next.next;
		}
		return sp;
	}

	// merge two sorted lists
	public static ListNode merge(ListNode h1, ListNode h2) {
		if (h1 == null && h2 == null) {
			return null;
		} else if (h1 == null) {
			return h2;
		} else if (h2 == null) {
			return h1;
		}

		ListNode t1 = h1;
		ListNode t2 = h2;
		ListNode C = null;

		if (t1.val < t2.val) {
			C = t1;
			t1 = t1.next;
		} else {
			C = t2;
			t2 = t2.next;
		}

		ListNode t3 = C;

		while (t1 != null && t2 != null) {
			if (t1.val < t2.val) {
				t3.next = t1;
				t1 = t1.next;
			} else {
				t3.next = t2;
				t2 = t2.next;
			}
			t3 = t3.next;
		}

		if (t1 == null) {
			t3.next = t2;
		}
		if (t2 == null) {
			t3.next = t1;
		}

		return C;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		ListNode head4 = new ListNode(4);
		ListNode head5 = new ListNode(5);

		head.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;

		ListNode cycleStart = sortList(head);
		System.out.println(cycleStart);
	}
}

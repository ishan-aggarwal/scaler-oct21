package day58.homework;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {

	// Definition for singly-linked list.
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeKLists(ArrayList<ListNode> a) {
		return mergeSortAL(a, 0, a.size() - 1);
	}

	// divide and concur, use concept of merge sort to do it
	public ListNode mergeSortAL(List<ListNode> a, int left, int right) {

		if (left == right) {
			return a.get(left);
		}

		int mid = left + ((right - left) >> 1);
		ListNode l1 = mergeSortAL(a, left, mid);
		ListNode l2 = mergeSortAL(a, mid + 1, right);
		return merge(l1, l2);

	}

	// merge 2 ListNodes in sorted order
	public ListNode merge(ListNode left, ListNode right) {

		ListNode dummy = new ListNode(-1);
		ListNode curr = dummy; // currL = left, currR = right,

		while (left != null && right != null) {
			if (left.val <= right.val) {
				curr.next = left;
				left = left.next;
			} else {
				curr.next = right;
				right = right.next;
			}
			curr = curr.next;
		}
		curr.next = (left == null) ? right : left;
		return dummy.next;
	}

}

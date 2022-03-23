package day56.assignment;

//Problem Description
//
// Insert In Sorted Linked List

public class InsertInSortedLinkedList {

	/**
	 * Definition for singly-linked list.
	 */
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode insertInSortedLL(ListNode head, int k) {

		ListNode newNode = new ListNode(k);

		// if head is null
		if (head == null) {
			return newNode;
		}

		// edge case-1
		// if node being inserted at start
		if (k <= head.val) {
			newNode.next = head;
			head = newNode;
			return head;
		}

		ListNode temp = head;
		while (temp.next != null && temp.next.val < k) {
			temp = temp.next;
		}

		newNode.next = temp.next;
		temp.next = newNode;
		return head;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(20);
		ListNode head3 = new ListNode(30);
		ListNode head4 = new ListNode(40);
		ListNode head5 = new ListNode(50);

		head.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;

		ListNode updatedList = insertInSortedLL(head, 25);
		System.out.println(updatedList);
	}
}

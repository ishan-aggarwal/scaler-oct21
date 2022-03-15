package day57.assignment;

//Q2. Remove Loop from Linked List
//Problem Description
//
//Given a linked list which contains some loop.
//
//You need to find the node, which creates a loop, and break it by making the node point to NULL.
//
//
//
//Problem Constraints
//
//1 <= number of nodes <= 1000
//
//
//
//Input Format
//
//Only argument is the head of the linked list.
//
//
//
//Output Format
//
//return the head of the updated linked list.
//
//
//
//Example Input
//
//Input 1:
//
// 
//1 -> 2
//^    |
//| - - 
//Input 2:
//
//3 -> 2 -> 4 -> 5 -> 6
//          ^         |
//          |         |    
//          - - - - - -
//
//
//Example Output
//
//Output 1:
//
// 1 -> 2 -> NULL
//Output 2:
//
// 3 -> 2 -> 4 -> 5 -> 6 -> NULL
//
//
//Example Explanation
//
//Explanation 1:
//
// Chain of 1->2 is broken.
//Explanation 2:
//
// Chain of 4->6 is broken.

public class RemoveLoopFomLinkedList {

	// Definition for singly-linked list
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode solve(ListNode A) {

		// base case
		if (A == null) {
			return null;
		}

		// take two pointers
		ListNode sp = A;
		ListNode fp = A;

		while (fp != null && fp.next != null) {
			sp = sp.next;
			fp = fp.next.next;

			if (sp == fp) {
				break;
			}
		}

		if (fp == null && fp.next == null) {
			return null;
		}

		ListNode t1 = sp;
		ListNode t2 = A;
		ListNode prev = null;

		while (t1 != t2) {
			prev = t1;
			t1 = t1.next;
			t2 = t2.next;
		}

		prev.next = null;
		return A;
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

		ListNode removeLoop = solve(head);
		System.out.println(removeLoop);
	}
}

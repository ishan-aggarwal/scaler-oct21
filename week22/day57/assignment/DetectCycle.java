package day57.assignment;

//Q1. List Cycle

//Problem Description
//
//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//Try solving it using constant additional space.
//
//Example:
//
//Input: 
//
//                  ______
//                 |     |
//                 \/    |
//        1 -> 2 -> 3 -> 4
//
//Return the node corresponding to node 3. 

public class DetectCycle {

	// Definition for singly-linked list.
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode detectCycle(ListNode a) {
		// check if head is null
		if (a == null) {
			return null;
		}

		// take two pointers to move
		// slow pointer and fast pointer
		ListNode sp = a;
		ListNode fp = a;

		// check if fast pointer becomes null or its next becomes null
		while (fp != null && fp.next != null) {

			// move the slow pointer by 1
			sp = sp.next;
			// move the fast pointer by 2
			fp = fp.next.next;
			// check if slow and fast pointer are equal break
			if (fp == sp) {
				break;
			}
		}

		// check terminate condition for while loop...
		// if it is because of null return null
		if (fp == null || fp.next == null) {
			return null;
		}

		// otherwise detect the start of the cycle using
		// two fresh pointers
		ListNode t1 = a;
		ListNode t2 = sp;

		while (t1 != t2) {
			t1 = t1.next;
			t2 = t2.next;
		}

		return t1;
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

		ListNode cycleStart = detectCycle(head);
		System.out.println(cycleStart);
	}
}

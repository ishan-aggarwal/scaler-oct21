package day57.assignment;

import day57.assignment.DetectCycle.ListNode;

//Q3. Reorder List

//Problem Description
//
//Given a singly linked list A
//
// A: A0 → A1 → … → An-1 → An 
//reorder it to:
//
// A0 → An → A1 → An-1 → A2 → An-2 → … 
//You must do this in-place without altering the nodes' values.
//
//
//
//Problem Constraints
//
//1 <= |A| <= 106
//
//
//
//Input Format
//
//The first and the only argument of input contains a pointer to the head of the linked list A.
//
//
//
//Output Format
//
//Return a pointer to the head of the modified linked list.
//
//
//
//Example Input
//
//Input 1:
//
// A = [1, 2, 3, 4, 5] 
//Input 2:
//
// A = [1, 2, 3, 4] 
//
//
//Example Output
//
//Output 1:
//
// [1, 5, 2, 4, 3] 
//Output 2:
//
// [1, 4, 2, 3] 
//
//
//Example Explanation
//
//Explanation 1:
//
// The array will be arranged to [A0, An, A1, An-1, A2].
//Explanation 2:
//
// The array will be arranged to [A0, An, A1, An-1, A2].

public class ReorderLinkedList {

	// Definition for singly-linked list
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode reorderList(ListNode A) {
		// check for base case
		if (A == null || A.next == null || A.next.next == null) {
			return A;
		}

		// find the first mid node
		ListNode sp = findFirstMid(A);

		// sp points to the mid element of the list
		ListNode secondPart = sp.next;
		// set sp next to null now
		sp.next = null;

		// reverse second part of the linked list
		ListNode h2 = reverseLinkedList(secondPart);

		// at this point the secondPart of the list is reversed
		// with h2 pointing to the head of the list with A(n)

		// finally join the two linked lists as needed
		ListNode t1 = A;
		ListNode t2 = h2;
		ListNode t1NextNode = t1;
		ListNode t2NextNode = t2;

		int count = 0;
		while (t1 != null && t2 != null) {

			if (count % 2 == 0) {
				t1NextNode = t1.next;
				t1.next = t2;
				// t2 = t2.next;
				t1 = t1NextNode;
			} else {
				t2NextNode = t2.next;
				t2.next = t1;
				// t1 = t1.next;
				t2 = t2NextNode;
			}
			count++;
		}
		return A;
	}

	private static ListNode reverseLinkedList(ListNode secondPart) {
		// reverse second part of the list
		ListNode h2 = null;
		ListNode temp = secondPart;
		ListNode nextNode = secondPart;

		while (nextNode != null) {
			nextNode = temp.next;
			temp.next = h2;
			h2 = temp;
			temp = nextNode;
		}
		return h2;
	}

	private static ListNode findFirstMid(ListNode A) {
		ListNode sp = A;
		ListNode fp = A;

		// this condition is written to find the first mid point in case of even
		// elements
		while (fp != null && fp.next != null && fp.next.next != null) {
			sp = sp.next;
			fp = fp.next.next;
		}
		return sp;
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

		ListNode updatedList = reorderList(head);
		System.out.println(updatedList);
	}
}

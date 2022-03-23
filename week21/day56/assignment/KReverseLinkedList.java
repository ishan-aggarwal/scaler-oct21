package day56.assignment;

import day56.assignment.ReverseFirstKNodesLinkedList.ListNode;

//Q2. K reverse linked list

//Problem Description
//Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.
//
//
//
//Problem Constraints
//1 <= |A| <= 103
//
//B always divides A
//
//
//
//Input Format
//The first argument of input contains a pointer to the head of the linked list.
//
//The second arugment of input contains the integer, B.
//
//
//
//Output Format
//Return a pointer to the head of the modified linked list.
//
//
//
//Example Input
//Input 1:
//
// A = [1, 2, 3, 4, 5, 6]
// B = 2
//Input 2:
//
// A = [1, 2, 3, 4, 5, 6]
// B = 3
//
//
//Example Output
//Output 1:
//
// [2, 1, 4, 3, 6, 5]
//Output 2:
//
// [3, 2, 1, 6, 5, 4]
//
//
//Example Explanation
//Explanation 1:
//
// For the first example, the list can be reversed in groups of 2.
//    [[1, 2], [3, 4], [5, 6]]
// After reversing the K-linked list
//    [[2, 1], [4, 3], [6, 5]]
//Explanation 2:
//
// For the second example, the list can be reversed in groups of 3.
//    [[1, 2, 3], [4, 5, 6]]
// After reversing the K-linked list
//    [[3, 2, 1], [6, 5, 4]]

public class KReverseLinkedList {

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

	public ListNode reverseList(ListNode head, int k) {

		// base case
		if (head == null || k == 0)
			return head;

		// Assumption: Returns the head of the new LL after
		// reversing every group of B nodes in the LL starting
		// from A (head)

		ListNode nextNode = head;
		ListNode h3 = head;
		ListNode h2 = null;
		int tk = k;

		// reverse k nodes
		// h1 != null - edge case
		while (k > 0 && nextNode != null) {
			ListNode temp = nextNode;
			nextNode = nextNode.next;
			temp.next = null; // not needed
			temp.next = h2;
			h2 = temp;
			k--;
		}

		h3.next = reverseList(nextNode, tk);
		return h2;
	}

}

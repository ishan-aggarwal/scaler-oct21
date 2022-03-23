package day56.assignment;

//Q3. Middle element of linked list

//Problem Description
//
//Given a linked list of integers. Find and return the middle element of the linked list.
//
//NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.
//
//
//
//Problem Constraints
//
//1 <= length of the linked list <= 100000
//
//1 <= Node value <= 109
//
//
//
//Input Format
//
//The only argument given head pointer of linked list.
//
//
//
//Output Format
//
//Return the middle element of the linked list.
//
//
//
//Example Input
//
//Input 1:
//
// 1 -> 2 -> 3 -> 4 -> 5
//Input 2:
//
// 1 -> 5 -> 6 -> 2 -> 3 -> 4
//
//
//Example Output
//
//Output 1:
//
// 3
//Output 2:
//
// 2
//
//
//Example Explanation
//
//Explanation 1:
//
// The middle element is 3.
//Explanation 2:
//
// The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.

public class FirstMiddleElementOfLinkedList {

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

	// method to find 1st element of linked list
	public static int solve(ListNode A) {

		// take two pointers
		ListNode sp = A;
		ListNode fp = A;

		// use fp to iterate over the list
		while (fp != null && fp.next != null & fp.next.next != null) {
			sp = sp.next;
			fp = fp.next.next;
		}

		// sp will point to the middle element
		return sp.val;
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

		int result = solve(head);
		System.out.println(result);

	}
}

package day56.assignment;

//Q5. Reverse Linked List

//Problem Description
//
//You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.
//
//NOTE: You have to do it in-place and in one-pass.
//
//
//
//Problem Constraints
//
//1 <= Length of linked list <= 105
//
//Value of each node is within the range of a 32-bit integer.
//
//
//
//Input Format
//
//First and only argument is a linked-list node A.
//
//
//
//Output Format
//
//Return a linked-list node denoting the head of the reversed linked list.
//
//
//
//Example Input
//
//Input 1:
//
// A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL 
//Input 2:
//
// A = 3 -> NULL 
//
//
//Example Output
//
//Output 1:
//
// 5 -> 4 -> 3 -> 2 -> 1 -> NULL 
//Output 2:
//
// 3 -> NULL 
//
//
//Example Explanation
//
//Explanation 1:
//
// The linked list has 5 nodes. After reversing them, the list becomes : 5 -> 4 -> 3 -> 2 -> 1 -> NULL 
//Expalantion 2:
//
// The linked list consists of only a single node. After reversing it, the list becomes : 3 -> NULL 

public class ReverseLinkedList {

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

	public static ListNode reverseList(ListNode A) {

		// why do we need three pointers
		// we need to take one element out from original list (pointed by temp)
		// once temp is extracted; in order to preserve the next node we need a pointer
		// (nextNode)
		// add that element at the start of an empty list (pointed by h2 pointer)
		// and which will eventually result in reversal of original list

		// new list is empty at the start
		ListNode h2 = null;

		// point the pointers to the start of A
		ListNode nextNode = A;
		ListNode temp = A;

		// while nextNode is not null
		while (nextNode != null) {

			// move nextNode first to save it for future
			nextNode = nextNode.next;

			// add temp to the start of list2 (h2)
			temp.next = h2;

			// adjust the head of list2 (h2)
			h2 = temp;

			// move temp to nextNode as well
			temp = nextNode;
		}

		// finally return the head of list2 (h2)
		return h2;
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

		ListNode updatedList = reverseList(head);
		System.out.println(updatedList);

	}
}

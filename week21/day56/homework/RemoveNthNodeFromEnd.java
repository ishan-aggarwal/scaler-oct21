package day56.homework;

//Q1. Remove Nth Node from List End

//Problem Description
//
//Given a linked list A, remove the B-th node from the end of list and return its head.
//
//For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.
//
//NOTE: If B is greater than the size of the list, remove the first node of the list.
//
//NOTE: Try doing it using constant additional space.
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
//The first argument of input contains a pointer to the head of the linked list.
//
//The second argument of input contains the integer B.
//
//
//
//Output Format
//
//Return the head of the linked list after deleting the B-th element from the end.
//
//
//
//Example Input
//
//Input 1:
//
//A = [1, 2, 3, 4, 5]
//B = 2
//Input 2:
//
//A = [1]
//B = 1
//
//
//Example Output
//
//Output 1:
//
//[1, 2, 3, 5]
//Output 2:
//
// [] 
//
//
//Example Explanation
//
//Explanation 1:
//
//In the first example, 4 is the second last element.
//Explanation 2:
//
//In the second example, 1 is the first and the last element.

public class RemoveNthNodeFromEnd {

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

	public static ListNode removeNthFromEnd(ListNode A, int B) {

		ListNode ptr1 = A;
		ListNode ptr2 = A;
		ListNode previous = A;

		// Keep moving the ptr1 B times
		while (B > 0 && ptr1.next != null) {
			ptr1 = ptr1.next;
			B--;
		}

		if (B > 0) {
			return A.next;
		}

		// Need to keep ptr2 at 2nd node and previous behind it.
		ptr2 = ptr2.next;
		while (ptr1.next != null) {
			ptr1 = ptr1.next;
			previous = ptr2;
			ptr2 = ptr2.next;
		}

		// The ptr2 will be at Bth location from end now skip it
		previous.next = ptr2.next;
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

		ListNode updatedList = removeNthFromEnd(head, 8);
		System.out.println(updatedList);
	}
}

package day56.homework;

//Q2. Remove Duplicates from Sorted List

//Problem Description
//
//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//
//
//Problem Constraints
//
//0 <= length of linked list <= 106
//
//
//
//Input Format
//
//First argument is the head pointer of the linked list.
//
//
//
//Output Format
//
//Return the head pointer of the linked list after removing all duplicates.
//
//
//
//Example Input
//
//Input 1:
//
// 1->1->2
//Input 2:
//
// 1->1->2->3->3
//
//
//Example Output
//
//Output 1:
//
// 1->2
//Output 2:
//
// 1->2->3
//
//
//Example Explanation
//
//Explanation 1:
//
// Each element appear only once in 1->2.

public class RemoveDuplicatesFromSortedList {

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

	public static ListNode deleteDuplicates(ListNode A) {
		ListNode temp = A;
		while (temp != null) {
			if (temp.next != null && temp.val == temp.next.val) {
				// if first node (head) is repeated
				// move head to its next
				// also point temp to latest head and continue
				if (temp == A) {
					A = A.next;
					temp = A;
					continue;
				} else { // simply ignore the next node by pointing temp next to temp next next
					temp.next = temp.next.next;
				}
			} else { // in case the data is not repeated simply increase temp
				temp = temp.next;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(2);
		ListNode head4 = new ListNode(3);
		ListNode head5 = new ListNode(3);

		head.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;

		ListNode updatedList = deleteDuplicates(head);
		System.out.println(updatedList);

	}
}

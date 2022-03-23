package day58.homework;

//Q1. Palindrome List

//Problem Description
//Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
//
//
//
//Problem Constraints
//1 <= |A| <= 105
//
//
//
//Input Format
//The first and the only argument of input contains a pointer to the head of the given linked list.
//
//
//
//Output Format
//Return 0, if the linked list is not a palindrome.
//
//Return 1, if the linked list is a palindrome.
//
//
//
//Example Input
//Input 1:
//
//A = [1, 2, 2, 1]
//Input 2:
//
//A = [1, 3, 2]
//
//
//Example Output
//Output 1:
//
// 1 
//Output 2:
//
// 0 
//
//
//Example Explanation
//Explanation 1:
//
// The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
//Explanation 2:
//
// The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].

public class PalindromeList {

	// Definition for singly-linked list.
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static int lPalin(ListNode A) {

		ListNode curr = A;
		// find first mid node of the linked list
		ListNode mid = getFirstMiddleElementOfList(curr);

		// identify start of 2nd part of the list
		ListNode start = mid.next;

		// set end of 1st part of list
		mid.next = null;

		// reverse the 2nd sub-list
		ListNode h2 = reverseList(start);

		// initialize the pointers for comparison
		ListNode curr2 = h2;
		curr = A;

		while (curr != null && curr2 != null && curr != curr2) {
			// immediately return false in case data is different
			if (curr2.val != curr.val) {
				return 0;
			}
			curr = curr.next;
			curr2 = curr2.next;
		}

		// if we have reached the end of the list return true
		return 1;
	}

	private static ListNode getFirstMiddleElementOfList(ListNode head) {
		ListNode sp = head;
		ListNode fp = head;
		while (fp != null && fp.next != null && fp.next.next != null) {
			sp = sp.next;
			fp = fp.next.next;
		}
		return sp;
	}

	private static ListNode reverseList(ListNode head) {
		ListNode h2 = null;
		ListNode temp = head;
		ListNode nNode = head;
		while (nNode != null) {
			nNode = nNode.next;
			temp.next = h2;
			h2 = temp;
			temp = nNode;
		}
		return h2;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(1);
		ListNode head3 = new ListNode(6);
		ListNode head4 = new ListNode(4);
		ListNode head5 = new ListNode(1);

		head.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;

		System.out.println(lPalin(head));
	}
}

package day57.homework;

import day57.homework.MergeSortLinkedList.ListNode;

//Q2. Merge Two Sorted Lists

//Problem Description
//
//Merge two sorted linked lists A and B and return it as a new list.
//
//The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.
//
//
//
//Problem Constraints
//
//0 <= |A|, |B| <= 105
//
//
//
//Input Format
//
//The first argument of input contains a pointer to the head of linked list A.
//
//The second argument of input contains a pointer to the head of linked list B.
//
//
//
//Output Format
//
//Return a pointer to the head of the merged linked list.
//
//
//
//Example Input
//
//Input 1:
//
// A = 5 -> 8 -> 20
// B = 4 -> 11 -> 15
//Input 2:
//
// A = 1 -> 2 -> 3
// B = Null
//
//
//Example Output
//
//Output 1:
//
// 4 -> 5 -> 8 -> 11 -> 15 -> 20
//Output 2:
//
// 1 -> 2 -> 3
//
//
//Example Explanation
//
//Explanation 1:
//
// Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20 
//Explanation 2:
//
// We don't need to merge as B is empty. 

public class MergeTwoSortedLists {

	// Definition for singly-linked list.
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode mergeTwoLists(ListNode A, ListNode B) {
		if (A == null && B == null) {
			return null;
		} else if (A == null) {
			return B;
		} else if (B == null) {
			return A;
		}

		ListNode C = null;
		if (A.val < B.val) {
			C = A;
			A = A.next;
		} else {
			C = B;
			B = B.next;
		}

		ListNode temp = C;
		while (B != null && A != null) {
			if (A.val < B.val) {
				temp.next = A;
				A = A.next;
			} else {
				temp.next = B;
				B = B.next;
			}
			temp = temp.next;
		}
		if (A == null) {
			temp.next = B;
		}
		if (B == null) {
			temp.next = A;
		}
		return C;
	}

	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		ListNode head4 = new ListNode(4);
		ListNode head5 = new ListNode(5);

		headA.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;

		ListNode headB = new ListNode(10);
		headB.next = null;

		ListNode mergedLists = mergeTwoLists(headA, headB);
		System.out.println(mergedLists);
	}
}

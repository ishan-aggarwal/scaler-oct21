package day56.assignment;

//Q1. Delete middle node of a Linked List

//Given a singly linked list, delete middle of the linked list.
//
//For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5
//
//If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
//
//For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
//
//Return the head of the linked list after removing the middle node.
//
//If the input linked list has 1 node, then this node should be deleted and a null node should be returned.
//
//
//Input Format
//
//The only argument given is the node pointing to the head node of the linked list

public class DeleteMiddleOfLinkedList {

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

	public static ListNode solve(ListNode A) {

		// take two pointers slow and fast
		ListNode sp = A;
		ListNode fp = A;

		// take a previous pointer
		ListNode prev = null;

		// base case with no node or single node
		if (fp == null || fp.next == null) {
			return null;
		}

		// use fp to iterate over the list
		while (fp != null && fp.next != null) {
			// previous pointing to previous of slow pointer
			prev = sp;
			// move slow pointer by 1
			sp = sp.next;
			// move fast pointer by 2
			fp = fp.next.next;
		}

		// in order to remove the node pointed by sp
		prev.next = sp.next;
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

		ListNode updatedList = solve(head);
		System.out.println(updatedList);
	}
}

package day56.assignment;

//Q6. Linked-List
//Problem Description
//Design and implement a Linked List data structure.
//A node in a linked list should have the following attributes - an integer value and a pointer to the next node. It should support the following operations:
//
//insert_node(position, value) - To insert the input value at the given position in the linked list.
//delete_node(position) - Delete the value at the given position from the linked list.
//print_ll() - Print the entire linked list, such that each element is followed by a single space.
//Note:
//
//If an input position does not satisfy the constraint, no action is required.
//Each print query has to be executed in a new line.
//
//
//Problem Constraints
//1 <= position <= n where, n is the size of the linked-list.
//
//
//
//Input Format
//First line contains an integer denoting number of cases, let's say t.
//Next t line denotes the cases.
//
//
//Output Format
//When there is a case of print_ll(),  Print the entire linked list, such that each element is followed by a single space.
//NOTE: You don't need to return anything.
//
//
//Example Input
//5
//i 1 23
//i 2 24
//p
//d 1
//p
//
//
//Example Output
//23 24
//24
//
//
//Example Explanation
//After first two cases linked list contains two elements 23 and 24.
//At third case print: 23 24.
//At fourth case delete value at first position, only one element left 24.
//At fifth case print: 24.

public class LinkedList {

	/**
	 * Definition for singly-linked list.
	 */
	static class Node {
		public int val;
		public Node next;

		Node(int x) {
			val = x;
			next = null;
		}
	}

	private static Node head = null;

	public static void insert_node(int position, int value) {

		Node node = new Node(value);
		if (head == null || position == 1) {
			if (head == null) {
				head = node;
			} else {
				node.next = head;
				head = node;
			}
		} else {
			Node temp = head;
			int count = 1;
			while (count < position - 1 && temp.next != null) {
				temp = temp.next;
				count++;
			}
			if (temp.next != null) {
				node.next = temp.next;
				temp.next = node;
			} else {
				temp.next = node;
			}
		}
	}

	public static void delete_node(int position) {
		// @params position, integer
		if (head == null) {
			return;
		}
		if (position == 1) {
			head = head.next;
			return;
		}
		Node temp = head;
		int count = 1;
		while (count < position - 1 && temp.next != null) {
			temp = temp.next;
			count++;
		}
		if (temp.next != null) {
			temp.next = temp.next.next;
		}
	}

	public static void print_ll() {
		Node temp = head;
		while (temp.next != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.print(temp.val);
	}

	public static void main(String[] args) {
		insert_node(1, 1);
		insert_node(2, 10);
		insert_node(3, 20);
		insert_node(4, 30);
		insert_node(5, 40);

		print_ll();
	}
}

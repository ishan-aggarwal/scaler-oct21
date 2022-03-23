package day58.homework;

import java.util.HashMap;
import java.util.Map;

//Q5. Clone a Linked List

//Problem Description
//Given a doubly linked list of integers with one pointer of each node pointing to the next node (just like in a single link list) while the second pointer, however, can point to any node in the list and not just the previous node.
//
//You have to create a copy of this list and return the head pointer of the duplicated list.
//
//
//
//Problem Constraints
//1 <= length of the list <= 100000
//
//1 <= Value of node <= 100000
//
//
//
//Input Format
//The only argument given is head pointer of the doubly linked list.
//
//
//
//Output Format
//Return the head pointer of the duplicated list.
//
//
//
//Example Input
//Input 1:
//
//1 -> 2 -> 3 -> 4 -> 5
//random pointer of each node 
//1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1
//Input 2:
//
//1 -> 2 -> 3 -> 4 -> 5
//random pointer of each node 
//1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1
//
//
//Example Output
//Output 1:
//
//1 -> 2 -> 3 -> 4 -> 5
//random pointer of each node 
//1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1
//Output 2:
//
//1 -> 2 -> 3 -> 4 -> 5
//random pointer of each node 
//1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1
//
//
//Example Explanation
//Explanation 1:
//
// Just clone the given list.
//Explanation 2:
//
// Just clone the given list

public class CloneListWithExtraPointer {

	// Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next, random;

		ListNode(int x) {
			val = x;
			next = random = null;
		}
	}

	public static ListNode cloneList(ListNode A) {

		ListNode curr = A;
		ListNode result = null;

		result = new ListNode(curr.val);
		ListNode curr2 = result;

		Map<ListNode, ListNode> map = new HashMap<>();
		map.put(curr, curr2);

		curr = curr.next;
		while (curr != null) {
			ListNode temp = new ListNode(curr.val);
			map.put(curr, temp);
			curr2.next = temp;
			curr2 = curr2.next;
			curr = curr.next;
		}

		curr = A;
		curr2 = result;
		while (curr != null) {
			ListNode random = curr.random;
			ListNode randomClone = map.get(random);
			curr2.random = randomClone;
			curr = curr.next;
			curr2 = curr2.next;
		}

		return result;
	}

	public static void main(String[] args) {
		ListNode A = new ListNode(9);
		ListNode A1 = new ListNode(9);
		A.next = A1;

		ListNode clonedList = cloneList(A);

	}
}

package day58.assignment;

import java.util.HashMap;
import java.util.Map;

//Q1. Copy List
//Problem Description
//
//A linked list A is given such that each node contains an additional random pointer which could point to any node in the list or NULL.
//
//Return a deep copy of the list.
//
//
//
//Problem Constraints
//
//0 <= |A| <= 106
//
//
//
//Input Format
//
//The first argument of input contains a pointer to the head of linked list A.
//
//
//
//Output Format
//
//Return a pointer to the head of the required linked list.
//
//
//
//Example Input
//
//Given list
//   1 -> 2 -> 3
//with random pointers going from
//  1 -> 3
//  2 -> 1
//  3 -> 1
//  
//
//
//Example Output
//
//   1 -> 2 -> 3
//with random pointers going from
//  1 -> 3
//  2 -> 1
//  3 -> 1
//  
//
//
//Example Explanation
//
//You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.
//

public class CopyList_Approach2 {

	// Definition for singly-linked list with a random pointer.
	static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

	public static RandomListNode copyRandomList(RandomListNode head) {

		if (head == null) {
			return null;
		}

		// map to store the actual and cloned nodes for O(1) retrieval
		Map<RandomListNode, RandomListNode> map = new HashMap<>();

		// curr to point to head
		RandomListNode curr = head;

		// clone the head node separately
		RandomListNode h2 = new RandomListNode(curr.label);
		RandomListNode curr2 = h2;

		// put it inside map
		map.put(curr, curr2);

		curr = curr.next;

		// iterate first to create all the cloned list
		// while curr is not null
		while (curr != null) {

			// clone the node
			RandomListNode temp = new RandomListNode(curr.label);
			map.put(curr, temp);
			curr2.next = temp;
			curr = curr.next;
			curr2 = curr2.next;
		}

		// set the random pointers using map
		curr = head;
		curr2 = h2;
		while (curr != null) {
			RandomListNode random = curr.random;
			RandomListNode h2Random = map.get(random);
			curr2.random = h2Random;
			curr = curr.next;
			curr2 = curr2.next;
		}
		return h2;
	}
}

package week27.day71.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

//Q4. Merge K Sorted Lists
//Problem Description
//Given a list containing head pointers of N sorted linked lists.
//Merge these given sorted linked lists and return them as one sorted list.
//
//
//
//Problem Constraints
//1 <= total number of elements in given linked lists <= 100000
//
//
//
//Input Format
//The first and only argument is a list containing N head pointers.
//
//
//
//Output Format
//Return a pointer to the head of the sorted linked list after merging all the given linked lists.
//
//
//
//Example Input
//Input 1:
//
// 1 -> 10 -> 20
// 4 -> 11 -> 13
// 3 -> 8 -> 9
//Input 2:
//
// 10 -> 12
// 13
// 5 -> 6
//
//
//Example Output
//Output 1:
//
// 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
//Output 2:
//
// 5 -> 6 -> 10 -> 12 ->13
//
//
//Example Explanation
//Explanation 1:
//
// The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
//Explanation 2:
//
// The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.

public class MergeKSortedLists3 {

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// Java | Using LinkList | Easy solution
	public ListNode mergeKLists(ArrayList<ListNode> A) {

		LinkedList<ListNode> list = new LinkedList<>();
		for (int i = 0; i < A.size(); i++) {
			ListNode each = A.get(i);
			while (each != null) {
				list.add(each);
				each = each.next;
			}
		}

		Collections.sort(list, (o1, o2) -> o1.val - o2.val);

		// Keep the root
		ListNode root = list.get(0);

		ListNode temp = list.get(0);
		;
		for (int i = 1; i < list.size(); i++) {
			temp.next = list.get(i);
			temp = temp.next;
		}
		temp.next = null;

		return root;
	}

	public static void main(String[] args) {

	}
}

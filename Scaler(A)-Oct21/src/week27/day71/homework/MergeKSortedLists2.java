package week27.day71.homework;

import java.util.ArrayList;
import java.util.List;

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

public class MergeKSortedLists2 {

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// Java Solution without using extra space
	public ListNode mergeKLists(ArrayList<ListNode> a) {
		ListNode head = new ListNode(0);
		ListNode ans = head;
		while (a.size() > 0) {
			ListNode node = new ListNode(Integer.MAX_VALUE);
			int idx = 0;
			boolean flag = false;
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i) == null) {
					a.remove(i);
					flag = true;
					break;
				}
				if (a.get(i).val < node.val) {
					idx = i;
					node = a.get(i);
				}
			}
			if (!flag) {
				head.next = a.get(idx);
				head = head.next;
				a.set(idx, a.get(idx).next);
			}
		}
		return ans.next;
	}

	public static void main(String[] args) {

	}
}

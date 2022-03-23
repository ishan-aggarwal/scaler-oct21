package day58.homework;

//Q4. Swap List Nodes in pairs
//Problem Description
//Given a linked list A, swap every two adjacent nodes and return its head.
//
//NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.
//
//
//
//Problem Constraints
//1 <= |A| <= 106
//
//
//
//Input Format
//The first and the only argument of input contains a pointer to the head of the given linked list.
//
//
//
//Output Format
//Return a pointer to the head of the modified linked list.
//
//
//
//Example Input
//Input 1:
//
// A = 1 -> 2 -> 3 -> 4
//Input 2:
//
// A = 7 -> 2 -> 1
//
//
//Example Output
//Output 1:
//
// 2 -> 1 -> 4 -> 3
//Output 2:
//
// 2 -> 7 -> 1
//
//
//Example Explanation
//Explanation 1:
//
// In the first example (1, 2) and (3, 4) are the adjacent nodes. Swapping them will result in 2 -> 1 -> 4 -> 3
//Explanation 2:
//
// In the second example, 3rd element i.e. 1 does not have an adjacent node, so it won't be swapped. 

public class SwapListNodeInPairs {

	// Definition for singly-linked list.
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// TC - O(N)
	// SC - O(1) - no extra space taken in place swapping of adjacent nodes
	public static ListNode swapPairs(ListNode A) {

		// if there is no node or only one node return
		if (A == null || A.next == null) {
			return A;
		}

		// while they are two nodes which are not null
		// swap the data of the two nodes
		// move current by 2 positions
		ListNode curr = A;
		while (curr != null && curr.next != null) {
			int temp = curr.val;
			curr.val = curr.next.val;
			curr.next.val = temp;
			curr = curr.next.next;
		}

		return A;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		ListNode head4 = new ListNode(4);

		head.next = head2;
		head2.next = head3;
		head3.next = head4;

		ListNode result = swapPairs(head);

		System.out.println(result);
	}
}

package day56.assignment;

//Q4. Reverse Link List II
//Problem Description
//
//Reverse a linked list A from position B to C.
//
//NOTE: Do it in-place and in one-pass.
//
//
//
//Problem Constraints
//
//1 <= |A| <= 106
//
//1 <= B <= C <= |A|
//
//
//
//Input Format
//
//The first argument contains a pointer to the head of the given linked list, A.
//
//The second argument contains an integer, B.
//
//The third argument contains an integer C.
//
//
//
//Output Format
//
//Return a pointer to the head of the modified linked list.
//
//
//
//Example Input
//
//Input 1:
//
// A = 1 -> 2 -> 3 -> 4 -> 5
// B = 2
// C = 4
//
//Input 2:
//
// A = 1 -> 2 -> 3 -> 4 -> 5
// B = 1
// C = 5
//
//
//Example Output
//
//Output 1:
//
// 1 -> 4 -> 3 -> 2 -> 5
//Output 2:
//
// 5 -> 4 -> 3 -> 2 -> 1
//
//
//Example Explanation
//
//Explanation 1:
//
// In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5 
// Thus, the output is 1 -> 4 -> 3 -> 2 -> 5 
//Explanation 2:
//
// In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5  
// Thus, the output is 5 -> 4 -> 3 -> 2 -> 1 

public class ReverseLinkedList2 {

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

	public static ListNode reverseBetween(ListNode A, int m, int n) {
		int i;
		ListNode node = A;
		ListNode prev = null;
		m--;
		n--;
		for (i = 0; i < m; i++) {
			prev = node;
			node = node.next;
		}
		if (prev != null)
			prev.next = reverseKNodes(node, n - m + 1);
		else
			A = reverseKNodes(node, n - m + 1);
		return A;
	}

	public static ListNode reverseKNodes(ListNode head, int k) {

		// base case
		if (head == null || k <= 1)
			return head;

		ListNode nextNode = head;
		ListNode temp = null;

		// h2 is used to point to the head of new list
		// new list is empty at the start
		ListNode h2 = null;

		// while k is greater than zero and nextNode is also not null
		while (k > 0 && nextNode != null) {
			temp = nextNode;
			nextNode = nextNode.next;
			temp.next = h2;
			h2 = temp;
			k--;
		}

		head.next = nextNode;
		return h2;
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

		ListNode updatedList = reverseBetween(head, 2, 4);
		System.out.println(updatedList);
	}
}

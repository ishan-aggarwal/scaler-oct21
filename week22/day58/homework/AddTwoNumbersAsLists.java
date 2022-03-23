package day58.homework;

//Q2. Add Two Numbers as Lists

//Problem Description
//You are given two linked lists, A and B, representing two non-negative numbers.
//
//The digits are stored in reverse order, and each of their nodes contains a single digit.
//
//Add the two numbers and return it as a linked list.
//
//
//
//Problem Constraints
//1 <= |A|, |B| <= 105
//
//
//
//Input Format
//The first argument of input contains a pointer to the head of linked list A.
//
//The second argument of input contains a pointer to the head of linked list B.
//
//
//
//Output Format
//Return a pointer to the head of the required linked list.
//
//
//
//Example Input
//Input 1:
//
// 
// A = [2, 4, 3]
// B = [5, 6, 4]
//Input 2:
//
// 
// A = [9, 9]
// B = [1]
//
//
//Example Output
//Output 1:
//
// 
// [7, 0, 8]
//Output 2:
//
// 
// [0, 0, 1]
//
//
//Example Explanation
//Explanation 1:
//
// A = 342 and B = 465. A + B = 807. 
//Explanation 2:
//
// A = 99 and B = 1. A + B = 100. 

public class AddTwoNumbersAsLists {

	// Definition for singly-linked list.
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode addTwoNumbers(ListNode A, ListNode B) {

		ListNode result = new ListNode(-1);
		int carry = 0;

		ListNode curr = A;
		ListNode curr2 = B;
		ListNode curr3 = result;
		while (curr != null || curr2 != null) {
			int sum = 0;

			if (curr != null) {
				sum += curr.val;
				curr = curr.next;
			}

			if (curr2 != null) {
				sum += curr2.val;
				curr2 = curr2.next;
			}

			sum += carry;

			carry = sum / 10;
			curr3.next = new ListNode(sum % 10);
			curr3 = curr3.next;
		}

		if (carry > 0) {
			curr3.next = new ListNode(carry);
			curr3 = curr3.next;
		}

		return result.next;
	}

	public static void main(String[] args) {
		ListNode A = new ListNode(9);
		ListNode A1 = new ListNode(9);
		A.next = A1;

		ListNode B = new ListNode(1);

		ListNode result = addTwoNumbers(A, B);
		System.out.println(result);
	}
}

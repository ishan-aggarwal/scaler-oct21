package day61.assignment;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

//Q1. Perfect Numbers
//Problem Description
//Given an integer A, you have to find the Ath Perfect Number.
//
//A Perfect Number has the following properties:
//
//It comprises only 1 and 2.
//
//The number of digits in a Perfect number is even.
//
//It is a palindrome number.
//
//For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
//
//
//
//Problem Constraints
//1 <= A <= 100000
//
//
//
//Input Format
//The only argument given is an integer A.
//
//
//
//Output Format
//Return a string that denotes the Ath Perfect Number.
//
//
//
//Example Input
//Input 1:
//
// A = 2
//Input 2:
//
// A = 3
//
//
//Example Output
//Output 1:
//
// 22
//Output 2:
//
// 1111
//
//
//Example Explanation
//Explanation 1:
//
//First four perfect numbers are:
//1. 11
//2. 22
//3. 1111
//4. 1221
//Explanation 2:
//
//First four perfect numbers are:
//1. 11
//2. 22
//3. 1111
//4. 1221

public class AthPerfectNumbers {

	public String solve2(int A) {
		Queue<String> queue = new LinkedList<String>();
		if (A == 1) {
			return "11";
		} else if (A == 2) {
			return "22";
		}

		queue.add("1");
		queue.add("2");
		int cur = 2;
		String ans = new String();
		while (queue.size() < A) {
			StringBuilder sb = new StringBuilder(queue.peek());
			queue.remove();
			sb.append("1");
			queue.add(sb.toString());
			cur++;
			if (cur == A) {
				ans = sb.toString();
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("2");
			cur++;
			if (cur == A) {
				ans = sb.toString();
			}
			queue.add(sb.toString());
		}
		StringBuilder sb = new StringBuilder(ans);
		return ans + sb.reverse().toString();
	}

	public static String solve(int A) {

		if (A == 1) {
			return "11";
		} else if (A == 2) {
			return "22";
		}

		int count = 0;
		Queue<StringBuilder> queue = new ArrayDeque<>();
		queue.add(new StringBuilder("1"));
		queue.add(new StringBuilder("2"));
		String[] res = new String[A];

		while (count < A && !queue.isEmpty()) {
			StringBuilder head = queue.poll();
			queue.add(new StringBuilder(head.toString() + "1"));
			queue.add(new StringBuilder(head.toString() + "2"));
			res[count++] = head.toString() + head.reverse().toString();
		}
		return res[A - 1];
	}

	public static void main(String[] args) {
//		System.out.println(solve(3));
//		System.out.println(solve(5));
//		System.out.println(solve(7));
		System.out.println(solve(9));
	}
}

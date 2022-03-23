package day59.assignment;

//Q1. Balanced Parentheses

//Problem Description
//Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
//
//Refer to the examples for more clarity.
//
//
//
//Problem Constraints
//1 <= |A| <= 100
//
//
//
//Input Format
//The first and the only argument of input contains the string A having the parenthesis sequence.
//
//
//
//Output Format
//Return 0 if the parenthesis sequence is not balanced.
//
//Return 1 if the parenthesis sequence is balanced.
//
//
//
//Example Input
//Input 1:
//
// A = {([])}
//Input 2:
//
// A = (){
//Input 3:
//
// A = ()[] 
//
//
//Example Output
//Output 1:
//
// 1 
//Output 2:
//
// 0 
//Output 3:
//
// 1 
//
//
//Example Explanation
//You can clearly see that the first and third case contain valid paranthesis.
//
//In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.
//

import java.util.Stack;

public class BalancedParentheses {

	// TC - O(N) because visiting the input string characters once
	// SC - O(N) aux stack is used to perform the operations
	public int solve(String A) {
		Stack<Character> stack = new Stack<>();
		if (A == null || A.length() == 0) {
			return 1;
		}

		for (char c : A.toCharArray()) {
			if (stack.isEmpty() && (c == ')' || c == '}' || c == ']')) {
				return 0;
			} else if (c == ')' || c == '}' || c == ']') {
				if ((c == ')' && stack.peek() != '(') || (c == ']' && stack.peek() != '[')
						|| (c == '}' && stack.peek() != '{')) {
					return 0;
				} else {
					stack.pop();
				}
			} else {
				stack.push(c);
			}
		}

		if (stack.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		BalancedParentheses obj = new BalancedParentheses();
		System.out.println(obj.solve("{([])}"));
	}
}

package day60.homework;

import java.util.Stack;

//Q1. Double Character Trouble
//Problem Description
//You are given a string A.
//
//An operation on the string is defined as follows:
//
//Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".
//
//Therefore the string after this operation will be "acd".
//
//Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.
//
//
//
//Problem Constraints
//1 <= |A| <= 100000
//
//
//
//Input Format
//First and only argument is string A.
//
//
//
//Output Format
//Return the final string.
//
//
//
//Example Input
//Input 1:
//
// A = abccbc
//Input 2:
//
// A = ab
//
//
//Example Output
//Output 1:
//
// "ac"
//Output 2:
//
// "ab"
//
//
//Example Explanation
//Explanation 1:
//
//Remove the first occurrence of same consecutive characters. eg for a string "abbc", 
//the first occurrence of same consecutive characters is "bb".
//Therefore the string after this operation will be "ac".
//Explanation 2:
//
// No removals are to be done.

public class DoubleCharacterTrouble {

	// TC - O(N)
	// iterating over all the characters only once and pushing them into the stack
	// exactly once (doing pop operation in case of match)
	// SC - O(N)
	// this is because of the temp stack used
	public static String solve(String A) {

		// temp stack to hold the characters which form the answer
		Stack<Character> stack = new Stack<>();

		// iterate over the input array A
		for (char c : A.toCharArray()) {

			// if stack is empty no possibility to match with any previous character
			// insert the current character into the stack
			if (stack.isEmpty()) {
				stack.push(c);

				// if stack is not empty; match the top character with the current character
				// in case both are same; pop the matching character from the stack
			} else if (stack.peek() == c) {
				stack.pop();
			} else {
				// else push the character into the stack in case of mismatch
				stack.push(c);
			}
		}

		StringBuilder sb = new StringBuilder();

		// while stack is not empty pop the result characters from stack
		while (!stack.isEmpty()) {

			// instead of append use the insert operation at 0 index
			// this will help not to reverse the string later while returning
			sb.insert(0, stack.pop());
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String A = "abccbc";
		System.out.println(solve(A));
	}
}

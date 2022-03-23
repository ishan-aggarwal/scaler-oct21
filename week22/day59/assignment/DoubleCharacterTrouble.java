package day59.assignment;

import java.util.Stack;

//Q2. Double Character Trouble
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

	// TC - O(N) as we are visiting all the string char once
	// and iterating over the stack to prepare the result will also be linear
	// SC - O(N) for storing the characters in stack and finally returning the
	// result string using output StringBuilder
	public String solve(String A) {
		StringBuilder output = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (char c : A.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}

		while (!stack.isEmpty()) {
			output.append(stack.pop());
		}

		return output.reverse().toString();
	}

	public static void main(String[] args) {
		DoubleCharacterTrouble obj = new DoubleCharacterTrouble();
		System.out.println(obj.solve("abccbc"));
		System.out.println(obj.solve("ab"));
	}
}

package week28.day73.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Q3. Letter Phone
//Problem Description
//Given a digit string A, return all possible letter combinations that the number could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//
//
//The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
//
//NOTE: Make sure the returned strings are lexicographically sorted.
//
//
//
//Problem Constraints
//1 <= |A| <= 10
//
//
//
//Input Format
//The only argument is a digit string A.
//
//
//
//Output Format
//Return a string array denoting the possible letter combinations.
//
//
//
//Example Input
//Input 1:
//
// A = "23"
//Input 2:
//
// A = "012"
//
//
//Example Output
//Output 1:
//
// ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
//Output 2:
//
// ["01a", "01b", "01c"]
//
//
//Example Explanation
//Explanation 1:
//
// There are 9 possible letter combinations.
//Explanation 2:
//
// Only 3 possible letter combinations.

public class LetterPhone {
	public static ArrayList<String> letterCombinations(String A) {

		ArrayList<String> answer = new ArrayList<String>();

		// build dictionary of characters
		Map<Character, String> map = new HashMap<>();
		map.put('0', "0");
		map.put('1', "1");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");

		StringBuilder current = new StringBuilder();
		backtrack(A, 0, current, map, answer);
		return answer;

	}

	private static void backtrack(String digits, int index, StringBuilder current, Map<Character, String> map,
			ArrayList<String> answer) {

		// base condition
		if (digits.length() == index) {
			answer.add(current.toString());
			return;
		}

		String values = map.get(digits.charAt(index));
		for (int i = 0; i < values.length(); i++) {
			// do
			current.append(values.charAt(i));
			// recursive call
			backtrack(digits, index + 1, current, map, answer);
			// undo
			current.deleteCharAt(current.length() - 1);
		}
	}

	public static void main(String[] args) {
		String A = "23";
		System.out.println(letterCombinations(A));
	}
}

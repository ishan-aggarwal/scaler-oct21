//Q1. Excel Column Number
//Problem Description
//
//Given a column title as appears in an Excel sheet, return its corresponding column number.
//
//
//
//Problem Constraints
//
//1 <= length of the column title <= 5
//
//
//
//Input Format
//
//Input a string which represents the column title in excel sheet.
//
//
//
//Output Format
//
//Return a single integer which represents the corresponding column number.
//
//
//
//Example Input
//
//Input 1:
//
// AB
//Input 2:
//
// ABCD
//
//
//Example Output
//
//Output 1:
//
// 28
//Output 2:
//
// 19010
//
//
//Example Explanation
//
//Explanation 1:
//
// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28

package day15.assignments;

import java.util.HashMap;
import java.util.Map;

public class ExcelColumnNumber {

	public static int titleToNumber(String A) {

		Map<Character, Integer> charIndexMap = new HashMap<>();

		charIndexMap.put('A', 1);
		charIndexMap.put('B', 2);
		charIndexMap.put('C', 3);
		charIndexMap.put('D', 4);
		charIndexMap.put('E', 5);
		charIndexMap.put('F', 6);
		charIndexMap.put('G', 7);
		charIndexMap.put('H', 8);
		charIndexMap.put('I', 9);
		charIndexMap.put('J', 10);
		charIndexMap.put('K', 11);
		charIndexMap.put('L', 12);
		charIndexMap.put('M', 13);
		charIndexMap.put('N', 14);
		charIndexMap.put('O', 15);
		charIndexMap.put('P', 16);
		charIndexMap.put('Q', 17);
		charIndexMap.put('R', 18);
		charIndexMap.put('S', 19);
		charIndexMap.put('T', 20);
		charIndexMap.put('U', 21);
		charIndexMap.put('V', 22);
		charIndexMap.put('W', 23);
		charIndexMap.put('X', 24);
		charIndexMap.put('Y', 25);
		charIndexMap.put('Z', 26);

		int strLen = A.length();
		int colNumber = 0;
		for (int i = strLen - 1; i >= 0; i--) {
			colNumber += charIndexMap.get(A.charAt(i)) * Math.pow(26, strLen - i - 1);
		}

		return colNumber;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber("ABCD"));
	}
}

//Q6. Isalpha()
//Problem Description
//
//You are given a function isalpha() consisting of a character array A.
//
//Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.
//
//
//
//Problem Constraints
//
//1 <= |A| <= 105
//
//
//
//Input Format
//
//Only argument is a character array A.
//
//
//
//Output Format
//
//Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.
//
//
//
//Example Input
//
//Input 1:
//
// A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y']
//Input 2:
//
// A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']
//
//
//Example Output
//
//Output 1:
//
// 1
//Output 2:
//
// 0
//
//
//Example Explanation
//
//Explanation 1:
//
// All the characters are alphabets.
//Explanation 2:
//
// All the characters are NOT alphabets i.e ('#', '2', '0', '2', '0').

package day19.assignments;

import java.util.Arrays;
import java.util.List;

public class StringCheck2Alpha {
	public static int solve(List<Character> A) {
		int result = 1;
		for (Character c : A) {
			if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
				result = 0;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Character[] A = { 'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y' };
		List<Character> list = Arrays.asList(A);
		System.out.println(solve(list));
	}
}

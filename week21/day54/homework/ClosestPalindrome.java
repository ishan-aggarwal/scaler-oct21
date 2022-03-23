package day54.homework;

//Q2. Closest Palindrome

//Problem Description
//Groot has a profound love for palindrome which is why he keeps fooling around with strings.
//A palindrome string is one that reads the same backward as well as forward.
//
//Given a string A of size N consisting of lowercase alphabets, he wants to know if it is possible to make the given string a palindrome by changing exactly one of its character.
//
//
//
//Problem Constraints
//1 <= N <= 105
//
//
//
//Input Format
//The first and only argument is a string A.
//
//
//
//Output Format
//Return the string YES if it is possible to make the given string a palindrome by changing exactly 1 character. Else, it should return the string NO.
//
//
//
//Example Input
//Input 1:
//
// A = "abbba"
//Input 2:
//
// A = "adaddb"
//
//
//Example Output
//Output 1:
//
// "YES"
//Output 2:
//
// "NO"
//
//
//Example Explanation
//Explanation 1:
//
// We can change the character at index 3(1-based) to any other character. The string will be palindromic.
//Explanation 2:
//
// To make the string palindromic we need to change 2 characters. 

public class ClosestPalindrome {
	public static String solve(String A) {

		int len = A.length();
		int i = 0, j = len - 1;
		int count = 0;

		// logic to check for palindrome and increase count in case of mis-match
		// increase left ptr and decrease right ptr
		while (i < j) {
			if (A.charAt(i) != A.charAt(j)) {
				count++;
			}
			i++;
			j--;
		}

		// finally check the condition
		if (((len % 2 == 1) && (count == 0)) || (count == 1)) {
			return "YES";
		}

		return "NO";
	}

	public static void main(String[] args) {
		System.out.println(solve("adaddb"));
	}
}

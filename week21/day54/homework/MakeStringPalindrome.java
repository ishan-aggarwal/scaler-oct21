package day54.homework;

//Q3. Make String Palindrome
//Problem Description
//Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.
//
//Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.
//
//
//
//Problem Constraints
//1 <= N <= 106
//
//
//
//Input Format
//The only argument given is a string A.
//
//
//
//Output Format
//Return an integer denoting the minimum characters needed to be inserted in the beginning to make the string a palindrome string.
//
//
//
//Example Input
//Input 1:
//
// A = "abc"
//Input 2:
//
// A = "bb"
//
//
//Example Output
//Output 1:
//
// 2
//Output 2:
//
// 0
//
//
//Example Explanation
//Explanation 1:
//
// Insert 'b' at beginning, string becomes: "babc".
// Insert 'c' at beginning, string becomes: "cbabc".
//Explanation 2:
//
// There is no need to insert any character at the beginning as the string is already a palindrome. 

public class MakeStringPalindrome {
	
//	Maintain 2 ptr i(from left) and j(from right) and if any diff is identified there can be 2 possibility - 
//
//	If i == 0 then reduce j meaning that j is matched with a new character which will be added from front
//	If i > 0 then if diff is identified that mean if I add a new character from previous i which was matched needs to be reset hence i-- 
	
	
	public static int solve(String A) {
		int i = 0, j = A.length() - 1, count = 0;
		while (i < j) {
			char a = A.charAt(i);
			char b = A.charAt(j);
			if (a != b) {
				count++;
				if (i > 0) {
					i--;
					continue;
				}
				j--;
				continue;
			}
			i++;
			j--;
		}
		return count;
	}

	public static void main(String[] args) {

	}
}

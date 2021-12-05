//Q4. String operations
//Problem Description
//
//Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:
//
//Concatenate the string with itself.
//Delete all the uppercase letters.
//Replace each vowel with '#'.
//You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.
//
//NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.
//
//
//
//Problem Constraints
//
//1<=N<=100000
//
//
//Input Format
//
//First argument is a string A of size N.
//
//
//
//Output Format
//
//Return the resultant string.
//
//
//
//Example Input
//
//A="AbcaZeoB"
//
//
//
//Example Output
//
//"bc###bc###"
//
//
//
//Example Explanation
//
//First concatenate the string with itself so string A becomes "AbcaZeoBAbcaZeoB".
//Delete all the uppercase letters so string A becomes "bcaeobcaeo".
//Now replace vowel with '#'.
//A becomes "bc###bc###".

package day19.homework;

public class StringOperations {
	public static String solve(String A) {

		StringBuilder result = new StringBuilder();
		result.append(A);
		result.append(A);

		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) >= 'A' && result.charAt(i) <= 'Z') {
				result.replace(i, i + 1, "");
				i--;
			}
		}

		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) == 'a' || result.charAt(i) == 'e' || result.charAt(i) == 'i' || result.charAt(i) == 'o'
					|| result.charAt(i) == 'u') {
				result.replace(i, i + 1, "#");
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(solve("AbcaZeoB"));
	}
}

//Q2. Count Occurrences
//Problem Description
//
//Find number of occurrences of bob in the string A consisting of lowercase english alphabets.
//
//
//
//Problem Constraints
//
//1 <= |A| <= 1000
//
//
//Input Format
//
//The first and only argument contains the string A consisting of lowercase english alphabets.
//
//
//Output Format
//
//Return an integer containing the answer.
//
//
//Example Input
//
//Input 1:
//
//  "abobc"
//Input 2:
//
//  "bobob"
//
//
//Example Output
//
//Output 1:
//
//  1
//Output 2:
//
//  2
//
//
//Example Explanation
//
//Explanation 1:
//
//  The only occurrence is at second position.
//Explanation 2:
//
//  Bob occures at first and third position.

package day19.homework;

public class CountOccurrences_Important {
	public static int solve(String A) {

		int count = 0;

		if (A.length() <= 2) {
			return count;
		}

		// for (int i = A.length() - 1; i >= 0; i--) {
		// if (A.charAt(i) == 'b') {
		// if (i >= 2 && A.charAt(i - 1) == 'o' && A.charAt(i-2) == 'b' ) {
		// count++;
		// }
		// i--;
		// }
		// }

		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == 'b') {
				if (i <= (A.length() - 3) && A.charAt(i + 1) == 'o' && A.charAt(i + 2) == 'b') {
					count++;
					i++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(solve("bobob"));
	}
}

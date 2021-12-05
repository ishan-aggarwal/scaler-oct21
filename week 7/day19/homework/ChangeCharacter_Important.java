//Q3. Change character
//Problem Description
//
//Given a string A of size N consisting of lowercase alphabets.
//
//You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
//
//Find the minimum number of distinct characters in the resulting string.
//
//
//
//Problem Constraints
//
//1 <= N <= 100000
//
//0 <= B < N
//
//
//
//Input Format
//
//First argument is a string A.
//
//Second argument is an integer B.
//
//
//
//Output Format
//
//Return an integer denoting the minimum number of distinct characters in the string.
//
//
//
//Example Input
//
//A = "abcabbccd"
//B = 3
//
//
//
//Example Output
//
//2
//
//
//
//Example Explanation
//
//We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
//So the minimum number of distinct character will be 2.
//

package day19.homework;

import java.util.Arrays;

public class ChangeCharacter_Important {
	public static int solve(String A, int B) {

		int[] freq = new int[26];
		Arrays.fill(freq, 0);

		int count = 0;

		for (int i = 0; i < A.length(); i++) {
			freq[A.charAt(i) - 'a']++;
		}

		Arrays.sort(freq);

		for (int i = 0; i < 26; i++) {
			if (B <= 0) {
				break;
			}

			if (freq[i] <= B) {
				B = B - freq[i];
				freq[i] = 0;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(solve("abcabbccd", 3));
	}
}

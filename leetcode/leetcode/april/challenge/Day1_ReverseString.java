package leetcode.april.challenge;

//344. Reverse String
//Easy

class Day1_ReverseString {
	public void reverseString(char[] s) {

		for (int i = 0, j = s.length - 1; i < j; i++, j--) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
		}
	}
}
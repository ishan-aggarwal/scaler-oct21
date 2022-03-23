package day58.assignment;

public class RemoveDuplicateChars {
	public static String removeDuplicateLetters(String s) {

		if (s == null) {
			return null;
		}

		int[] freq = new int[26];

		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}

		StringBuilder res = new StringBuilder();

		for (int i = 0; i < 26; i++) {
			if (freq[i] > 0) {
				char c = (char) ('a' + i);
				res.append(c);
			}
		}

		return res.toString();
	}
}
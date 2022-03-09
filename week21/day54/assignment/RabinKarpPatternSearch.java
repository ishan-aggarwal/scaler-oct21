package day54.assignment;

public class RabinKarpPatternSearch {

	public static void main(String[] args) {

		String text = "abdecaabcabcfabc";
		String pattern = "abc";

		System.out.println(solve(text, pattern));

	}

	private static int solve(String text, String pattern) {
		long mod = 1000000007;
		int base = 26;
		long currTextHash = 0;
		long patternHash = 0;
		long powValue = 1;
		int count = 0;

		int n = text.length();
		int m = pattern.length();

		// For pattern length 3, power will go from 0,1,2 (m-1)
		for (int i = 1; i <= m - 1; ++i) {
			powValue = (powValue * base) % mod;
		}

		// Calculate hash value for pattern
		for (int i = 0; i < m; i++) {
			patternHash = (base * patternHash + (pattern.charAt(i) - 'a')) % mod;
		}

		// Calculate hash value for first window of text
		for (int i = 0; i < m; i++) {
			currTextHash = (base * currTextHash + (text.charAt(i) - 'a')) % mod;
		}

		// calculate hash value for text in sliding manner
		for (int i = 0; i <= n - m; i++) {

			// compare the text if hash value is same
			if (patternHash == currTextHash) {
				for (int j = 0; j < m; j++) {
					if (text.charAt(i + j) != pattern.charAt(j)) {
						break;
					}
					if (j == m - 1) {
						count++;
					}
				}
			}

			if (i < n - m) {
				currTextHash = (base * (currTextHash - (text.charAt(i) - 'a') * powValue) + (text.charAt(i + m) - 'a'))
						% mod;

				if (currTextHash < 0) {
					currTextHash += mod;
				}
			}
		}
		return count;
	}

}

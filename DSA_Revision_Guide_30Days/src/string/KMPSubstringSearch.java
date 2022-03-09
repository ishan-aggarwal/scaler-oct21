package string;

public class KMPSubstringSearch {

	/**
	 * Slow method of pattern matching
	 */
	public boolean hasSubstring(char[] text, char[] pattern) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < text.length && j < pattern.length) {
			if (text[i] == pattern[j]) {
				i++;
				j++;
			} else {
				j = 0;
				k++;
				i = k;
			}
		}
		if (j == pattern.length) {
			return true;
		}
		return false;
	}

	/**
	 * Compute temporary array to maintain size of suffix which is same as prefix
	 * Time/space complexity is O(size of pattern)
	 */
	private int[] computeTemporaryArray(char str[]) {
		int[] lps = new int[str.length];

		lps[0] = 0;
		int i = 0;
		for (int j = 1; j < str.length;) {
			if (str[j] == str[i]) {
				lps[j] = i + 1;
				i++;
				j++;
			} else {
				if (i != 0) {
					i = lps[i - 1];
				} else {
					lps[j] = 0;
					j++;
				}
			}
		}
		return lps;
	}

	/**
	 * KMP algorithm of pattern matching.
	 */
	public boolean kmpSearch(char[] text, char[] pattern) {

		int lps[] = computeTemporaryArray(pattern);
		int n = text.length;
		int m = pattern.length;
		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (text[i] == pattern[j]) {
				i++;
				j++;
			} else {
				if (j > 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		if (j == m) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {

		String str = "abcxabcdabcdabcy";
		String subString = "abcdabcy";
		KMPSubstringSearch ss = new KMPSubstringSearch();
		boolean result = ss.kmpSearch(str.toCharArray(), subString.toCharArray());
		System.out.print(result);

	}
}
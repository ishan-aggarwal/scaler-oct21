package bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordLadder {

	public static int wordLadder(String beginWord, String endWord, String[] wordList) {

		// If the end word is not present then just return form here.
//		if (wordList.contains(endWord) == false) {
//			return -1;
//		}
		Set<String> dictionarySet = new HashSet<>(Arrays.asList(wordList));
		Set<String> beginSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();
		beginSet.add(beginWord);
		endSet.add(endWord);

		int step = 1;
		Set<String> visitedWords = new HashSet<>();

		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}
			Set<String> tempSet = new HashSet<>();
			for (String word : beginSet) {
				char[] wordChars = word.toCharArray();
				// For finding the adjacent words.
				for (int i = 0; i < wordChars.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char old = wordChars[i];
						wordChars[i] = c;
						String target = String.valueOf(wordChars);
						if (endSet.contains(target)) {
							return step + 1;
						}
						if (visitedWords.contains(target) == false && dictionarySet.contains(target)) {
							tempSet.add(target);
							visitedWords.add(target);
						}
						wordChars[i] = old;
					}
				}
			}
			beginSet = tempSet;
			step++;
		}
		return -1;
	}
}
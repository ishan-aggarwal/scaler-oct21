package bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class WordLadderSolution {
	public static final char[] ALPHABETS = new char[26];
	static {
		// ascii representation of english alphabets a - z are numbers 97 - 122
		for (int i = 0; i < 26; i++) {
			ALPHABETS[i] = (char) (i + 'a');
		}
	}

	public static int wordLadder(String beginWord, String endWord, String[] wordList) {
		// make a set because existence query is O(1) vs O(N) for list
		Set<String> dictSet = new HashSet<>(Arrays.asList(wordList));
		ArrayDeque<String> queue = new ArrayDeque<>();
		queue.add(beginWord);
		int distance = 0;
		while (queue.size() > 0) {
			int n = queue.size();
			distance++;
			for (int i = 0; i < n; i++) {
				String word = queue.pop();
				for (int j = 0; j < word.length(); j++) {
					for (char c : ALPHABETS) {
						StringBuilder wordBuilder = new StringBuilder(word.length());
						wordBuilder.append(word.substring(0, j));
						wordBuilder.append(c);
						wordBuilder.append(word.substring(j + 1));
						String nextWord = wordBuilder.toString();
						if (!dictSet.contains(nextWord))
							continue;
						if (nextWord.equals(endWord))
							return distance;
						queue.add(nextWord);
						// removing from the set is equivalent as marking the word visited
						dictSet.remove(nextWord);
					}
				}
			}
		}
		return 0;
	}
}
package week26.day69.assignment;

import java.util.HashMap;
import java.util.Map;

//Q1. Spelling Checker
//Problem Description
//Given an array of words A (dictionary) and another array B (which contain some words).
//
//You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.
//
//Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
//
//Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.
//
//NOTE: Try to do this in O(n) time complexity.
//
//
//
//Problem Constraints
//1 <= |A| <= 1000
//
//1 <= sum of all strings in A <= 50000
//
//1 <= |B| <= 1000
//
//
//
//Input Format
//First argument is array of strings A.
//
//First argument is array of strings B.
//
//
//
//Output Format
//Return the binary array of integers according to the given format.
//
//
//
//Example Input
//Input 1:
//
//A = [ "hat", "cat", "rat" ]
//B = [ "cat", "ball" ]
//Input 2:
//
//A = [ "tape", "bcci" ]
//B = [ "table", "cci" ]
//
//
//Example Output
//Output 1:
//
//[1, 0]
//Output 2:
//
//[0, 0]
//
//
//Example Explanation
//Explanation 1:
//
//Only "cat" is present in the dictionary.
//Explanation 2:
//
//None of the words are present in the dictionary.

public class SpellingChecker {
	static TrieNode root = new TrieNode();

	static class TrieNode {
		Map<Character, TrieNode> map;
		boolean end;

		TrieNode() {
			map = new HashMap<Character, TrieNode>();
			end = false;
		}
	}

	public static void insert(String word) {
		TrieNode cur = root;
		int length = word.length();
		for (int i = 0; i < length; i++) {
			char ch = word.charAt(i);
			if (!cur.map.containsKey(ch)) {
				cur.map.put(ch, new TrieNode());
			}
			cur = cur.map.get(ch);
		}
		cur.end = true;
	}

	public static boolean search(String word) {
		int length = word.length();
		TrieNode cur = root;
		for (int i = 0; i < length; i++) {
			char ch = word.charAt(i);
			if (!cur.map.containsKey(ch)) {
				return false;
			}
			cur = cur.map.get(ch);
		}
		if (cur.end == true)
			return true;
		else
			return false;
	}

	public static int[] solve(String[] A, String[] B) {
		int length = A.length;
		for (int i = 0; i < length; i++) {
			insert(A[i]);
		}

		length = B.length;
		int[] res = new int[length];
		for (int i = 0; i < length; i++) {
			boolean isFound = search(B[i]);
			if (isFound)
				res[i] = 1;
			else
				res[i] = 0;
		}
		return res;
	}
}

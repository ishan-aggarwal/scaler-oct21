package hashing;

// https://leetcode.com/problems/jewels-and-stones/

// 771. Jewels and Stones
// Easy

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
	public static int numJewelsInStones(String jewels, String stones) {

		Set<Character> jewelsSet = new HashSet<>();
		int count = 0;
		for (Character c : jewels.toCharArray()) {
			jewelsSet.add(c);
		}
		for (Character c : stones.toCharArray()) {
			if (jewelsSet.contains(c)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String jewels = "aA", stones = "aAAbbbb";
		System.out.println(numJewelsInStones(jewels, stones));
	}
}
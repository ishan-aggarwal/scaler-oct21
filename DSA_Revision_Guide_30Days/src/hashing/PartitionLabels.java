package hashing;

//https://leetcode.com/problems/partition-labels/

//763. Partition Labels
//Medium

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PartitionLabels {
	public static List<Integer> partitionLabels(String s) {
		List<Integer> answer = new ArrayList<>();
		Map<Character, Integer> positionMap = new HashMap<>();

		for (int i = 0; i < s.length(); ++i) {
			positionMap.put(s.charAt(i), i);
		}

		int end = 0, partitionStart = 0;
		for (int start = 0; start < s.length(); ++start) {
			end = Math.max(end, positionMap.get(s.charAt(start)));
			if (start == end) {
				answer.add(end - partitionStart + 1);
				partitionStart = end + 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		System.out.println(partitionLabels(s));
	}
}
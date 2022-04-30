package week28.day72.classwork;

import java.util.Arrays;

//https://leetcode.com/problems/non-overlapping-intervals/

public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		int len = intervals.length;

		Arrays.sort(intervals, (int[] first, int[] second) -> {
			return first[1] - second[1];
		});

		int count = 0;

		int lastEndTime = 0;
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				lastEndTime = intervals[i][1];
			} else {
				int currentStartTime = intervals[i][0];
				if (currentStartTime < lastEndTime) {
					count++;
				} else {
					lastEndTime = intervals[i][1];
				}
			}
		}

		return count;
	}
}
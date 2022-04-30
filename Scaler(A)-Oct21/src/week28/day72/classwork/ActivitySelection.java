package week28.day72.classwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Q2. Activity Selection (Amazon)

// Given n activities with their start and end  time.
// At a time only one activity can be performed
// Maximize the no. of activities that you can perform

//Given N activities with their start time and end time. The task is to find the solution set having a maximum number of non-conflicting activities that can be executed within the given time, assuming only a single activity can be performed at a given time.
//
//Examples:
//
//Input: start[] = [10, 12, 20}]         
//          end[] =  [20, 25, 30]
//Output: [0, 2]
//Explanation: A maximum of two activities can be performed, i.e. Activity 0 and Activity 2[0-based indexing]. 
//
//Input:  
//start[]  =  [1, 3, 0, 5, 8, 5]
//finish[] =  [2, 4, 6, 7, 9, 9]
//Output: [0, 1, 3, 4]
//Explanation: A maximum of four activities can be performed, i.e. Activity 0, Activity 1, Activity 3, and Activity 4[0-based indexing]. 

//https://www.interviewbit.com/blog/activity-selection-problem/
// TC - O(N*logN)
public class ActivitySelection {

	static class Pair {
		int start;
		int end;

		public Pair(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		int[][] A = new int[][] { { 1, 3, 0, 8, 5, 5 }, { 2, 4, 6, 9, 7, 9 } };
		System.out.println(countMaxActivites(A));
	}

	private static int countMaxActivites(int[][] a) {

		int ans = 0;
		int len = a[0].length;

		if (len == 0)
			return ans;

		List<Pair> pairs = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			pairs.add(new Pair(a[0][i], a[1][i]));
		}

		// TC - O(N*logN)
		Collections.sort(pairs, (Pair p1, Pair p2) -> {
			return p1.end - p2.end;
		});

		ans = 1; // include the first pair in the answer as it can be finished at the earliest
		Pair prevPair = pairs.get(0);
		for (int i = 1; i < len; i++) {
			Pair currPair = pairs.get(i);
			// this means we can consider performing the current activity
			// also update the prev pair if we are planning to do the current activity
			if (currPair.start >= prevPair.end) {
				ans++;
				prevPair = currPair;
			}
		}

		return ans;
	}

}

package week28.day72.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Q2. Finish Maximum Jobs
//Problem Description
//There are N jobs to be done, but you can do only one job at a time.
//
//Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
//
//Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
//
//Return the maximum number of jobs you can finish.
//
//
//
//Problem Constraints
//1 <= N <= 105
//
//1 <= A[i] < B[i] <= 109
//
//
//
//Input Format
//The first argument is an integer array A of size N, denoting the start time of the jobs.
//The second argument is an integer array B of size N, denoting the finish time of the jobs.
//
//
//
//Output Format
//Return an integer denoting the maximum number of jobs you can finish.
//
//
//
//Example Input
//Input 1:
//
// A = [1, 5, 7, 1]
// B = [7, 8, 8, 8]
//Input 2:
//
// A = [3, 2, 6]
// B = [9, 8, 9]
//
//
//Example Output
//Output 1:
//
// 2
//Output 2:
//
// 1
//
//
//Example Explanation
//Explanation 1:
//
// We can finish the job in the period of time: (1, 7) and (7, 8).
//Explanation 2:
//
// Since all three jobs collide with each other. We can do only 1 job.

public class FinishMaximumJobs {

	static class JobInfo implements Comparable<JobInfo> {

		private int startTime;
		private int endTime;

		JobInfo(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(JobInfo other) {
			return this.endTime - other.endTime;
		}
	}

	// TC - O(N log N) and SC - O(N)
	public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		List<JobInfo> jobs = new ArrayList<>();
		int n = A.size();

		for (int i = 0; i < n; i++) {
			jobs.add(new JobInfo(A.get(i), B.get(i)));
		}

		// O(n log n)
		Collections.sort(jobs);

		int count = 1;
		int prevEndTime = jobs.get(0).endTime;

		// O(N)
		for (int i = 1; i < n; i++) {
			if (jobs.get(i).startTime >= prevEndTime) {
				count++;
				prevEndTime = jobs.get(i).endTime;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 5, 7, 1));
		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(7, 8, 8, 8));
		System.out.println(solve(A, B));
	}
}

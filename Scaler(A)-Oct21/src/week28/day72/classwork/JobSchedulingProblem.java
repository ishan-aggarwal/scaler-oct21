package week28.day72.classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Q3. Job Scheduling Problem (Amazon, Facebook)
// Given N jobs (Deadline, rewards)
// - you need 1 day to complete one job
// - on a given day, you can do a single job
// - a job can be performed on any day on or before the day of deadline.

// You need to maximize the amount of reward.

// Observations
// 1. Try to do the job on the day of deadline.
// 2. Prioritize the job with the highest reward.

// TC - O(N * log N) + O(N * d) ---> O(N * log N) + O(N log d)

public class JobSchedulingProblem {

	public static void main(String[] args) {
		int[] deadline = new int[] { 3, 1, 2, 1, 3 };
		int[] reward = new int[] { 100, 19, 27, 25, 30 };

		System.out.println(solve(deadline, reward));
	}

	private static int solve(int[] deadline, int[] reward) {
		int totalRewards = 0;
		int len = deadline.length;
		List<Job> jobs = new ArrayList<>();
		int maxTime = 0;
		for (int i = 0; i < len; i++) {
			jobs.add(new Job(deadline[i], reward[i]));
			maxTime = Math.max(maxTime, deadline[i]);
		}
		Collections.sort(jobs);

		int[] jobsTo = new int[maxTime + 1];
		Arrays.fill(jobsTo, -1);

		int i = 0;
		for (Job currJob : jobs) {
			for (i = jobsTo.length - 1; i >= 1; i--) {
				if (jobsTo[i] == -1) {
					jobsTo[i] = currJob.reward;
					totalRewards += currJob.reward;
					break;
				}
			}
			if (i == 0) {
				break;
			}
		}

		return totalRewards;
	}

	static class Job implements Comparable<Job> {
		int time;
		int reward;

		public Job(int time, int reward) {
			super();
			this.time = time;
			this.reward = reward;
		}

		@Override
		public int compareTo(Job o) {
			return o.reward - this.reward;
		}
	}
}

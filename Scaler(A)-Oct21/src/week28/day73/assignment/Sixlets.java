package week28.day73.assignment;

import java.util.ArrayList;
import java.util.Arrays;

//Q3. SIXLETS
//Problem Description
//Given a array of integers A of size N and an integer B.
//
//Return number of non-empty subsequences of A of size B having sum <= 1000.
//
//
//
//Problem Constraints
//1 <= N <= 20
//
//1 <= A[i] <= 1000
//
//1 <= B <= N
//
//
//
//Input Format
//The first argument given is the integer array A.
//
//The second argument given is the integer B.
//
//
//
//Output Format
//Return number of subsequences of A of size B having sum <= 1000.
//
//
//
//Example Input
//Input 1:
//
//    A = [1, 2, 8]
//    B = 2
//Input 2:
//
//    A = [5, 17, 1000, 11]
//    B = 4
//
//
//Example Output
//Output 1:
//
//3
//Output 2:
//
//0
//
//
//Example Explanation
//Explanation 1:
//
// {1, 2}, {1, 8}, {2, 8}
//Explanation 1:
//
// No valid subsequence

public class Sixlets {
	public static int solve(ArrayList<Integer> A, int B) {

		ArrayList<Integer> current = new ArrayList<Integer>();
		int idx = 0;
		int currSum = 0;
		int ans = specialSubsets(idx, currSum, current, A, B);
		return ans;
	}

	private static int specialSubsets(int idx, int currSum, ArrayList<Integer> current, ArrayList<Integer> A, int B) {

		if (idx >= A.size()) {
			if (currSum <= 1000 && current.size() == B) {
				return 1;
			}
			return 0;
		}

		if (currSum <= 1000 && current.size() == B) {
			return 1;
		}

		if (currSum > 1000) {
			return 0;
		}

		currSum += A.get(idx); // include index element in current sum
		current.add(A.get(idx));
		int x = specialSubsets(idx + 1, currSum, current, A, B);
		currSum -= A.get(idx); // include index element in current sum
		current.remove(current.size() - 1);
		int y = specialSubsets(idx + 1, currSum, current, A, B);
		return x + y;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 8));
		int B = 2;
		System.out.println(solve(A, B));
	}
}

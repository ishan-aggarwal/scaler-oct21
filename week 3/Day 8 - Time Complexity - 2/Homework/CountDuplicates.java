//Problem Description
//
//You are given an integer array A having length N. You have to find the number of duplicate(redundant) elements in the array.
//
//
//
//Problem Constraints
//1 <= N <= 1000
//
//-109 <= A[i] <= 109
//
//
//
//Input Format
//First and only argument is an integer array A.
//
//
//
//Output Format
//Return a single integer.
//
//
//
//Example Input
//Input 1:
//
// A = [1, 10, 20, 1, 25, 1, 10, 30, 25, 1] 
//Input 2:
//
// A = [1, 2, 3] 
//
//
//Example Output
//Output 1:
//
// 5 
//Output 2:
//
// 0 
//
//
//Example Explanation
//Explanation 1:
//
// 1 is present 4 times in the array. So, 3 of them are redundant.
// 10 is present 2 times in the array. So, 1 of them is redundant.
// 25 is present 2 times in tha array. So, 1 of them is redundant.
// Total duplicates(redundants) = 3 + 1 + 1 = 5 
//Explanation 2:
//
// There are no duplicates in the array (Each element has distinct value).

package day8.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountDuplicates {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static int solve(final List<Integer> A) {

		Set<Integer> set = new HashSet<>();
		int count = 0;
		for (int ele : A) {
			if (!set.add(ele)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(1, 10, 20, 1, 25, 1, 10, 30, 25, 1));
		System.out.println(solve(A));
	}
}

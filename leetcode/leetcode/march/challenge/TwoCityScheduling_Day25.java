package leetcode.march.challenge;

import java.util.Arrays;
import java.util.Comparator;

//1029. Two City Scheduling
//Medium
//
//A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.
//
//Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.
//
// 
//
//Example 1:
//
//Input: costs = [[10,20],[30,200],[400,50],[30,20]]
//Output: 110
//Explanation: 
//The first person goes to city A for a cost of 10.
//The second person goes to city A for a cost of 30.
//The third person goes to city B for a cost of 50.
//The fourth person goes to city B for a cost of 20.
//
//The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
//Example 2:
//
//Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
//Output: 1859
//Example 3:
//
//Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
//Output: 3086
// 
//
//Constraints:
//
//2 * n == costs.length
//2 <= costs.length <= 100
//costs.length is even.
//1 <= aCosti, bCosti <= 1000

class TwoCityScheduling_Day25 {

	// overall time complexity is O(N*logN)
	public static int twoCitySchedCost(int[][] costs) {

		// Arrays.sort(costs, (a, b) -> ((a[0] - a[1]) - (b[0] - b[1])));

		// instead of sorting on either a[0] or a[1]
		// check the differences and we want to maximize the profit
		// if the profit for candidate a is more than candidate b
		// then a should come on top
		// TC - O(N logN)
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return (a[1] - a[0]) > (b[1] - b[0]) ? -1 : 1;
			}
		});

		int ans = 0;
		int length = costs.length;
		// TC - O(N)
		for (int i = 0; i < length; i++) {
			ans += i >= length / 2 ? costs[i][1] : costs[i][0];
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] costs = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
		System.out.println(twoCitySchedCost(costs));
	}
}

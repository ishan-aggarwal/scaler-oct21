//Q1. Beggars Outside Temple
//
//
//There are N (N > 0) beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to his faith and ability) to some K beggars sitting next to each other.
//
//Given the amount donated by each devotee to the beggars ranging from i to j index, where 1 <= i <= j <= N, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
//
//Example:
//
//Input:
//N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
//
//Return: [10, 55, 45, 25, 25]
//
//Explanation:
//=> First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
//
//=> Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
//
//=> Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]

package day11.assignments;

import java.util.ArrayList;

public class BeggarsOutsideTemple {
	public static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		int[] prefixSum = new int[A];

		for (int i = 0; i < A; i++) {
			prefixSum[i] = 0;
		}

		int startIndex = 0, endIndex = 0, value = 0;
		for (ArrayList<Integer> eachD : B) {
			startIndex = eachD.get(0) - 1;
			endIndex = eachD.get(1) - 1;
			value = eachD.get(2);

			if (startIndex >= 0 && startIndex < A) {
				prefixSum[startIndex] = prefixSum[startIndex] + value;
			}

			if (endIndex + 1 < A) {
				prefixSum[endIndex + 1] = prefixSum[endIndex + 1] + (value * -1);
			}
		}

		for (int i = 1; i < A; i++) {
			prefixSum[i] = prefixSum[i] + prefixSum[i - 1];
		}

		for (int i = 0; i < A; i++) {
			result.add(prefixSum[i]);
		}

		return result;
	}

	public static void main(String[] args) {
		// N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(1);
		al1.add(2);
		al1.add(10);

		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(2);
		al2.add(3);
		al2.add(20);

		ArrayList<Integer> al3 = new ArrayList<Integer>();
		al3.add(2);
		al3.add(5);
		al3.add(25);

		input.add(al1);
		input.add(al2);
		input.add(al3);

		ArrayList<Integer> result = solve(5, input);
		for (Integer value : result) {
			System.out.print(value + " ");
		}
	}
}

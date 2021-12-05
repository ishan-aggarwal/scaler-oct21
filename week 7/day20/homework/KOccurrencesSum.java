//Q1. K Occurrences
//Groot has N trees lined up in front of him where the height of the i'th tree is denoted by H[i].
//
//He wants to select some trees to replace his broken branches.
//
//But he wants uniformity in his selection of trees.
//
//So he picks only those trees whose heights have frequency K.
//
//He then sums up the heights that occur K times. (He adds the height only once to the sum and not K times).
//
//But the sum he ended up getting was huge so he prints it modulo 10^9+7.
//
//In case no such cluster exists, Groot becomes sad and prints -1.
//
//Constraints:
//
//1.   1<=N<=100000
//2.   1<=K<=N
//3.   0<=H[i]<=10^9
//Input: Integers N and K and array of size A
//
//Output: Sum of all numbers in the array that occur exactly K times.
//
//Example:
//
//Input:
//
//N=5 ,K=2 ,A=[1 2 2 3 3]
//Output:
//
//5
//Explanation:
//
//There are 3 distinct numbers in the array which are 1,2,3.
//Out of these, only 2 and 3 occur twice. Therefore the answer is sum of 2 and 3 which is 5.

package day20.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KOccurrencesSum {
	public static int getSum(int A, int B, ArrayList<Integer> C) {

		Map<Integer, Integer> freqMap = new HashMap<>();
		int answer = 0;

		for (Integer ele : C) {
			freqMap.put(ele, freqMap.getOrDefault(ele, 0) + 1);
		}

		for (Integer ele : freqMap.keySet()) {
			if (freqMap.get(ele) == B) {
				answer = answer + (ele % 1000000007);
				answer %= 1000000007;
			}
		}

		if (answer == 0) {
			return -1;
		}
		return answer;
	}

	public static void main(String[] args) {
//		N=5 ,K=2 ,A=[1 2 2 3 3]
		ArrayList<Integer> C = new ArrayList<Integer>();
		C.add(1);
		C.add(2);
		C.add(2);
		C.add(3);
		C.add(3);

		System.out.println(getSum(5, 2, C));
	}
}

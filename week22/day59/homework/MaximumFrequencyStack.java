package day59.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Q2. Maximum Frequency stack
//Problem Description
//You are given a matrix A which represents operations of size N x 2. Assume initially you have a stack-like data structure you have to perform operations on it.
//
//Operations are of two types:
//
//1 x: push an integer x onto the stack and return -1.
//
//2 0: remove and return the most frequent element in the stack.
//
//If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
//
//A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.
//
//
//
//Problem Constraints
//1 <= N <= 100000
//
//1 <= A[i][0] <= 2
//
//0 <= A[i][1] <= 109
//
//
//
//Input Format
//The only argument given is the integer array A.
//
//
//
//Output Format
//Return the array of integers denoting the answer to each operation.
//
//
//
//Example Input
//Input 1:
//
//A = [
//            [1, 5]
//            [1, 7]
//            [1, 5]
//            [1, 7]
//            [1, 4]
//            [1, 5]
//            [2, 0]
//            [2, 0]
//            [2, 0]
//            [2, 0]  ]
//Input 2:
//
// A =  [   
//        [1, 5]
//        [2, 0]
//        [1, 4]   ]
//
//
//Example Output
//Output 1:
//
// [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
//Output 2:
//
// [-1, 5, -1]
//
//
//Example Explanation
//Explanation 1:
//
// Just simulate given operations.
//Explanation 2:
//
// Just simulate given operations.

public class MaximumFrequencyStack {

	int maxFrequency = 0;
	Map<Integer, Integer> freqMap = new HashMap<>();
	Map<Integer, Stack<Integer>> groupMap = new HashMap<>();

	public int[] solve(int[][] A) {
		int size = A.length;
		int[] result = new int[size];

		int count = 0;
		for (int[] eachRow : A) {
			if (eachRow[0] == 1) {
				push(eachRow[1]);
				result[count++] = -1;
			} else {
				result[count++] = pop();
			}
		}
		return result;
	}

	private int pop() {
		int val = groupMap.get(maxFrequency).pop();
		freqMap.put(val, freqMap.get(val) - 1);

		if (groupMap.get(maxFrequency).isEmpty()) {
			maxFrequency--;
		}

		return val;
	}

	private void push(int val) {
		int freq = freqMap.getOrDefault(val, 0) + 1;
		freqMap.put(val, freq);
		if (freq > maxFrequency) {
			maxFrequency = freq;
		}

		groupMap.computeIfAbsent(freq, x -> new Stack<>()).push(val);
		// Stack<Integer> groupStack = groupMap.getOrDefault(freq, new Stack<>());
		// groupStack.push(val);
		// groupMap.put(freq, groupStack);
	}

	public static void main(String[] args) {
		int[][] A = { { 1, 4 }, { 2, 0 }, { 1, 9 }, { 2, 0 }, { 1, 6 }, { 1, 6 }, { 2, 0 } };
		MaximumFrequencyStack obj = new MaximumFrequencyStack();
		int[][] B = { { 1, 2 }, { 1, 3 }, { 2, 0 }, { 2, 0 }, { 1, 5 }, { 1, 5 }, { 1, 1 }, { 2, 0 }, { 1, 6 } };
		int[] res = obj.solve(B);
		System.out.println(Arrays.toString(res));

	}
}

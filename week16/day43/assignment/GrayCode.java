package day43.assignment;

import java.util.ArrayList;

//Q2. Gray Code
//Problem Description
//
//The gray code is a binary numeral system where two successive values differ in only one bit.
//
//Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
//
//A gray code sequence must begin with 0.
//
//
//
//Problem Constraints
//
//1 <= A <= 16
//
//
//
//Input Format
//
//First argument is an integer A.
//
//
//
//Output Format
//
//Return an array of integers representing the gray code sequence.
//
//
//
//Example Input
//
//Input 1:
//
//A = 2
//Input 1:
//
//A = 1
//
//
//Example Output
//
//output 1:
//
//[0, 1, 3, 2]
//output 2:
//
//[0, 1]
//
//
//Example Explanation
//
//Explanation 1:
//
//for A = 2 the gray code sequence is:
//    00 - 0
//    01 - 1
//    11 - 3
//    10 - 2
//So, return [0,1,3,2].
//Explanation 1:
//
//for A = 1 the gray code sequence is:
//    00 - 0
//    01 - 1
//So, return [0, 1].

public class GrayCode {
	public static ArrayList<Integer> grayCode(int a) {
		if (a == 1) {
			ArrayList<Integer> base = new ArrayList<Integer>();
			base.add(0);
			base.add(1);
			return base;
		}
		ArrayList<Integer> partialResult = grayCode(a - 1);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < partialResult.size(); i++) {
			ans.add(partialResult.get(i));
		}
		int value = (1 << (a - 1));
		for (int i = partialResult.size() - 1; i >= 0; i--) {
			ans.add(value + partialResult.get(i));
		}
		return ans;
	}

	public static void main(String[] args) {
		ArrayList<Integer> answer = grayCode(3);
		answer.stream().forEach(System.out::println);
	}
}

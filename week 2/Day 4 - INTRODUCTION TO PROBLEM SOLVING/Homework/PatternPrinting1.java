package day4.homework;

import java.util.ArrayList;

public class PatternPrinting1 {
	public static ArrayList<ArrayList<Integer>> solve(int A) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= A; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 1; j <= i; j++) {
				list.add(j);
			}
			for (int j = i + 1; j <= A; j++) {
				list.add(0);
			}
			result.add(list);
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(solve(3));
	}
}

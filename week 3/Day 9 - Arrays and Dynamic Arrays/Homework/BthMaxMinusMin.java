//Given an array of integers A and an integer B, find and return the difference of B’th max element and
//B’th min element of the array A.
//
//
//
//Input Format
//
//The first argument given is the integer array A.
//The second argument given is integer B.
//Output Format
//
//Return the value of B'th max element of A - B'th min element of A.
//Constraints
//
//1 <= B <= length of the array <= 100000
//-10^9 <= A[i] <= 10^9 
//For Example
//
//Input 1:
//    A = [1, 2, 3, 4, 5]
//    B = 2
//Output 1:
//    2   (4 - 2 = 2)
//
//Input 2:
//    A = [5, 17, 100, 11]
//    B = 1
//Output 2:
//    95  (100 - 5 = 95)

package day9.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BthMaxMinusMin {
	public static int solve(ArrayList<Integer> A, int B) {

		Collections.sort(A);
		int length = A.size();

		int bthMax = A.get(length - B);
		int bthMin = A.get(B - 1);

		return bthMax - bthMin;

	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(solve(A, 2));
	}
}

//Problem Description
//
//Given an array of positive integers A, check and return whether the array elements are consecutive or not.
//NOTE: Try this with O(1) extra space.
//
//
//
//Problem Constraints
//1 <= length of the array <= 100000
//1 <= A[i] <= 10^9
//
//
//
//Input Format
//The only argument given is the integer array A.
//
//
//
//Output Format
//Return 1 if the array elements are consecutive else return 0.
//
//
//
//Example Input
//Input 1:
//
// A = [3, 2, 1, 4, 5]
//Input 2:
//
// A = [1, 3, 2, 5]
//
//
//Example Output
//Output 1:
//
// 1
//Output 2:
//
// 0
//
//
//Example Explanation
//Explanation 1:
//
// As you can see all the elements are consecutive, so we return 1.
//Explanation 2:
//
// Element 4 is missing, so we return 0.


package day8.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayWithConsecutiveElements {
    public static int solve(ArrayList<Integer> A) {

        int size = A.size();
        Collections.sort(A);
        int minElement = A.get(0);

        for (int i = 0; i < size; i++) {
            if (A.get(i) != minElement + i) {
                return 0;
            } 
        }
        return 1;
    }
    
    public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(3, 2, 1, 4, 5));
		System.out.println(solve(A));
	}
}

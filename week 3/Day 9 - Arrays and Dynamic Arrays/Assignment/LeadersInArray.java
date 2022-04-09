//Problem Description
//
//Given an integer array A containing N distinct integers, you have to find all the leaders in the array A.
//
//An element is leader if it is strictly greater than all the elements to its right side.
//
//NOTE:The rightmost element is always a leader.
//
//
//
//Problem Constraints
//1 <= N <= 105
//
//1 <= A[i] <= 108
//
//
//
//Input Format
//First and only argument is an integer array A.
//
//
//
//Output Format
//Return an integer array denoting all the leader elements of the array.
//
//NOTE: Ordering in the output doesn't matter.
//
//
//
//Example Input
//Input 1:
//
// A = [16, 17, 4, 3, 5, 2]
//Input 2:
//
// A = [1, 2]
//
//
//Example Output
//Output 1:
//
// [17, 2, 5]
//Output 2:
//
// [2]
//
//
//Example Explanation
//Explanation 1:
//
// Element 17 is strictly greater than all the elements on the right side to it.
// Element 2 is strictly greater than all the elements on the right side to it.
// Element 5 is strictly greater than all the elements on the right side to it.
// So we will return this three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.
//Explanation 2:
//
// Only 2 the rightmost element is the leader in the array.

package day9.assignments;

import java.util.ArrayList;
import java.util.Arrays;

public class LeadersInArray {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        int size = A.size();
        int max_from_right =  A.get(size-1); 
      
        ArrayList<Integer> ans = new ArrayList<>();
        /* Rightmost element is always leader */
        ans.add(A.get(size-1));
        
        for (int i = size-2; i >= 0; i--) 
        { 
            if (max_from_right < A.get(i)) 
            {            
                max_from_right = A.get(i);
                ans.add(max_from_right);
            } 
        }
        return ans;
    }

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(16, 17, 4, 3, 5, 2));
		System.out.println(solve(A));
	}
}

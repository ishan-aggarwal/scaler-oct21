//Problem Description
//
//Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.
//
//
//
//Input Format
//First and only argument is an integer array A.
//
//
//
//Output Format
//Return 1 if any such integer p is found else return -1.
//
//
//
//Example Input
//Input 1:
//
// A = [3, 2, 1, 3]
//Input 2:
//
// A = [1, 1, 3, 3]
//
//
//Example Output
//Output 1:
//
// 1
//Output 2:
//
// -1
//
//
//Example Explanation
//Explanation 1:
//
// For integer 2, there are 2 greater elements in the array. So, return 1.
//Explanation 2:
//
// There is no such integer exists.


package day9.assignments;

import java.util.ArrayList;
import java.util.Collections;

public class NobleInteger {
    public int solve(ArrayList<Integer> A) {

        Collections.sort(A);
        int size = A.size();
        for(int i = 0; i < size; i++){
        	while(i+1<size && A.get(i)==A.get(i+1))
        		i++;
        	if(A.get(i) == size-1-i)
        		return 1;
        }
        return -1;

    }
}

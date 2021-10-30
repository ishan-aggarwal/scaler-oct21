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

        int len = A.size();
        Collections.sort(A);

        // base condition where all the elements in the array are negative and one element is zero
        if (A.get(len - 1) == 0) {
            return 1;
        }

        for (int i = 0; i < len - 1; i++) {
            int currElement = A.get(i);
            if (currElement == (len - i -1) && currElement != A.get(i + 1)) {
                return 1;
            }
        }


        // return -1;

        // for (int i = 0; i < len; i++) {
        //     int currElement = A.get(i);
        //     int totalElementsGreaterThanCurrElement = 0;
        //     for (int j = 0; j < len; j++) {
        //         if (A.get(j) > currElement) {
        //             totalElementsGreaterThanCurrElement++;
        //         }
        //     }

        //     if (totalElementsGreaterThanCurrElement == currElement) {
        //         return 1;
        //     }
        // }

        return -1;
    }
}

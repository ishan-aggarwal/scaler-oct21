//Q4. Row Sum
//
//Problem Description
//
//You are given a 2D integer matrix A, return a 1D integer vector containing row-wise sums of original matrix.
//
//
//
//Problem Constraints
//
//1 <= A.size() <= 103
//
//1 <= A[i].size() <= 103
//
//1 <= A[i][j] <= 103
//
//
//
//Input Format
//
//First argument is a vector of vector of integers.(2D matrix).
//
//
//
//Output Format
//
//Return a vector conatining row-wise sums of original matrix.
//
//
//
//Example Input
//
//Input 1:
//
//[1,2,3,4]
//[5,6,7,8]
//[9,2,3,4]
//
//
//Example Output
//
//Output 1:
//
//{10,26,18}
//
//
//Example Explanation
//
//Explanation 1
//
//Row 1 = 1+2+3+4 = 10
//Row 2 = 5+6+7+8 = 26
//Row 3 = 9+2+3+4 = 18

package day13.homework;

import java.util.ArrayList;

public class MatrixRowSum {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {

        ArrayList<Integer> rowSum = new ArrayList<>();

        int rows = A.size();
        int cols = A.get(0).size();
        // int currentRowSum;

        for (int i = 0; i < rows; i++) {
            int currentRowSum = 0;

            for (int j = 0; j < cols; j++) {

                currentRowSum += A.get(i).get(j);

            }

            rowSum.add(currentRowSum);
        }

        return rowSum;

    }
}

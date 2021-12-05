//Q2. Anti Diagonals
//
//Problem Description
//
//Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.
//
//Problem Constraints
//
//1<= N <= 1000
//1<= A[i][j] <= 1e9
//
//
//Input Format
//
//First argument is an integer N, denoting the size of square 2D matrix.
//Second argument is a 2D array A of size N * N.
//
//
//Output Format
//
//Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
//The vacant spaces in the grid should be assigned to 0.
//
//
//Example Input
//
//Input 1:
//3
//1 2 3
//4 5 6
//7 8 9
//Input 2:
//
//1 2
//3 4
//
//
//Example Output
//
//Output 1:
//1 0 0
//2 4 0
//3 5 7
//6 8 0
//9 0 0
//Output 2:
//
//1 0
//2 3
//4 0
//
//
//Example Explanation
//
//For input 1:
//The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
//The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
//The third anti diagonal of the matrix is [3, 5, 7 ], the rest spaces shoud be filled with 0 making the row as [3, 5, 7].
//The fourth anti diagonal of the matrix is [6, 8 ], the rest spaces shoud be filled with 0 making the row as [6, 8, 0].
//The fifth anti diagonal of the matrix is [9 ], the rest spaces shoud be filled with 0 making the row as [9, 0, 0].
//For input 2:
//
//The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
//The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
//The third anti diagonal of the matrix is [3, 0, 0 ], the rest spaces shoud be filled with 0 making the row as [3, 0, 0].

package day13.assignments;

import java.util.ArrayList;

public class AntiDiagonalsProblem {
    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
    
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int size = A.size();

        for (int j = 0; j < size; j++) {
            result.add(prepareAntiDiagonal(0, j, size, A));
        }

        for (int i = 1; i < size; i++) {
            result.add(prepareAntiDiagonal(i, size-1, size, A));
        }

        return result;
    }


    private static ArrayList<Integer> prepareAntiDiagonal(int startI, int startJ, int size, ArrayList<ArrayList<Integer>> A) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        int i = startI;
        int j = startJ;
        int n = size;
        int count = 0;

        while ( i < n && j >= 0) {
            ans.add(A.get(i).get(j));
            i++;
            j--;
            count++;
        }

        while (count < size) {
            ans.add(0);
            count++;
        }
        return ans;
    }
    
    public static void main(String[] args) {
		
	}

}

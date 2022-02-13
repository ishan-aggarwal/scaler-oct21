package day45.homework;

import java.util.Arrays;
import java.util.Comparator;

//Q3. B Closest Points to Origin

//Problem Description
//
//We have a list A, of points(x,y) on the plane. Find the B closest points to the origin (0, 0).
//
//Here, the distance between two points on a plane is the Euclidean distance.
//
//You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
//
//NOTE: Euclidean distance between two points P1(x1,y1) and P2(x2,y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).
//
//
//
//Problem Constraints
//
//1 <= B <= length of the list A <= 100000
//-100000 <= A[i][0] <= 100000
//-100000 <= A[i][1] <= 100000
//
//
//
//Input Format
//
//The argument given is list A and an integer B.
//
//
//
//Output Format
//
//Return the B closest points to the origin (0, 0) in any order.
//
//
//
//Example Input
//
//Input 1:
//
// A = [ 
//       [1, 3],
//       [-2, 2] 
//     ]
// B = 1
//Input 2:
//
// A = [
//       [1, -1],
//       [2, -1]
//     ] 
// B = 1
//
//
//Example Output
//
//Output 1:
//
// [ [-2, 2] ]
//Output 2:
//
// [ [1, -1] ]
//
//
//Example Explanation
//
//Explanation 1:
//
// The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
// So one closest point will be [-2,2].
//Explanation 2:
//
// The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
// So one closest point will be [1,-1].

public class BClosestPoints {
	public static int[][] solve(int[][] A, int B) {

		Arrays.sort(A, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				double d1 = Math.pow((double) o1[0] - 0, 2) + Math.pow((double) o1[1] - 0, 2);
				double d2 = Math.pow((double) o2[0] - 0, 2) + Math.pow((double) o2[1] - 0, 2);
				return (int) (d1 - d2);
			}
		});

		int[][] result = Arrays.copyOf(A, B);
		return result;
	}

	public static void main(String[] args) {
		int[][] A = { { 1, 3 }, { -2, 2 } };
		int B = 1;

		int[][] result = solve(A, B);
		for (int[] entry : result) {
			System.out.println("{" + entry[0] + ", " + entry[1] + "}");
		}
	}
}

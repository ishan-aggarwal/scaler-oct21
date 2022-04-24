package week27.day70.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Q1. B Closest Points to Origin
//Problem Description
//We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
//
//Here, the distance between two points on a plane is the Euclidean distance.
//
//You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
//
//NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).
// 
//
//
//Problem Constraints
//1 <= B <= length of the list A <= 105
//-105 <= A[i][0] <= 105
//-105 <= A[i][1] <= 105
//
//
//
//Input Format
//The argument given is list A and an integer B.
//
//
//
//Output Format
//Return the B closest points to the origin (0, 0) in any order.
//
//
//
//Example Input
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
//Output 1:
//
// [ [-2, 2] ]
//Output 2:
//
// [ [1, -1] ]
//
//
//Example Explanation
//Explanation 1:
//
// The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
// So one closest point will be [-2,2].
//Explanation 2:
//
// The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
// So one closest point will be [1,-1].

public class BClosestPointsToOrigin {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class PointComparator implements Comparator<Point> {
		public int compare(Point o1, Point o2) {
			return Double.compare(dist(o1), dist(o2));
		}

		private double dist(Point p) {
			return Math.sqrt(p.x * p.x + p.y * p.y);
		}
	}

	public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
		PriorityQueue<Point> pq = new PriorityQueue<>(new PointComparator());
		for (ArrayList<Integer> list : A) {
			pq.add(new Point(list.get(0), list.get(1)));
		}
		ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		for (int i = 1; i <= B; i++) {
			Point p = pq.poll();
			ArrayList<Integer> list = new ArrayList<>();
			list.add(p.x);
			list.add(p.y);
			output.add(list);
		}
		return output;
	}

	public static void main(String[] args) {
		int B = 1;
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		A.add(new ArrayList<>(Arrays.asList(1, 3)));
		A.add(new ArrayList<>(Arrays.asList(-2, 2)));
		System.out.println(solve(A, B));
	}
}

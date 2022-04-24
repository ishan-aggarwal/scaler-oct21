package week27.day71.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//Q2. N max pair combinations

//Problem Description
//Given two integers arrays, A and B, of size N each.
//
//Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in arrays A and B.
//
//
//
//Problem Constraints
//1 <= N <= 2 * 105
//
//-1000 <= A[i], B[i] <= 1000
//
//
//
//Input Format
//The first argument is an integer array A.
//The second argument is an integer array B.
//
//
//
//Output Format
//Return an integer array denoting the N maximum element in descending order.
//
//
//
//Example Input
//Input 1:
//
// A = [1, 4, 2, 3]
// B = [2, 5, 1, 6]
//Input 2:
//
// A = [2, 4, 1, 1]
// B = [-2, -3, 2, 4]
//
//
//Example Output
//Output 1:
//
// [10, 9, 9, 8]
//Output 2:
//
// [8, 6, 6, 5]
//
//
//Example Explanation
//Explanation 1:
//
// 4 maximum elements are 10(6+4), 9(6+3), 9(5+4), 8(6+2).
//Explanation 2:
//
// 4 maximum elements are 8(4+4), 6(4+2), 6(4+2), 5(4+1).

public class NMaxPairCombinations {
	public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		PriorityQueue<HeapNode> maxHeap = new PriorityQueue<>((o1, o2) -> o2.nodeSum - o1.nodeSum);
		int n = A.size();
		ArrayList<Integer> result = new ArrayList<>();
		Collections.sort(A, Comparator.reverseOrder());
		Collections.sort(B, Comparator.reverseOrder());
		Set<String> usedPairs = new HashSet<>();
		maxHeap.add(new HeapNode(0, 0, A.get(0) + B.get(0)));
		while (result.size() < A.size()) {
			HeapNode currNode = maxHeap.remove();
			String indexPair = currNode.indexA + "#" + currNode.indexB;
			if (!usedPairs.contains(indexPair)) {
				usedPairs.add(indexPair);
				result.add(currNode.nodeSum);
			}
			if (result.size() == A.size()) {
				break;
			}
			int indexA = currNode.indexA + 1;
			int indexB = currNode.indexB + 1;
			if (indexA < n && !usedPairs.contains(indexA + "#" + currNode.indexB)) {
				maxHeap.add(new HeapNode(indexA, currNode.indexB, A.get(indexA) + B.get(currNode.indexB)));
			}
			if (indexB < n && !usedPairs.contains(currNode.indexA + "#" + indexB)) {
				maxHeap.add(new HeapNode(currNode.indexA, indexB, A.get(currNode.indexA) + B.get(indexB)));
			}
		}
		return result;
	}

	static class HeapNode {
		int indexA;
		int indexB;
		int nodeSum;

		HeapNode(int i, int j, int num) {
			this.indexA = i;
			this.indexB = j;
			this.nodeSum = num;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 4, 2, 3 };
		int[] b = { 2, 5, 1, 6 };
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		for (int e : a)
			A.add(e);
		for (int e : b)
			B.add(e);
		
		System.out.println(solve(A, B));
	}
}

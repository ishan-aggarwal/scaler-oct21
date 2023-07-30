package day32.classroom;

//Q2. Rain Water Trapped

//Problem Description
//
//Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//
//
//Problem Constraints
//
//1 <= |A| <= 100000
//
//
//
//Input Format
//
//First and only argument is the vector A
//
//
//
//Output Format
//
//Return one integer, the answer to the question
//
//
//
//Example Input
//
//Input 1:
//
//A = [0, 1, 0, 2]
//Input 2:
//
//A = [1, 2]
//
//
//Example Output
//
//Output 1:
//
//1
//Output 2:
//
//0
//
//
//Example Explanation
//
//Explanation 1:
//
//1 unit is trapped on top of the 3rd element.
//Explanation 2:
//
//No water is trapped.

public class RainWaterTrapped {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int trap(final int[] A) {

        int n = A.length;

        // using a single array to manage the height of buildings
        int[] height = new int[n];

        int answer = 0;
        int leftMax = 0, rightMax = 0;

        height[0] = A[0];
        height[n - 1] = A[n - 1];

        for (int i = 1, j = n - 2; i < n - 1 && j >= 1; i++, j--) {
            leftMax = Math.max(A[i], height[i - 1]);
            rightMax = Math.max(A[j], height[j + 1]);

            height[i] = height[i] != 0 ? Math.min(height[i], leftMax) : leftMax;
            height[j] = height[j] != 0 ? Math.min(height[j], rightMax) : rightMax;
        }

        // minimum of the heights of the building on left or right side minus the heigth
        // of ith building
        for (int i = 0; i < n; i++) {
            answer += height[i] - A[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 0, 2};
        System.out.println(trap(A));
    }
}

//Q1. Length of longest consecutive ones
//Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.
//
//
//Input Format
//
//The only argument given is string A.
//Output Format
//
//Return the length of the longest consecutive 1’s that can be achieved.
//Constraints
//
//1 <= length of string <= 1000000
//A contains only characters 0 and 1.
//For Example
//
//Input 1:
//    A = "111000"
//Output 1:
//    3
//
//Input 2:
//    A = "111011101"
//Output 2:
//    7

package day14.assignments;
public class LengthOfLongestConsecutiveOnes {
    public int solve(String A) {

        int n = A.length();

        int onesCount = 0;
        int maxOnesByOneSwap = 0, temp = 0;

		for (int i = 0; i < n; i++) {
			if (A.charAt(i) == '1') {
				onesCount++;
				temp++;
			} else {
				maxOnesByOneSwap = Math.max(maxOnesByOneSwap, temp);
				temp = 0;
			}
		}
		maxOnesByOneSwap = Math.max(maxOnesByOneSwap, temp);

        int[] left = new int[n];
		int right[] = new int[n];

		if (A.charAt(0) == '1') {
			left[0] = 1;
        } else {
			left[0] = 0;
        }

		if (A.charAt(n - 1) == '1') {
			right[n - 1] = 1;
        } else {
			right[n - 1] = 0;
        }

        for (int i = 1; i < n; i++) {
			if (A.charAt(i) == '1') {
				left[i] = left[i - 1] + 1;
            } else {
				left[i] = 0;
            }
		}

		for (int i = n - 2; i >= 0; i--) {
			if (A.charAt(i) == '1') {
				right[i] = right[i + 1] + 1;
            } else {
				right[i] = 0;
            }
		}

        
        for (int i = 1; i < n - 1; i++) {
			if (A.charAt(i) == '0') {
				int sum = left[i - 1] + right[i + 1];
				if (sum < onesCount) {
					maxOnesByOneSwap = Math.max(maxOnesByOneSwap, sum + 1);
                } else {
					maxOnesByOneSwap = Math.max(maxOnesByOneSwap, sum);
                }
			}
		}
		return maxOnesByOneSwap;
    }
}

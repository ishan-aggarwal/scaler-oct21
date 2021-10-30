//Problem Description
//<div id=problem_description_markdown_content_value style=”background-color: #f9f9f9; padding: 5px 10px; “>Given an integer array A of size N. In one second you can increase the value of one element by 1.
//
//
//Find the minimum time in seconds to make all elements of the array equal.<p></p>
//
//</div>
//
//Problem Constraints
//<div id=problem_constraints_markdown_content_value style=”background-color: #f9f9f9; padding: 5px 10px; “>1 <= N <= 1000000<p></p><p></p>
//1 <= A[i] <= 1000
//
//</div>
//
//Input Format
//<div id=input_format_markdown_content_value style=”background-color: #f9f9f9; padding: 5px 10px; “>First argument is an integer array A.</div>
//
//Output Format
//<div id=output_format_markdown_content_value style=”background-color: #f9f9f9; padding: 5px 10px; “>Return an integer denoting the minimum time to make all elements equal.</div>
//
//Example Input
//<div id=example_input_markdown_content_value style=”background-color: #f9f9f9; padding: 5px 10px; “>A = [2, 4, 1, 3, 2] </div>
//
//Example Output
//<div id=example_output_markdown_content_value style=”background-color: #f9f9f9; padding: 5px 10px; “>8 </div>
//
//Example Explanation
//<div id=example_explanation_markdown_content_value style=”background-color: #f9f9f9; padding: 5px 10px; “>We can change the array A = [4, 4, 4, 4, 4].
//The time required will be 8 seconds.</div>

package day9.assignments;

import java.util.ArrayList;
import java.util.Arrays;

public class TimeToEquality {
	public static int solve(ArrayList<Integer> A) {

		Integer maxElement = Integer.MIN_VALUE;
		Integer totalOperations = 0;
		for (Integer element : A) {
			if (element > maxElement) {
				maxElement = element;
			}
		}
		for (Integer element : A) {
			totalOperations += Math.abs(maxElement - element);
		}

		return totalOperations;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(2, 4, 1, 3, 2));
		System.out.println(solve(A));
	}
}

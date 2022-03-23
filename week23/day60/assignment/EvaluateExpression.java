package day60.assignment;

import java.util.Stack;

//Q1. Evaluate Expression

//Problem Description
//An arithmetic expression is given by a character array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, /. Each character may be an integer or an operator.
//
//
//
//Problem Constraints
//1 <= N <= 105
//
//
//
//Input Format
//The only argument given is character array A.
//
//
//
//Output Format
//Return the value of arithmetic expression formed using reverse Polish Notation.
//
//
//
//Example Input
//Input 1:
//    A =   ["2", "1", "+", "3", "*"]
//Input 2:
//    A = ["4", "13", "5", "/", "+"]
//
//
//Example Output
//Output 1:
//    9
//Output 2:
//    6
//
//
//Example Explanation
//Explaination 1:
//    starting from backside:
//    * : () * ()
//    3 : () * (3)
//    + : (() + ()) * (3)
//    1 : (() + (1)) * (3)
//    2 : ((2) + (1)) * (3)
//    ((2) + (1)) * (3) = 9
//Explaination 2:
//    + : () + ()
//    / : () + (() / ())
//    5 : () + (() / (5))
//    13 : () + ((13) / (5))
//    4 : (4) + ((13) / (5))
//    (4) + ((13) / (5)) = 6

public class EvaluateExpression {
	public static int evalRPN(String[] A) {

		Stack<String> stack = new Stack<>();
		int first, second;
		for (String item : A) {

			switch (item) {
			case "*":
				second = Integer.parseInt(stack.pop());
				first = Integer.parseInt(stack.pop());
				stack.push(String.valueOf(1l * first * second));
				break;
			case "+":
				second = Integer.parseInt(stack.pop());
				first = Integer.parseInt(stack.pop());
				stack.push(String.valueOf(first + second));
				break;

			case "-":
				second = Integer.parseInt(stack.pop());
				first = Integer.parseInt(stack.pop());
				stack.push(String.valueOf(first - second));
				break;
			case "/":
				second = Integer.parseInt(stack.pop());
				first = Integer.parseInt(stack.pop());
				stack.push(String.valueOf(first / second));
				break;
			default:
				stack.push(item);
				break;
			}
		}
		return Integer.parseInt(stack.pop());
	}

	public static void main(String[] args) {
		String[] A = { "2", "1", "+", "3", "*" };
		System.out.println(evalRPN(A));
	}
}

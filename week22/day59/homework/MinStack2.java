package day59.homework;

//Q1. Min Stack

//Problem Description
//Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
//
//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//top() -- Get the top element.
//getMin() -- Retrieve the minimum element in the stack.
//NOTE:
//
//All the operations have to be constant time operations.
//getMin() should return -1 if the stack is empty.
//pop() should return nothing if the stack is empty.
//top() should return -1 if the stack is empty.
//
//
//Problem Constraints
//1 <= Number of Function calls <= 107
//
//
//
//Input Format
//Functions will be called by the checker code automatically.
//
//
//
//Output Format
//Each function should return the values as defined by the problem statement.
//
//
//
//Example Input
//Input 1:
//
//push(1)
//push(2)
//push(-2)
//getMin()
//pop()
//getMin()
//top()
//Input 2:
//
//getMin()
//pop()
//top()
//
//
//Example Output
//Output 1:
//
// -2 1 2
//Output 2:
//
// -1 -1
//
//
//Example Explanation
//Explanation 1:
//
//Let the initial stack be : []
//1) push(1) : [1]
//2) push(2) : [1, 2]
//3) push(-2) : [1, 2, -2]
//4) getMin() : Returns -2 as the minimum element in the stack is -2.
//5) pop() : Return -2 as -2 is the topmost element in the stack.
//6) getMin() : Returns 1 as the minimum element in stack is 1.
//7) top() : Return 2 as 2 is the topmost element in the stack.
//Explanation 2:
//
//Let the initial stack be : []
//1) getMin() : Returns -1 as the stack is empty.
//2) pop() :  Returns nothing as the stack is empty.
//3) top() : Returns -1 as the stack is empty.

import java.util.Stack;

// TC - O(1) for all the operations
// SC - O(N) for maintaining a separate min stack
public class MinStack2 {

	Stack<Integer> stack = new Stack<>();
	Integer minV = Integer.MIN_VALUE;

	public void push(int x) {
		// x new element
		if (x >= minV) {
			// minV is not changing
			stack.push(x);
		} else { // x < minV

			stack.push(2 * x - minV);
			minV = x;
			// x is new minimum
		}
	}

	public void pop() {
		int x = stack.peek();
		if (x >= minV) {
			stack.pop();
			// minV not change
		} else {
			minV = 2 * minV - x;
			stack.pop();
		}
	}

	public int top() {

		if (stack.isEmpty()) {
			return -1;
		}

		int x = stack.peek();
		if (x >= minV) {
			return x;
		}
		return minV;

	}

	public int getMin() {

		if (stack.isEmpty()) {
			return -1;
		}

		return minV;
	}

	public static void main(String[] args) {
		MinStack2 obj = new MinStack2();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
	}
}

package day59.assignment;

import java.util.Stack;

//Q3. Simplify Directory Path
//Given a string A representing an absolute path for a file (Unix-style).
//
//Return the string A after simplifying the absolute path.
//
//Note:
//
//Absolute path always begin with '/' ( root directory ).
//
//Path will not have whitespace characters.
//
//
//Input Format
//
//The only argument given is string A.
//Output Format
//
//Return a string denoting the simplified absolue path for a file (Unix-style).
//For Example
//
//Input 1:
//    A = "/home/"
//Output 1:
//    "/home"
//
//Input 2:
//    A = "/a/./b/../../c/"
//Output 2:
//    "/c"

public class SimplifyDirectoryPath {
	public String simplifyPath(String A) {

		Stack<String> stack = new Stack<>();
		Stack<String> otherStack = new Stack<>();
		StringBuilder output = new StringBuilder("");

		String[] directoryOps = A.split("/");
		for (String operation : directoryOps) {
			if (operation.equals("")) {
				continue;
			}
			if ("..".equals(operation)) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (!".".equals(operation)) {
				stack.push(operation);
			}
		}

		while (!stack.isEmpty()) {
			otherStack.push(stack.pop());
		}

		while (!otherStack.isEmpty()) {
			output.append("/");
			output.append(otherStack.pop());
		}

		return output.length() == 0 ? "/" : output.toString();
	}

	public static void main(String[] args) {
		SimplifyDirectoryPath obj = new SimplifyDirectoryPath();
//		System.out.println(obj.simplifyPath("/a/./b/../../c/"));
//		System.out.println(obj.simplifyPath("/home/"));
		System.out.println(obj.simplifyPath("/../"));
	}
}

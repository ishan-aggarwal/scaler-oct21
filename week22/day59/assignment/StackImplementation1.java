package day59.assignment;

public class StackImplementation1 {

	static class StackOverFlowException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String msg;

		public StackOverFlowException(String message) {
			super(message);
			this.msg = message;
		}
	}

	static class StackUnderFlowException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String msg;

		public StackUnderFlowException(String message) {
			super(message);
			this.msg = message;
		}
	}

	/**
	 * This is array based stack where all the operations are supported like push(),
	 * pop(), peek() and isEmpty() All these operations are done in O(1) TC Note:
	 * size of the array is fixed. To make it dynamic, either we should use
	 * List/Vector or LinkedList based implementation
	 * 
	 * @author toish
	 *
	 */
	static class Stack_ArrayBased {
		int top;
		int[] arr;
		final int MAX_SIZE = 5;

		public Stack_ArrayBased() {
			super();
			this.arr = new int[MAX_SIZE];
			this.top = -1;
		}

		public void push(int val) throws StackOverFlowException {
			if (top == MAX_SIZE - 1) {
				throw new StackOverFlowException("Stack is full");
			}
			arr[++top] = val;
		}

		public void pop() throws StackUnderFlowException {
			if (top == -1) {
				throw new StackUnderFlowException("Stack is empty");
			}
			top--;
		}

		public int peek() throws StackUnderFlowException {
			if (top == -1) {
				throw new StackUnderFlowException("Stack is empty");
			}
			return arr[top];
		}

		public boolean isEmpty() {
			if (top == -1) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) throws StackOverFlowException, StackUnderFlowException {
		Stack_ArrayBased stack = new Stack_ArrayBased();
		stack.push(10);
		stack.push(20);
		stack.push(5);
		stack.push(9);
		stack.push(50);
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
	}

}

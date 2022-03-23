package day59.assignment;

public class StackImplementation2 {

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

	static class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}

	static class Stack_LinkedListBased {
		Node head;

		public Stack_LinkedListBased() {
			super();
			this.head = null;
		}

		public void push(int val) {
			Node temp = new Node(val);
			if (head == null) {
				head = temp;
			} else {
				temp.next = head;
				head = temp;
			}
		}

		public void pop() throws StackUnderFlowException {
			if (head == null) {
				throw new StackUnderFlowException("Stack is empty");
			}
			head = head.next;
		}

		public int peek() throws StackUnderFlowException {
			if (head == null) {
				throw new StackUnderFlowException("Stack is empty");
			}
			return head.value;
		}

		public boolean isEmpty() {
			if (head == null) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) throws StackUnderFlowException {
		Stack_LinkedListBased stack = new Stack_LinkedListBased();
		System.out.println(stack.isEmpty());
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

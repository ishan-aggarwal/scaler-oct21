package day61.classwork;

import java.util.Stack;

// Note:
// For 1st peek/dequeue operation -> N iterations
// for the next (n-1) operations -> 1 iteration each
// so total number of iterations -> N + (N-1)
// perform N dequeue requests = (2N - 1)
// Average number of iterations = (2N-1) / N ~ O(1) Amortized TC
public class QueueUsingStacks {

	private Stack<Integer> enqueueStack;
	private Stack<Integer> dequeueStack;
	private int size;

	public QueueUsingStacks() {
		super();
		this.enqueueStack = new Stack<>();
		this.dequeueStack = new Stack<>();
		this.size = 0;
	}

	// TC - O(1)
	public void enqueue(int element) {
		enqueueStack.push(element);
		// increase the size by 1
		++size;
	}

	public Integer dequeue() {
		if (size == 0) {
			throw new RuntimeException("Queue is empty");
		}
		// decrease the size by 1
		size--;
		Integer element;
		if (dequeueStack.isEmpty()) {
			while (!enqueueStack.isEmpty()) {
				dequeueStack.push(enqueueStack.pop());
			}
		}
		element = dequeueStack.pop();
		return element;
	}

	// TC - O(1)
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public Integer front() {
		if (size == 0) {
			throw new RuntimeException("Queue is empty");
		}
		if (dequeueStack.isEmpty()) {
			while (!enqueueStack.isEmpty()) {
				dequeueStack.push(enqueueStack.pop());
			}
		}
		return dequeueStack.peek();
	}

	// TC - O(1)
	public int size() {
		return this.size;
	}

	public static void main(String[] args) {
		QueueUsingStacks queue = new QueueUsingStacks();

		System.out.println("Size: " + queue.size());
		queue.enqueue(7);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(4);
		System.out.println("Size: " + queue.size());
		System.out.println("Front: " + queue.front());
		System.out.println("Poll: " + queue.dequeue());
		System.out.println("Front: " + queue.front());
		System.out.println("Size: " + queue.size());
		queue.enqueue(10);
		System.out.println("Size: " + queue.size());
	}
}

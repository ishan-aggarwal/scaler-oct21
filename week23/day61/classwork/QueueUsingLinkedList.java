package day61.classwork;

// Note all these operations are performed to support O(1) TC
// using the two pointers
public class QueueUsingLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;
	private Node front;
	private Node rear;
	private int size;

	public QueueUsingLinkedList() {
		super();
		this.head = null; // starting element of the queue
		this.front = null; // front points to the most recently deleted element
		this.rear = null; // rear points to the most recently inserted element
		this.size = 0;
	}

	public void enqueue(int element) {

		Node newNode = new Node(element);
		if (rear == null) {
			rear = newNode;
			head = newNode;
		} else {
			rear.next = newNode;
			rear = rear.next;
		}
		// increase the size by 1
		++size;
	}

	public Integer dequeue() {
		if (front == rear || size == 0) {
			throw new RuntimeException("Queue is empty");
		}
		// decrease the size by 1
		size--;

		front = head;
		head = head.next;

		// return the element if needed
		return front.data;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public Integer peek() {
		if (front == rear || size == 0) {
			throw new RuntimeException("Queue is empty");
		}

		return head.data;
//		return front.next.data;
	}

	public int size() {
		return this.size;
	}

	public static void main(String[] args) {
		QueueUsingLinkedList queue = new QueueUsingLinkedList();

		System.out.println("Size: " + queue.size());
		queue.enqueue(7);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(4);
		System.out.println("Size: " + queue.size());
		System.out.println("Front: " + queue.peek());
		System.out.println("Poll: " + queue.dequeue());
		System.out.println("Front: " + queue.peek());
		System.out.println("Size: " + queue.size());
	}
}

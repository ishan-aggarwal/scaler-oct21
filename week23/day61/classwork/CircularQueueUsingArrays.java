package day61.classwork;

// Note all these operations are performed to support O(1) TC
// using the two pointers
// Note:
// rear -> last element of the queue (most recently pushed element)
// front -> most recently deleted element index
// elements in the queue are from : [(f+1), r] 
public class CircularQueueUsingArrays {

	private static final int MAX_SIZE = 5;
	private int front;
	private int rear;
	private int[] data;
	private int size;

	public CircularQueueUsingArrays() {
		super();
		this.front = -1; // front points to the most recently deleted element
		this.rear = -1; // rear points to the most recently inserted element
		this.data = new int[MAX_SIZE];
		this.size = 0;
	}

	public void enqueue(int element) {
		if (size == MAX_SIZE) {
			throw new RuntimeException("Queue is full");
		}
		// increment rear
		rear = (rear + 1) % MAX_SIZE;
		// insert the element at rear position
		data[rear] = element;
		// increase the size by 1
		++size;
	}

	public Integer dequeue() {
		if (size == 0) {
			throw new RuntimeException("Queue is empty");
		}
		// decrease the size by 1
		size--;
		// adjust the front pointer to the recently deleted element
		front = (front + 1) % MAX_SIZE;
		// store the element by increasing the front pointer
		Integer element = data[front];

		// return the element if needed
		return element;
	}

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
		return data[(front + 1) % MAX_SIZE];
	}

	public int size() {
		return this.size;
	}

	public static void main(String[] args) {
		CircularQueueUsingArrays queue = new CircularQueueUsingArrays();

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
		queue.enqueue(20);
		System.out.println("Size: " + queue.size());
//		queue.enqueue(30);
		System.out.println("Front: " + queue.front());
	}
}

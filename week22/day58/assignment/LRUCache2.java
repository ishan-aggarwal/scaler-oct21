package day58.assignment;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

	static class Node {
		int key;
		int val;
		Node next;
		Node prev;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
			this.next = null;
			this.prev = null;
		}
	}

	// dummy node to point to take care of edge cases
	private Node dummy;

	// at start, head and tail points to dummy node
	private Node head;
	private Node last;

	// represents the max capacity of LRU cache
	private int capacity;

	// hashMap of key and reference to the node
	// hashmap is taken to find if data is present in O(1) time
	private Map<Integer, Node> hm;

	public LRUCache2(int capacity) {
		this.capacity = capacity;
		this.hm = new HashMap<>();
		this.dummy = new Node(-1, -1);
		this.head = dummy;
		this.last = dummy;
	}

	public int get(int key) {

		// check if key is present in the hashmap or not
		if (hm.containsKey(key)) {

			// Get Node reference from the hashmap
			Node node = hm.get(key);

			// get data from the node
			int val = node.val;

			// Note: We can add special case if this is already the last node
			// no need to perform removal and additions
			if (node != last) {
				// remove the node from current location
				remove(node);

				// insert the node at the back again to make it recently used
				insertAtBack(node);
			}

			return val;
		}

		// return -1 if key is not present in the map
		return -1;
	}

	public void set(int key, int value) {

		// check if key is present in the hashmap or not
		if (hm.containsKey(key)) {

			// Get Node reference from the hashmap
			Node node = hm.get(key);

			// set new value inside node
			node.val = value;

			// Note: We can add special case if this is already the last node
			// no need to perform removal and additions

			if (node != last) {
				// remove the node from current location
				remove(node);

				// insert the node at the back again to make it recently used
				insertAtBack(node);
			}

		} else {

			// create new node
			Node node = new Node(key, value);

			// if hashmap size is already full (same as maximum capacity)
			// erase the first node of the linked list
			if (hm.size() == capacity) {
				// remove the entry from hashmap
				hm.remove(head.next.key);
				// remove the node from doubly linked list
				remove(head.next);
			}

			// put key and node in the map
			hm.put(key, node);

			// insert the node at the back
			insertAtBack(node);
		}
	}

	private void insertAtBack(Node node) {
		// adjust next pointer of last
		last.next = node;

		// adjust the previous pointer for node
		node.prev = last;

		// move last to the newly added node
		last = node;
	}

	private void remove(Node node) {

		// set next pointer for previous node
		node.prev.next = node.next;

		// in case node to be removed is the last node
		if (node == last || node.next == null) {
			// adjust the last pointer
			last = node.prev;
		} else {
			// set previous pointer for next node
			node.next.prev = node.prev;
		}
	}

	public static void main(String[] args) {
		LRUCache2 cache = new LRUCache2(1);
		cache.set(2, 1);
		cache.set(2, 2);
		System.out.println(cache.get(2));
		cache.set(1, 1);
		cache.set(4, 1);
		System.out.println(cache.get(2));

//		cache.set(5, 4);
//		System.out.println(cache.get(5));
//		cache.set(10, 11);
//		System.out.println(cache.get(7));
//		System.out.println(cache.get(2));
//		cache.set(12, 6);
//		cache.set(15, 1);
//		cache.set(10, 5);
//		cache.set(15, 5);
//		cache.set(6, 5);
//		cache.set(9, 11);
//		System.out.println(cache.get(8));
	}
}

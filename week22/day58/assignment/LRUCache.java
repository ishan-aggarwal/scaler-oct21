package day58.assignment;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

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

	private Node head;
	private Node last;

	private int capacity;
	private Map<Integer, Node> hm;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.hm = new HashMap<>();
		this.head = new Node(-1, -1);
		this.last = new Node(-1, -1);
		head.next = last;
		last.prev = head;
	}

	public int get(int key) {
		Node temp = hm.get(key);
		// miss
		if (temp == null) {
			return -1;
		}

		int value = temp.val;
		// check if it is already the last node
		// no need to shift the nodes
//		if (temp.next == null) {
//			return value;
//		}

		// else remove temp from current location
		// and insert temp at the last
		remove(temp);
		insert(temp);
		return value;
	}

	public void set(int key, int value) {

		if (hm.containsKey(key)) {
			remove(hm.get(key));
		}

		if (hm.size() == capacity) {
			remove(last.prev);
		}

		insert(new Node(key, value));

//		Node node = hm.get(key);
//		if (node != null) {
//
//			if (node.val != value) {
//				node.val = value;
////				hm.put(key, node);
//			}
//
//			// check if it is already the last node
//			// no need to shift the nodes
//			if (node.next == null) {
//				return;
//			} else {
//				remove(node);
//				insert(node);
//			}
//		} else {
//			Node temp = new Node(key, value);
//			hm.put(key, temp);
//
//			// after putting new node
//			// if size of hashmap increases the desired capacity
//			// erase the first node
//			if (hm.size() > capacity) {
//
//				if (head.next == last) {
//					last = head;
//				}
//
//				// remove the entry from hashmap
//				hm.remove(head.next.key);
//				// remove the node from linked list
//				remove(head.next);
//			}
//			insert(temp);
//		}
	}

	private void insert(Node temp) {

		hm.put(temp.key, temp);

		temp.next = head.next;
		temp.next.prev = temp;
		head.next = temp;
		temp.prev = head;

//		// adjust next pointer of tail
//		last.next = temp;
//		// adjust the previous pointer for temp node
//		temp.prev = last;
//
//		// move tail forward
////		tail = tail.next;
//		last = temp;
	}

	private void remove(Node temp) {

		hm.remove(temp.key);
		// set next pointer for temp previous node
		temp.prev.next = temp.next;

		// set prev pointer for temp next node
		temp.next.prev = temp.prev;

		// set prev pointer for temp next node
//		if (temp.next != null) {
//			temp.next.prev = temp.prev;
//		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);
//		cache.set(2, 1);
//		cache.set(2, 2);
//		System.out.println(cache.get(2));
//		cache.set(1, 1);
//		cache.set(4, 1);
//		System.out.println(cache.get(2));

//		cache.set(2, 1);
//		System.out.println(cache.get(2));
//		cache.set(3, 2);
//		System.out.println(cache.get(2));
//		System.out.println(cache.get(3));

		cache.set(5, 4);
		System.out.println(cache.get(5));
		cache.set(10, 11);
		System.out.println(cache.get(7));
		System.out.println(cache.get(2));
		cache.set(12, 6);
		cache.set(15, 1);
		cache.set(10, 5);
		cache.set(15, 5);
		cache.set(6, 5);
		cache.set(9, 11);
		System.out.println(cache.get(8));
	}
}

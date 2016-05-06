package com.hsingh.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Implementation of LRU Cache.
 * 
 * @author Himanshu_Singh2
 *
 * @param <K>
 *            Data Type of the key for cache
 * @param <V>
 *            Data Type of the value for cache
 */
public class LRUCache<K, V> implements Cache<K, V> {

	/**
	 * class to keep information of each node
	 * 
	 */
	private class Node {
		private K key;
		private V value;
		private Node next;
		private Node prev;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "[" + value + "]";
		}
	}

	private Node head;
	private Node tail;
	private int size;

	/**
	 * adds node at the start of the list
	 * 
	 * @param node
	 *            the node to be added in the list
	 */
	private void addFirst(Node node) {
		node.next = head;
		if (head != null) {
			head.prev = node;
		}
		head = node;
		if (tail == null) {
			tail = node;
		}
		size++;
	}

	/**
	 * removes data from the start of the list
	 * 
	 * @return data removed from the start of the list
	 */
	private V removeFirst() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Node tmp = head;
		head = head.next;
		if (head != null) {
			head.prev = null;
		} else {
			tail = null;
		}
		size--;
		return tmp.value;
	}

	/**
	 * removes data from the end of the list
	 * 
	 * @return data removed from the end of the list
	 */
	private V removeLast() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Node tmp = tail;
		tail = tail.prev;

		if (tail != null) {
			tail.next = null;
		} else {
			head = null;
		}
		size--;
		return tmp.value;
	}

	private void remove(Node node) {
		// empty list
		if (size == 0) {
			throw new NoSuchElementException();
		}

		// if given node is head of the list
		if (node == head) {
			removeFirst();
		}
		// if given node is tail of the list
		else if (node == tail) {
			removeLast();
		}
		// if given node is in between the list
		else {
			// if there is element on left side
			if (node.prev != null) {
				node.prev.next = node.next;
			}
			// if there is element on right side
			if (node.next != null) {
				node.next.prev = node.prev;
			}
		}
	}

	private Map<K, Node> map = new HashMap<K, Node>();
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public V get(K key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			addFirst(node);
			return node.value;
		}
		return null;
	}

	@Override
	public void put(K key, V value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			addFirst(old);
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(tail.key);
				removeLast();
			}
			addFirst(created);
			map.put(key, created);
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int capacity() {
		return capacity;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node tmp = head;
		while (tmp != null) {
			sb.append(tmp);
			tmp = tmp.next;
			if (tmp != null) {
				sb.append("<-->");
			}
		}

		return sb.toString();
	}
}

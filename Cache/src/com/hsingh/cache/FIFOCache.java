package com.hsingh.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Implementation of FIFO Cache.
 * 
 * @author Himanshu_Singh2
 *
 * @param <K>
 *            Data Type of the key for cache
 * @param <V>
 *            Data Type of the value for cache
 */
public class FIFOCache<K, V> implements Cache<K, V> {

	/**
	 * class to keep information of each node
	 * 
	 */
	private class Node {
		private K key;
		private V value;
		private Node next;

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
	 * adds node at the end of the list
	 * 
	 * @param node
	 *            the node to be added in the list
	 */
	private void addLast(Node node) {
		if (tail != null) {
			tail.next = node;
		}
		tail = node;
		if (head == null) {
			head = node;
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
		if (head == null) {
			tail = null;
		}
		size--;
		return tmp.value;
	}

	private Map<K, Node> map = new HashMap<K, Node>();
	private int capacity;

	public FIFOCache(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public V get(K key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			return node.value;
		}
		return null;
	}

	@Override
	public void put(K key, V value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(head.key);
				removeFirst();
			}
			addLast(created);
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
				sb.append("->");
			}
		}

		return sb.toString();
	}
}

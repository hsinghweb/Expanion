package com.hsingh.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LFUCache2<K, V> implements Cache<K, V> {

	private class Node implements Comparable<Node> {
		private K key;
		private V value;
		private int frequency;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(LFUCache2<K, V>.Node o) {
			return o.frequency - this.frequency;
		}
	}

	private Map<K, Node> map = new HashMap<K, Node>();
	private int capacity;
	private List<Node> nodeList;

	public LFUCache2(int capacity) {
		this.capacity = capacity;
		this.nodeList = new LinkedList<Node>();
	}

	@Override
	public V get(K key) {
		Node currentNode = map.get(key);

		if (currentNode != null) {
			currentNode.frequency = currentNode.frequency + 1;
			map.put(key, currentNode);
			Collections.sort(nodeList);
			return currentNode.value;
		} else {
			return null;
		}
	}

	@Override
	public void put(K key, V value) {
		Node currentNode = map.get(key);
		if (currentNode == null) {
			if (map.size() == capacity) {
				Node lastNode = nodeList.remove(capacity - 1);
				map.remove(lastNode.key);
			}
			currentNode = new Node(key, value);
			nodeList.add(currentNode);
			map.put(key, currentNode);
		} else {
			currentNode.value = value;
		}
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public int capacity() {
		return capacity;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<Node> it = nodeList.iterator();
		while (it.hasNext()) {
			Node node = it.next();
			sb.append("[key: ");
			sb.append(node.key);
			sb.append(", value: ");
			sb.append(node.value);
			sb.append(", frequency: ");
			sb.append(node.frequency);
			sb.append("] ");
		}

		return sb.toString();
	}
}

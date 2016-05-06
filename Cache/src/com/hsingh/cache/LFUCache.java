package com.hsingh.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache<K, V> implements Cache<K, V> {

	private class Node {
		private K key;
		private V value;
		private int frequency;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private Map<K, Node> map = new HashMap<K, Node>();
	private int capacity;
	private LinkedHashSet<Node>[] frequencyList;
	private int lowestFrequency;
	private int maximumFrequency;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.frequencyList = new LinkedHashSet[capacity];
		this.lowestFrequency = 0;
		this.maximumFrequency = capacity - 1;
		for (int i = 0; i < capacity; i++) {
			frequencyList[i] = new LinkedHashSet<Node>();
		}
	}

	@Override
	public V get(K key) {
		Node currentNode = map.get(key);

		if (currentNode != null) {
			int currentFrequency = currentNode.frequency;
			if (currentFrequency < maximumFrequency) {
				int nextFrequency = currentFrequency + 1;
				LinkedHashSet<Node> currentNodes = frequencyList[currentFrequency];
				LinkedHashSet<Node> newNodes = frequencyList[nextFrequency];
				moveToNextFrequency(currentNode, nextFrequency, currentNodes,
						newNodes);
				map.put(key, currentNode);
				if (lowestFrequency == currentFrequency
						&& currentNodes.isEmpty()) {
					lowestFrequency = nextFrequency;
				}
			} else {
				LinkedHashSet<Node> nodes = frequencyList[currentFrequency];
				nodes.remove(currentNode);
				nodes.add(currentNode);
			}
			return currentNode.value;
		} else {
			return null;
		}
	}

	private void moveToNextFrequency(Node currentNode, int nextFrequency,
			LinkedHashSet<Node> currentNodes, LinkedHashSet<Node> newNodes) {
		currentNodes.remove(currentNode);
		newNodes.add(currentNode);
		currentNode.frequency = nextFrequency;
	}

	@Override
	public void put(K key, V value) {
		Node currentNode = map.get(key);
		if (currentNode == null) {
			if (map.size() == capacity) {
				doEviction();
			}
			LinkedHashSet<Node> nodes = frequencyList[0];
			currentNode = new Node(key, value);
			nodes.add(currentNode);
			map.put(key, currentNode);
			lowestFrequency = 0;
		} else {
			currentNode.value = value;
		}
	}

	private void doEviction() {
		LinkedHashSet<Node> nodes = frequencyList[lowestFrequency];
		Iterator<Node> it = nodes.iterator();
		if (it.hasNext()) {
			Node node = it.next();
			it.remove();
			map.remove(node.key);
		}
		if (!it.hasNext()) {
			findNextLowestFrequency();
		}
	}

	private void findNextLowestFrequency() {
		while (lowestFrequency <= maximumFrequency
				&& frequencyList[lowestFrequency].isEmpty()) {
			lowestFrequency++;
		}
		if (lowestFrequency > maximumFrequency) {
			lowestFrequency = 0;
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

		for (int i = lowestFrequency; i < capacity; i++) {
			LinkedHashSet<Node> nodes = frequencyList[i];
			Iterator<Node> it = nodes.iterator();
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

		}

		return sb.toString();
	}
}

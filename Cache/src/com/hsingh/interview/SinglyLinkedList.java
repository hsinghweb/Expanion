package com.hsingh.interview;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Singly Linked List implementation, where each node will point to next node.
 * 
 * @author Himanshu_Singh2
 *
 * @param <T>
 *            Type of the data stored in Linked List.
 */
public class SinglyLinkedList<T> implements Iterable<T> {

	/**
	 * Class to keep information of each node.
	 * 
	 */
	public class Node {
		private T data;
		private Node next;

		public Node(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "[" + data + "]";
		}
	}

	/**
	 * Head of Singly Linked List
	 */
	private Node head;

	/**
	 * Tail of Singly Linked List
	 */
	private Node tail;

	/**
	 * Size of Singly Linked List
	 */
	private int size;

	/**
	 * Adds the data at the start of the list.
	 * 
	 * @param data
	 *            the data to be added in the list.
	 */
	public Node addFirst(T data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		if (tail == null) {
			tail = node;
		}
		size++;
		return node;
	}

	/**
	 * Adds the data at the end of the list
	 * 
	 * @param data
	 *            the data to be added in the list
	 */
	public void addLast(T data) {
		Node node = new Node(data);
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
	 * Removes the data from the start of the list
	 * 
	 * @return data removed from the start of the list
	 */
	public T removeFirst() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Node node = head;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		size--;
		return node.data;
	}

	/**
	 * Size of the list.
	 * 
	 * @return size of the list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Test whether list is empty.
	 * 
	 * @return true is list is empty else false.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public Iterator<T> iterator() {
		return new SinglyLinkedListIterator();
	}

	/**
	 * Iterator implementation for Singly Linked List.
	 * 
	 * @author Himanshu_Singh2
	 *
	 */
	private class SinglyLinkedListIterator implements Iterator<T> {
		private Node current = head;

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			if (current != null) {
				T data = current.data;
				current = current.next;
				return data;
			}

			return null;
		}
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

	/**
	 * Function to get the nth node from end of list
	 */
	public T getNthFromLast(int n) {
		Node node1 = head;
		Node nodeN = head;

		// First move nodeN to nth node
		for (int i = 0; (i < n); i++) {
			if (nodeN == null) {
				throw new NoSuchElementException();
			}
			nodeN = nodeN.next;
		}

		// move both nodes till nodeN reaches to end
		while (nodeN != null) {
			node1 = node1.next;
			nodeN = nodeN.next;
		}
		return node1.data;
	}

	/**
	 * Function to get the middle node of list
	 */
	public T getMiddle() {
		Node node1 = head;
		Node node2 = head;

		// move node1 with 1 step and node2 with 2 steps speed
		while (node2.next != null) {
			node1 = node1.next;
			node2 = node2.next;
			if (node2.next != null) {
				node2 = node2.next;
			}
		}
		return node1.data;
	}

	/**
	 * Delete the given node from the list
	 * 
	 * @param node node to be deleted
	 */
	public T deleteNode(Node node) {
		T data = node.data;
		Node temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
		return data;
	}

}

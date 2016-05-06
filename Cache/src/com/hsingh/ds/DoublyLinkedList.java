package com.hsingh.ds;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of DoublyLinkedList, where each node will point to next and
 * previous node.
 * 
 * @author Himanshu_Singh2
 *
 * @param <T>
 *            Type of data to be stored in the DoublyLinkedList
 */
public class DoublyLinkedList<T> implements Iterable<T> {

	/**
	 * Class to keep information of each node
	 * 
	 */
	private class Node {
		private T data;
		private Node next;
		private Node prev;

		public Node(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "[" + data + "]";
		}
	}

	/**
	 * Head of the list.
	 */
	private Node head;

	/**
	 * Tail of the list.
	 */
	private Node tail;

	/**
	 * Size of the list.
	 */
	private int size;

	/**
	 * Adds data at the start of the list
	 * 
	 * @param data
	 *            the data to be added in the list
	 */
	public void addFirst(T data) {
		Node node = new Node(data);
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
	 * Adds data at the end of the list.
	 * 
	 * @param data
	 *            the data to be added in the list
	 */
	public void addLast(T data) {
		Node node = new Node(data);
		node.prev = tail;
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
	 * Removes data from the start of the list
	 * 
	 * @return data removed from the start of the list
	 */
	public T removeFirst() {
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
		return tmp.data;
	}

	/**
	 * Removes data from the end of the list
	 * 
	 * @return data removed from the end of the list
	 */
	public T removeLast() {
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
		return tmp.data;
	}

	/**
	 * returns the size of the list
	 * 
	 * @return size of the list
	 */
	public int size() {
		return size;
	}

	/**
	 * return whether the list is empty or not
	 * 
	 * @return true if list is empty else return false
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node tmp = head;
		while (tmp != null) {
			sb.append(tmp);
			tmp = tmp.next;
			if (tmp != null) {
				sb.append("<=>");
			}
		}

		return sb.toString();
	}

	/**
	 * Iterator implementation for Doubly Linked List.
	 * 
	 * @author Himanshu_Singh2
	 *
	 */
	private class DoublyLinkedListIterator implements Iterator<T> {
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
	public Iterator<T> iterator() {
		return new DoublyLinkedListIterator();
	}

}
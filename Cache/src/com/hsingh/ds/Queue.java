package com.hsingh.ds;

public class Queue<T> {
	SinglyLinkedList<T> singlyLinkedList = new SinglyLinkedList<T>();

	public void enqueue(T data) {
		singlyLinkedList.addLast(data);
	}

	public T dequeue() {
		return singlyLinkedList.removeFirst();
	}

	public int size() {
		return singlyLinkedList.size();
	}

	@Override
	public String toString() {
		return "Queue [" + singlyLinkedList + "]";
	}

}

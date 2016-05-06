package com.hsingh.ds;

public class Stack<T> {
	SinglyLinkedList<T> singlyLinkedList = new SinglyLinkedList<T>();

	public void push(T data) {
		singlyLinkedList.addFirst(data);
	}

	public T pop() {
		return singlyLinkedList.removeFirst();
	}

	public int size() {
		return singlyLinkedList.size();
	}

	@Override
	public String toString() {
		return "Stack [" + singlyLinkedList + "]";
	}

}

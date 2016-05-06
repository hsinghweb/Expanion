package com.hsingh.ds;

public class TestDoublyLinkedList {
	public static void main(String a[]) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		System.out.println(dll);
		dll.addFirst(10);
		dll.addFirst(34);
		dll.addLast(56);
		dll.addLast(364);
		System.out.println(dll);
		dll.removeFirst();
		dll.removeLast();

		System.out.println(dll);

		for (Integer i : dll) {
			System.out.println(i);
		}

	}
}

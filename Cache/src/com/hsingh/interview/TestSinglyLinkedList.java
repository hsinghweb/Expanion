package com.hsingh.interview;

class Student {
	private String name;
	private int id;

	public Student(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}

}

public class TestSinglyLinkedList {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer>.Node node = singlyLinkedList.addFirst(2);
		singlyLinkedList.addFirst(1);
		singlyLinkedList.addLast(3);
		singlyLinkedList.addLast(4);
		singlyLinkedList.addLast(5);
		singlyLinkedList.addLast(6);
		singlyLinkedList.addLast(7);
		singlyLinkedList.addLast(8);

		
		System.out.println(singlyLinkedList);
		System.out.println(singlyLinkedList.deleteNode(node));
		System.out.println(singlyLinkedList);

		System.out.println("Middle: " + singlyLinkedList.getMiddle());

		System.out.println(singlyLinkedList.getNthFromLast(2));
		System.out.println(singlyLinkedList.getNthFromLast(1));
		//System.out.println(singlyLinkedList.getNthFromLast(5));
		singlyLinkedList.removeFirst();
		singlyLinkedList.removeFirst();
		singlyLinkedList.removeFirst();
		System.out.println(singlyLinkedList);
		//System.out.println(singlyLinkedList.getNthFromLast(2));
	}
}

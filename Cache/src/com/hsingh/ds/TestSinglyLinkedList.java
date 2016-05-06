package com.hsingh.ds;

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
		singlyLinkedList.addFirst(2);
		singlyLinkedList.addFirst(1);
		singlyLinkedList.addLast(3);
		singlyLinkedList.addLast(4);
		singlyLinkedList.addLast(5);

		System.out.println(singlyLinkedList);
		singlyLinkedList.removeFirst();
		singlyLinkedList.removeFirst();
		singlyLinkedList.removeFirst();
		System.out.println(singlyLinkedList);

		SinglyLinkedList<Student> singlyLinkedList2 = new SinglyLinkedList<Student>();
		singlyLinkedList2.addLast(new Student("Ram", 1));
		singlyLinkedList2.addLast(new Student("Shyam", 2));
		singlyLinkedList2.addFirst(new Student("Mohan", 3));

		System.out.println(singlyLinkedList2);
		singlyLinkedList2.removeFirst();
		System.out.println(singlyLinkedList2);

		for (Integer i : singlyLinkedList) {
			System.out.println(i);
		}

		for (Student s : singlyLinkedList2) {
			System.out.println(s);
		}
	}
}

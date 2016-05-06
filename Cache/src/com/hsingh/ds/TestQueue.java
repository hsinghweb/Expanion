package com.hsingh.ds;

public class TestQueue {
	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();

		System.out.println(queue);
		
		System.out.println(queue.size());
		queue.enqueue("Swati");
		queue.enqueue("Reena");
		queue.enqueue("Meena");
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue);
	}
}

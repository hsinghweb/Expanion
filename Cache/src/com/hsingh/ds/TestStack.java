package com.hsingh.ds;

public class TestStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		System.out.println(stack);

		stack.push(3);
		stack.push(2);
		stack.push(1);
		System.out.println(stack);
		stack.push(4);
		stack.pop();
		stack.push(5);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		
		
	}
}

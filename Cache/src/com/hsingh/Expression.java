package com.hsingh;

import com.hsingh.ds.Stack;

public class Expression {

	private String expression;

	public Expression(String expression) {
		super();
		this.expression = expression;
	}

	public boolean isValidExpression() {
		boolean isValid = true;
		Stack<Character> charStack = new Stack<Character>();

		for (int i = 0; i < expression.length(); i++) {
			Character c = expression.charAt(i);
			Character popped = null;

			switch (c) {
			case '[':
			case '{':
			case '(':
				charStack.push(c);
				break;
			case ']':
				if (charStack.size() > 0) {
					popped = charStack.pop();
					if (popped != '[') {
						isValid = false;
					}
				} else {
					isValid = false;
				}
				break;
			case '}':
				if (charStack.size() > 0) {
					popped = charStack.pop();
					if (popped != '{') {
						isValid = false;
					}
				} else {
					isValid = false;
				}
				break;
			case ')':
				if (charStack.size() > 0) {
					popped = charStack.pop();
					if (popped != '(') {
						isValid = false;
					}
				} else {
					isValid = false;
				}
				break;
			default:

			}
		}
		if (charStack.size() != 0) {
			isValid = false;
		}

		return isValid;
	}

}

package com.hsingh;

public class TestExpression {
	public static void main(String[] args) {
		Expression expression = new Expression("[{(a+b)*d}]");
		System.out.println(expression.isValidExpression());
		
		
		expression = new Expression("[{(a+b)*d}");
		System.out.println(expression.isValidExpression());
		
		
		expression = new Expression("a");
		System.out.println(expression.isValidExpression());
		
		expression = new Expression("a*(b+c)*d");
		System.out.println(expression.isValidExpression());
		
		expression = new Expression("(a*(b+c)*d");
		System.out.println(expression.isValidExpression());
		
		expression = new Expression("a*(b+c)*d)");
		System.out.println(expression.isValidExpression());
	}

}

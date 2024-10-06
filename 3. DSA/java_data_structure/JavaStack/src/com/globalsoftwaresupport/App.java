package com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		Stack<Integer> nums = new Stack<>();
		
		nums.push(1);
		nums.push(2);
		nums.push(3);
		nums.push(4);
		nums.push(5);
		nums.push(6);
		
		while(!nums.isEmpty())
			System.out.println(nums.pop());

	}

}

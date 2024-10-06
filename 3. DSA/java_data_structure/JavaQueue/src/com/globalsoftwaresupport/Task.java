package com.globalsoftwaresupport;

public class Task {
	
	private int id;
	
	public Task(int id) {
		this.id = id;
	}
	
	public void execute() {
		System.out.println("Executing task with id " + id);
	}
}

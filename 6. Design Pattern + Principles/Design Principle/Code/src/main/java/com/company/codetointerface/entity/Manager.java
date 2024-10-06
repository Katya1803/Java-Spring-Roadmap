package com.company.codetointerface.entity;

public class Manager extends AbstractEmployee {

	public Manager(Long employeeId, double compensation) {
		super(employeeId, compensation);
	}

	@Override
	public String getDesignation() {
		return "Manager";
	}
	
	public void doManagerStuff() {
		System.out.println("Breaking fixed things!");
	}
}
package com.company.codetointerface.entity;

public class Engineer extends AbstractEmployee {

	public Engineer(Long employeeId, double compensation) {
		super(employeeId, compensation);
	}

	@Override
	public String getDesignation() {
		return "Engineer";
	}

	public void doEngineeringStuff() {
		System.out.println("Fixing broken things!");
	}
}
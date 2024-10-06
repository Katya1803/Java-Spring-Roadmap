package com.company.codetointerface.entity;

public abstract class AbstractEmployee implements Employee{
	
	protected double compensation;
	
	protected Long employeeId;
	
	public AbstractEmployee(Long employeeId, double compensation) {
		this.employeeId = employeeId;
		this.compensation = compensation;
	}
	
	@Override
	public double getCompensation() {
		return compensation;
	}

	
	@Override
	public void setCompensation(double amount) {
		this.compensation = amount;
	}

	@Override
	public Long getEmployeeId() {
		return employeeId;
	}
	
}

package com.company.intersegrega_ex;

public abstract class AbstractEmployee implements Employee {

	protected Long employeeId;

	@Override
	public Long getEmployeeId() {
		return employeeId;
	}
	
}

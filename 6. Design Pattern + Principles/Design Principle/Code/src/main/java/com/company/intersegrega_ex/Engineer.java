package com.company.intersegrega_ex;

import java.util.List;

public class Engineer extends AbstractEmployee {
	
	@Override
	public String getDesignation() {
		return "Engineer";
	}

	@Override
	public boolean isProjectOwner(Long projectId) {
		return false;
	}

	@Override
	public List<Employee> getReportees() {
		return null;
	}

	@Override
	public void addReportee(Employee employee) {

	}

	@Override
	public void setProjectOwner(Long projectId) {
		
	}

	@Override
	public void removeProjectOwner(Long projectId) {
		
	}

}

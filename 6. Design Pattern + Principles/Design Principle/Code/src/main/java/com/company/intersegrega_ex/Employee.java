package com.company.intersegrega_ex;

import java.util.List;

public interface Employee {

	public Long getEmployeeId();
	
	public String getDesignation();
	
	public boolean isProjectOwner(Long projectId);
	
	public List<Employee> getReportees();
	
	public void addReportee(Employee employee);
	
	public void setProjectOwner(Long projectId);
	
	public void removeProjectOwner(Long projectId);
}

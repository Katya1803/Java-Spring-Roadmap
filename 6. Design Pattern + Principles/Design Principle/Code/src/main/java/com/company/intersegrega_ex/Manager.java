package com.company.intersegrega_ex;

import java.util.ArrayList;
import java.util.List;

public class Manager extends AbstractEmployee {

	private List<Long> ownedProjects = new ArrayList<>();
	
	private List<Employee> reportees = new ArrayList<>();
	
	@Override
	public String getDesignation() {
		return "Manager";
	}

	@Override
	public boolean isProjectOwner(Long projectId) {
		return ownedProjects.stream().anyMatch(id->id.equals(projectId));
	}

	@Override
	public List<Employee> getReportees() {
		return reportees;
	}

	@Override
	public void addReportee(Employee employee) {
		reportees.add(employee);
	}

	@Override
	public void setProjectOwner(Long projectId) {
		ownedProjects.add(projectId);
	}

	@Override
	public void removeProjectOwner(Long projectId) {
		ownedProjects.remove(projectId);
	}

	
}

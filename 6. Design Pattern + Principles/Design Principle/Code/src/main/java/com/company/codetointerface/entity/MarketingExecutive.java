package com.company.codetointerface.entity;

public class MarketingExecutive extends AbstractEmployee {

	public MarketingExecutive(Long employeeId, double compensation) {
		super(employeeId, compensation);
	}

	@Override
	public String getDesignation() {
		return "Marketing Executive";
	}
	
	public void doMarketingStuff() {
		System.out.println("Advertising the impossible to customers");
	}
}
package com.company.codetointerface;

import com.company.codetointerface.entity.Engineer;

public class CompensationAdjuster {

	public void adjustCompensationByPercent(Engineer engineer, int percentChange) {
		//query approval service
		//validate compliance record
		
		double currentComp = engineer.getCompensation();
		double newComp = currentComp + currentComp*percentChange/100;
		
		engineer.setCompensation(newComp);

		System.out.println("Adjusted compensation from "+ currentComp+" to "+newComp);
		
		//notify payroll service
		//schedule compensation change job
	}
}
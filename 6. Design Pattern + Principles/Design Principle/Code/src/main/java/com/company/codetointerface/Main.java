package com.company.codetointerface;

import com.company.codetointerface.entity.Engineer;

public class Main {

	public static void main(String[] args) {
		
		Engineer engineer = new Engineer(10l, 100);
		
		CompensationAdjuster adjuster = new CompensationAdjuster();
		
		adjuster.adjustCompensationByPercent(engineer, 5);
	}

}

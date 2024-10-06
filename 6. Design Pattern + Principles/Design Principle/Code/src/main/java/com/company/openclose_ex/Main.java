package com.company.openclose_ex;

public class Main {

	public static void main(String[] args) {
		TimeApiTextClient textClient = new TimeApiTextClient();
		System.out.println(textClient.getCurrentUnixtimeUTC());
		
		WorldTimeApiClient jsonClient = new WorldTimeApiClient();
		System.out.println(jsonClient.getCurrentUnixtimeUTC());
	}

}

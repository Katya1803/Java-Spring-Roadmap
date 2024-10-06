package com.company.encapsulation;

import com.company.encapsulation.controller.UserController;

public class Main {

	private static final String TEST_JSON = "{\"name\": \"DUMMY\", \"email\": \"dummy@dummy.com\", \"tier\": \"PREMIUM\"}";
	
	public static void main(String[] args) {
		
		UserController controller = new UserController();
		
		String response = controller.createUser(TEST_JSON);
		
		if(response.equalsIgnoreCase("SUCCESS")) {
			System.out.println("User created");
		} else {
			System.err.println("User creation failed");
		}
	}

}

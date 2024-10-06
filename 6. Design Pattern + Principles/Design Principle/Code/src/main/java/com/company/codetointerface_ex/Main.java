package com.company.codetointerface_ex;

import com.company.codetointerface_ex.entity.User;

public class Main {

	public static void main(String[] args) {
		User user = new User();
		
		IdGenerator.generateId(user);
		
		System.out.println("User id "+user.getId());

	}

}

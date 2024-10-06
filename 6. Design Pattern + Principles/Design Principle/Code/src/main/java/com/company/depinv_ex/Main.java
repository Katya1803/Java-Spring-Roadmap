package com.company.depinv_ex;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class Main {

	public static void main(String[] args) throws IOException {
		OrderService service = new OrderService();
		Collection<Order> orders = service.getAll();
	}

}

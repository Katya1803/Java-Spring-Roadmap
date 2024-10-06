package com.company.depinv_ex;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class OrderService {

	private static final Map<String, Order> ORDERS = new HashMap<>();
	
	static {
		Random random = new Random(Instant.now().toEpochMilli());
		for(int i=0; i<10;i++) {
			Order order = new Order(UUID.randomUUID().toString(), LocalDateTime.now(ZoneId.of("UTC")), Math.abs(random.nextInt())%1000);
			ORDERS.put(order.getId(), order);
		}
	}
	
	public Collection<Order> getAll() {
		synchronized (ORDERS) {
			return ORDERS.values();
		}
	}
}

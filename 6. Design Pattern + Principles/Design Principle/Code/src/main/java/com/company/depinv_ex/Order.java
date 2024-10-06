package com.company.depinv_ex;

import java.time.LocalDateTime;

public class Order {

	private String id;
	
	private LocalDateTime dateTime;
	
	private double total;

	public Order(String id, LocalDateTime dateTime, double total) {
		this.id = id;
		this.dateTime = dateTime;
		this.total = total;
	}
	
	public String getId() {
		return id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", dateTime=" + dateTime + ", total=" + total + "]";
	}
	
}

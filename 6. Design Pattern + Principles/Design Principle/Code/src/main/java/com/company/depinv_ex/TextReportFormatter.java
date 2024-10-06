package com.company.depinv_ex;

import java.time.format.DateTimeFormatter;

public class TextReportFormatter implements ReportFormatter {

	private StringBuilder builder;
	
	@Override
	public void init() {
		builder = new StringBuilder();
		builder.append("-------------------------------------------------\n");
		builder.append("Order Report\n");
		builder.append("-------------------------------------------------\n");
	}

	@Override
	public void addToReport(Order order) {
		builder.append("Order#:");
		builder.append(order.getId());
		builder.append("\nOrder Time:");
		builder.append(order.getDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE));
		builder.append(" ");
		builder.append(order.getDateTime().format(DateTimeFormatter.ISO_LOCAL_TIME));
		builder.append("\nOrder Total:");
		builder.append(order.getTotal());
		builder.append("\n\n");
	}

	@Override
	public void finish() {
		builder.append("---------------------- end ----------------------\n");
	}

	@Override
	public String getReport() {
		return builder != null?builder.toString():"<Empty>";
	}
	
}

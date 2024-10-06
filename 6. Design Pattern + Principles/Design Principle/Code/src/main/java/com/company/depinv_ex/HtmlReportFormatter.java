package com.company.depinv_ex;

import java.time.format.DateTimeFormatter;

public class HtmlReportFormatter implements ReportFormatter {

	private StringBuilder builder;
	
	@Override
	public void init() {
		builder = new StringBuilder();
		builder.append("<html><head><title>Order Report</title>");
		builder.append("<style> table { border-collapse: collapse; } th, td { border: 1px solid black; padding: 10px;text-align: left;"); 
		builder.append("</style></head>");
		builder.append("<body><br/><h1>Order Report</h1><hr/><br/>");
		builder.append("<table><tr><th>Order#</th><th>Order Date</th><th>Order Total</th></tr>");
	}

	@Override
	public void addToReport(Order order) {
		builder.append("<tr><td>");
		builder.append(order.getId());
		builder.append("</td><td>");
		builder.append(order.getDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE));
		builder.append(" ");
		builder.append(order.getDateTime().format(DateTimeFormatter.ISO_LOCAL_TIME));
		builder.append("</td><td>");
		builder.append(order.getTotal());
		builder.append("</td></tr>");
	}

	@Override
	public void finish() {
		builder.append("</body></html>");
	}

	@Override
	public String getReport() {
		return builder != null?builder.toString():"<Empty>";
	}
	
}

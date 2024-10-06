package com.company.depinv_ex;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class ReportWriter {

	public void generateReport(Collection<Order> orders, String reportName) throws IOException {
		ReportFormatter formatter = new HtmlReportFormatter();
		formatter.init();
		orders.stream().forEach(formatter::addToReport);
		formatter.finish();
		try(FileWriter writer = new FileWriter(reportName)) {
			writer.write(formatter.getReport());
			writer.flush();
		}
	}
}

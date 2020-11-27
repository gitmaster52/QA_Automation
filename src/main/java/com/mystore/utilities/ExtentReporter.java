package com.mystore.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mystore.base.BaseClass;

public class ExtentReporter extends BaseClass{

	

	public static ExtentReports setupExtentReport() {
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(
				"Reports/ExtentReport Date(" + actualDate + ")Time.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		sparkReport.config().setDocumentTitle("HRMS Application");
		sparkReport.config().setTheme(Theme.STANDARD);
		sparkReport.config().setReportName("AUTOMATION_REPORTS");

		return extent;

	}
}

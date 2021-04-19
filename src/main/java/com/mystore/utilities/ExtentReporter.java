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
		sparkReport.config().setDocumentTitle("Eleven Store Application");
		sparkReport.config().setTheme(Theme.STANDARD);
		sparkReport.config().setReportName("Eleven Store AUTOMATION_REPORTS");
		
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Raj Kumar");

		return extent;

	}
}

package com.mystore.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;


public class ListenersImplementations extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		// Excutes before each test case
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName() + " is failed");
		test.log(Status.FAIL, result.getThrowable());
		
		try {
			test.log(Status.INFO, "Screenshot for " + result.getMethod().getMethodName() + " Failure");
			test.addScreenCaptureFromPath(Action.getScreenhot(driver)); //This method will add failure screenshort to EXTENT REPOET.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onStart(ITestContext context) {
		extent = ExtentReporter.setupExtentReport();
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName() + " is passed");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}

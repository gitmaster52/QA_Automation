package com.mystore.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {

	int intial = 1;
	int noOfTimesRetryAndRun = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (intial < noOfTimesRetryAndRun) {
			intial++;
			return true;
		}

		return false;
	}

}

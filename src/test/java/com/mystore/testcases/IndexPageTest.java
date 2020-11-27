package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {

	IndexPage indexpage;

	@Test(priority = 1,groups= {"smoke"})
	public void myStoreLogoTest() throws InterruptedException {
		indexpage = new IndexPage();
		boolean result = indexpage.validateLogo();
		Assert.assertTrue(result);
	}

	@Test(priority = 2,groups= {"smoke"})
	public void verifyTitle() {
		String actual = indexpage.storeTitleValidate();
		Assert.assertEquals(actual, "My Store");
	}
}

package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountPageCreationTest extends BaseClass {

	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountCreationPage;


	@Test(groups="sanity")
	public void createAccountPageTest() throws InterruptedException {
		indexpage = new IndexPage();
		accountCreationPage = new AccountCreationPage();
		indexpage.clickOnSignIn();
		loginpage = indexpage.clickOnSignIn();
		accountCreationPage.createUserAccount("hello456@gmail.com");
		boolean result = accountCreationPage.validateAccountTitle();
		Assert.assertTrue(result);
	}
}

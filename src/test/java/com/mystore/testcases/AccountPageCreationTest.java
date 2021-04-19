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


	@Test(groups="sanity",dataProvider="createAccount")
	public void createAccountPageTest(String typeEmail,String gender,String firstName,String lastName,String password,String days, String months,String years,
			String address,String city,String state,String postal,String country,String mobileNumber,
			String aAliens) throws Exception {
		indexpage = new IndexPage();
		accountCreationPage = new AccountCreationPage();
		indexpage.clickOnSignIn();
		loginpage = indexpage.clickOnSignIn();
		accountCreationPage.createUserAccount(typeEmail, gender, firstName, lastName, password, days, months, years,
				address, city, state, postal, country, mobileNumber, aAliens);
		boolean result = accountCreationPage.validateAccountTitle();
		Assert.assertTrue(result);
		
	}
}

package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {

	LoginPage loginpage;
	IndexPage indexpage;
	HomePage homepage;
	String expected = "http://automationpractice.com/index.php?controller=my-account";
	
	

	
	@Test(priority = 1,groups="sanity")
	public void orderHistroryAndDetailsTest() {
		loginpage = new LoginPage();
		indexpage = new IndexPage();
		indexpage.clickOnSignIn();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actual = loginpage.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		homepage = new HomePage();
		boolean result = homepage.orderHistroryAndDetails();
		Assert.assertTrue(result);

	}

	@Test(priority = 2,groups="sanity")
	public void wishListTest() {
		loginpage = new LoginPage();
		indexpage = new IndexPage();
		homepage = new HomePage();
		indexpage.clickOnSignIn();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actual = loginpage.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		boolean result = homepage.wishList();
		Assert.assertTrue(result);
	}
}

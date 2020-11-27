package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	
	LoginPage loginpage;
	IndexPage indexpage;
	String expected = "http://automationpractice.com/index.php?controller=my-account";

	@Test(groups="sanity",dataProvider = "loginTest")
	public void loginTest(String username,String password) throws InterruptedException {
		loginpage= new LoginPage();
		indexpage = new IndexPage();
		logger.info("click on SignIn Button");
		indexpage.clickOnSignIn();
		logger.info("entering USERNAME and PASSWORD");
		loginpage.login(username, password);
		//loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		logger.info("Login Suucess");
		String actual = loginpage.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		
		
	}
}

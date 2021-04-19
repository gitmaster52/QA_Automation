package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	
	Action action  = new Action();

	@FindBy(id = "email")
	WebElement emailId;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(name = "SubmitLogin")
	WebElement signInButton;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public HomePage login(String typeEmail, String typePassword) {
		Action.typeText(emailId, typeEmail);
		Action.typeText(password, typePassword);
		action.click(signInButton);
		return new HomePage();
	}
	
	public AddressPage loginNavigationToAddressPage(String typeEmail, String typePassword) {
		Action.typeText(emailId, typeEmail);
		Action.typeText(password, typePassword);
		action.click(signInButton);
		return new AddressPage();
	}

	public String getCurrentUrl()
	{
		String currentUrl = getDriver().getCurrentUrl();
		return currentUrl;
	}
}

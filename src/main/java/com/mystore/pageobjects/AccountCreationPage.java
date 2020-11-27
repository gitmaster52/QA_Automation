package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass {

	@FindBy(id = "email_create")
	WebElement createAccount;

	@FindBy(id = "SubmitCreate")
	WebElement submitButton;

	@FindBy(xpath = "//h1[contains(text(),'Create an account')]")
	WebElement createAccountTitle;

	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}

	public void createUserAccount(String typeEmail) {
		Action.typeText(createAccount, typeEmail);
		submitButton.click();
	}

	public boolean validateAccountTitle() {
		return Action.isPresent(createAccountTitle);
	}

}

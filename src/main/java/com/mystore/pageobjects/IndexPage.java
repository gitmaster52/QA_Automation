package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	Action action  = new Action();

	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logo;

	@FindBy(name = "search_query")
	WebElement searchBox;

	@FindBy(name = "submit_search")
	WebElement submitButton;
	
	
	
	
	

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage clickOnSignIn() {
		action.click(signInBtn);
		return new LoginPage();
	}

	public boolean validateLogo() {
		return Action.isPresent(logo);
	}

	public String storeTitleValidate() {
		String titleValidate = getDriver().getTitle();
		return titleValidate;
	}

	public SearchResultPage searchProduct(String productName) {
		Action.typeText(searchBox, productName);
		action.click(submitButton);
		return new SearchResultPage();
	}
}

package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logo;

	@FindBy(name = "search_query")
	WebElement searchBox;

	@FindBy(name = "submit_search")
	WebElement submitButton;
	
	
	
	
	

	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickOnSignIn() {
		signInBtn.click();
		return new LoginPage();
	}

	public boolean validateLogo() {
		return Action.isPresent(logo);
	}

	public String storeTitleValidate() {
		String titleValidate = driver.getTitle();
		return titleValidate;
	}

	public SearchResultPage searchProduct(String productName) {
		Action.typeText(searchBox, productName);
		submitButton.click();
		return new SearchResultPage();
	}
}

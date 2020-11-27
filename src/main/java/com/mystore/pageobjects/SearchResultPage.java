package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"center_column\"]//img")
	WebElement productResult;
	

	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable()
	{
		return Action.isPresent(productResult);
	}
	
	public AddToCartPage clickOnProduct()
	{
		productResult.click();
		return new AddToCartPage();
	}

}

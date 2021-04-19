package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	
	Action action  = new Action();

	@FindBy(xpath = "//span[contains(text(),'Order history and details')]")
	WebElement oredrHistory;

	@FindBy(xpath = "//span[contains(text(),'My wishlists')]")
	WebElement wishList;
	
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean orderHistroryAndDetails()
	{
		return Action.isPresent(oredrHistory);
	}
	
	public boolean wishList()
	{
		return Action.isPresent(wishList);
	}
}

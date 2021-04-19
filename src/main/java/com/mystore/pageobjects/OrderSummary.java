package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSummary extends BaseClass{
	
	Action action  = new Action();

	@FindBy(xpath = "//*[contains(text(),'I confirm my order')]")
	WebElement confirmOrderButton;
	
	public OrderSummary()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickOnConfirmOrderButton()
	{
		action.click(confirmOrderButton);
		return new OrderConfirmationPage();
	}
}

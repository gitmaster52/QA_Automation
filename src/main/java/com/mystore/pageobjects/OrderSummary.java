package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderSummary extends BaseClass{

	@FindBy(xpath = "//*[contains(text(),'I confirm my order')]")
	WebElement confirmOrderButton;
	
	public OrderSummary()
	{
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage clickOnConfirmOrderButton()
	{
		confirmOrderButton.click();
		return new OrderConfirmationPage();
	}
}

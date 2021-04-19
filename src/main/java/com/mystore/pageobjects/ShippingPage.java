package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass
{
	
	Action action  = new Action();
	
	@FindBy(xpath = "//*[contains(text(),'I agree to the terms of service and will adhere to them unconditionally.')]")
	WebElement termsAndCondtionCheckList;
	
	@FindBy(name = "processCarrier")
	WebElement proceedToCheckOut;
	
	public ShippingPage()
	{
		PageFactory.initElements(getDriver(), this);
	}

	public void clickOnTermsAndConditionsCheckList()
	{
		action.click(termsAndCondtionCheckList);
	}
	
	public PaymentPage clickOnProceedToCheckOut()
	{
		action.click(proceedToCheckOut);
		return new PaymentPage();
				
	}
}

package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass
{
	
	@FindBy(xpath = "//*[contains(text(),'I agree to the terms of service and will adhere to them unconditionally.')]")
	WebElement termsAndCondtionCheckList;
	
	@FindBy(name = "processCarrier")
	WebElement proceedToCheckOut;
	
	public ShippingPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void clickOnTermsAndConditionsCheckList()
	{
		termsAndCondtionCheckList.click();
	}
	
	public PaymentPage clickOnProceedToCheckOut()
	{
		proceedToCheckOut.click();
		return new PaymentPage();
				
	}
}

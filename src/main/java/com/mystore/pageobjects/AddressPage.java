package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {

	@FindBy(name = "processAddress")
	WebElement processAddressCheckoutButton;
	
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ShippingPage clickOnProceedToCheckOut()
	{
		processAddressCheckoutButton.click();
		return new ShippingPage();
	}
}

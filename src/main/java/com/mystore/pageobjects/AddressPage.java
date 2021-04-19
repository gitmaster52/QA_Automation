package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {
	
	Action action = new Action();

	@FindBy(name = "processAddress")
	WebElement processAddressCheckoutButton;
	
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage clickOnProceedToCheckOut()
	{
		action.click(processAddressCheckoutButton);
		return new ShippingPage();
	}
}

package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {

	@FindBy(xpath = "//*[@title='Pay by bank wire']")
	WebElement payByBankWireOption;
	
	@FindBy(xpath = "//*[@title='Pay by cheque']")
	WebElement payByCheque;
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement confirmMyOrder;
	
	
	public PaymentPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPayByBankWireOption()
	{
		payByBankWireOption.click();
		
	}
	
	public OrderConfirmationPage clickOnIConfirmMyOrder()
	{
		confirmMyOrder.click();
		return new OrderConfirmationPage();
	}
	
	
	
}

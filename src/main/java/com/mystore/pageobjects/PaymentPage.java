package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {
	
	Action action  = new Action();

	@FindBy(xpath = "//*[@title='Pay by bank wire']")
	WebElement payByBankWireOption;
	
	@FindBy(xpath = "//*[@title='Pay by cheque']")
	WebElement payByCheque;
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement confirmMyOrder;
	
	
	public PaymentPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnPayByBankWireOption()
	{
		action.click(payByBankWireOption);
		
	}
	
	public OrderConfirmationPage clickOnIConfirmMyOrder()
	{
		action.click(confirmMyOrder);
		return new OrderConfirmationPage();
	}
	
	
	
}

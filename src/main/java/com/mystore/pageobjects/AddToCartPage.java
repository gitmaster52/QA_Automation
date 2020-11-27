package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {

	@FindBy(id = "quantity_wanted")
	WebElement quantity;

	@FindBy(id = "group_1")
	WebElement size;

	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	WebElement addToCart;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement proceedToCheckOutButton;
	
	
	
	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void quantityField(String enterQuantity)
	{
		Action.typeText(quantity, enterQuantity);
	}
	
	public void sizeField(String enterSize) throws Exception
	{
		Action.selectDropdown(size, enterSize);
	}
	
	public void clickOnAddToCartButton()
	{
		addToCart.click();
	}
	
	public boolean addToCartValidation() throws InterruptedException
	{
		
		Action.visibiltyOfElement(addToCartMessage, 5);
		return Action.isPresent(addToCartMessage);
	}
	
	public OrderPage clickOnProccedToCheckOut()
	{
		proceedToCheckOutButton.click();
		return new OrderPage();
	}
	
	
}

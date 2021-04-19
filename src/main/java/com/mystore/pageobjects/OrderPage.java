package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {
	
	Action action  = new Action();

	@FindBy(xpath = "//*[@id='product_price_1_3_0']//span[@class='price']")
	WebElement unitPrice;

	@FindBy(xpath = "//*[@id='total_price_container']//span[@id='total_price']")
	WebElement totalPrice;

	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
	WebElement proceedToCheckOut;

	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public double getUnitPrice() {
		String unitPriceValue = unitPrice.getText();
		String unitPrice = unitPriceValue.replaceAll("[^a-zA-Z0-9]", "");
		Double unit = Double.parseDouble(unitPrice);
		return unit / 100;
	}

	public double getTotalPrice() {
		String totalPriceValue = totalPrice.getText();
		String totalPrice = totalPriceValue.replaceAll("[^a-zA-Z0-9]", "");
		Double total = Double.parseDouble(totalPrice);
		return total / 100;
	}

	public LoginPage proceedToCheckOut() {
		action.click(proceedToCheckOut);
		return new LoginPage();
	}

}

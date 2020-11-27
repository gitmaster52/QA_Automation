package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass {

	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocart;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderConfirmationPage orderconfirmationpage;


	@Test(groups="regression")
	public void endToEnd() throws Exception {
		indexpage = new IndexPage();
		searchresultpage = new SearchResultPage();
		addtocart = new AddToCartPage();
		orderpage = new OrderPage();
		loginpage = new LoginPage();
		addresspage = new AddressPage();
		paymentpage = new PaymentPage();
		orderconfirmationpage = new OrderConfirmationPage();
		
		logger.info("Searching for a Product");
		indexpage.searchProduct("t shirts");
		boolean result = searchresultpage.isProductAvailable();
		Assert.assertTrue(result);
		logger.info("Click on Product for more information");
		searchresultpage.clickOnProduct();
		logger.info("Select Quantity");
		addtocart.quantityField("2");
		logger.info("Select Size");
		addtocart.sizeField("M");
		logger.info("Click on Add to Cart Button");
		addtocart.clickOnAddToCartButton();
		logger.info("Click on Proceed to checkout Button");
		orderpage = addtocart.clickOnProccedToCheckOut();
		logger.info("Click on Proceed to checkout Button");
		loginpage=orderpage.proceedToCheckOut();

		logger.info("enter USERNAME and PASSWORD to signin");
		addresspage = loginpage.loginNavigationToAddressPage(prop.getProperty("username"),
				prop.getProperty("password"));
		logger.info("Click on Proceed to checkout Button");
		shippingpage = addresspage.clickOnProceedToCheckOut();
		logger.info("Click on Terms and Conditions");
		shippingpage.clickOnTermsAndConditionsCheckList();
		logger.info("Click on Proceed to checkout Button");
		paymentpage = shippingpage.clickOnProceedToCheckOut();
		logger.info("Click on Bank Wire Option");
		paymentpage.clickOnPayByBankWireOption();
		logger.info("Click on Confirm my order");
		orderconfirmationpage = paymentpage.clickOnIConfirmMyOrder();
		String actual = orderconfirmationpage.validateConfirmMessage();
		Assert.assertEquals(actual, "Your order on My Store is complete.");
		logger.info("Your Order complete successfully");

	}
}

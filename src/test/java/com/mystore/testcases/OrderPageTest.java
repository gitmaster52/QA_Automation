package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {

	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocart;
	OrderPage orderpage;


	@Test(groups="regression")
	public void priceTest() throws Exception {
		orderpage = new OrderPage();
		indexpage = new IndexPage();
		searchresultpage = new SearchResultPage();
		addtocart = new AddToCartPage();
		
		indexpage.searchProduct("t shirts");
		boolean result = searchresultpage.isProductAvailable();
		Assert.assertTrue(result);
		searchresultpage.clickOnProduct();
		addtocart.quantityField("2");
		addtocart.sizeField("M");
		addtocart.clickOnAddToCartButton();
		orderpage=addtocart.clickOnProccedToCheckOut();
		Double unitPrice = orderpage.getUnitPrice();
		Double actualTotalPrice = orderpage.getTotalPrice();
		Double expectedTotalPrice = (unitPrice * 2) + 2;
		Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
	}
}

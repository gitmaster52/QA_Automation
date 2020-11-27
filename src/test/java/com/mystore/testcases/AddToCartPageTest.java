package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {

	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocart;
	
	@Test(groups="regression")
	public void addToCartTest() throws Exception {
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
		boolean resultCart = addtocart.addToCartValidation();
		Assert.assertTrue(resultCart);
		

	}
}

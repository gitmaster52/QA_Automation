package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass{

	IndexPage indexpage;
	SearchResultPage searchresultpage;
	

	@Test(groups= {"smoke"})
	public void productAvailabilityTest() throws InterruptedException {
		indexpage = new IndexPage();
		searchresultpage = new SearchResultPage();
		indexpage.searchProduct("t shirts");
		boolean result = searchresultpage.isProductAvailable();
		Assert.assertTrue(result);
		searchresultpage.clickOnProduct();
	}	
}

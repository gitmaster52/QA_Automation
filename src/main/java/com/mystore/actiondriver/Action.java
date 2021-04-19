package com.mystore.actiondriver;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.BaseClass;

public class Action extends BaseClass implements ActionInterface {

	/**
	 * Used to click on element using javascript.
	 * 
	 * @param element
	 */
	public static void clickElementByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	/**
	 * Used to scroll to a particular element
	 * 
	 * @param element
	 */
	public static void scrollToElementByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoview;", element);
	}

	/**
	 * To refresh the page using javascript
	 * 
	 * @param element
	 */
	public static void refreshBrowserByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}


	/**
	 * 
	 * @param Move to element method
	 */
	public static void moveToElement(WebElement element) {
		Actions action = new Actions(getDriver());
		action.moveToElement(element).build().perform();

	}
	
	/**
	 * 
	 * @param
	 * @param Validating the application current page title
	 * @return
	 */
	public static boolean validatePageTitle(String expectedTitle) {
		boolean titleMatch = false;
		if (expectedTitle.equals(getDriver().getTitle())) {
			titleMatch = true;
		}
		return titleMatch;
	}

	/**
	 * Checking whether alart is present or not
	 * 
	 * @return
	 */
	public static boolean isAlertPresent() {
		try {
			getDriver().switchTo().alert();
			return true;

		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	/**
	 * 
	 * @param Explicit wait for visibility of element
	 * @param time
	 */
	public static void visibiltyOfElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * 
	 * @param Explicit wait for element clickable
	 * @param time
	 */
	public static void elementClickable(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * 
	 * @param Explicit wait for element to be selected
	 * @param time
	 */
	public static void elementToBeSelected(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	/**
	 * 
	 * @param Fluent wait for visibility of element with time intervals
	 * @param time
	 */
	public static void fluentWait(WebElement element, int targetTime, int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(targetTime))
				.pollingEvery(Duration.ofSeconds(intervalTime)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Take the screenshot
	 * @param destLocation
	 */
	
	public static String getScreenhot(WebDriver driver) throws Exception {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Reports/Failure_Screenshot/Date("+actualDate+")Time.png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	/**
	 * 
	 * @param to check whether the element is displayed or not on the web page
	 * @return
	 */
	public static boolean isPresent(WebElement element) {
		boolean isDisp = false;
		if (element.isDisplayed()) {
			isDisp = true;
		}
		return isDisp;
	}

	/**
	 * 
	 * @param to check whether the element is clickable or not on the web page
	 * @return
	 */
	public static boolean isEnable(WebElement element) {
		boolean isEnable = false;
		if (element.isEnabled()) {
			isEnable = true;
		}
		return isEnable;
	}

	/**
	 * 
	 * @param to check whether the element is selected or not on the web page
	 * @return
	 */
	public static boolean isSelect(WebElement element) {
		boolean isSelect = false;
		if (element.isSelected()) {
			isSelect = true;
		}
		return isSelect;
	}
	/**
	 * Select class to select the values from dropdown
	 * @param element
	 * @param text
	 * @throws Exception 
	 */
	public static void selectDropdownByText(WebElement element, String text) throws Exception {
		Select s = new Select(element);
		try {
		s.selectByVisibleText(text);
		}catch(Exception  e)
		{
			throw new Exception("The web element is not present in the drop down");
		}
	}
	
	public static void selectDropdownByValue(WebElement element, String text) throws Exception {
		Select s = new Select(element);
		try {
		s.selectByValue(text);
		}catch(Exception  e)
		{
			throw new Exception("The web element is not present in the drop down");
		}
	}
	
	public static void typeText(WebElement ele,String sendText)
	{
		ele.clear();
		ele.sendKeys(sendText);
	}
	
	/**
	 * A Method to select the Radio button by text
	 */
	public static void selectRadiobuttonByText(List<WebElement> element, String value)
	{
		for (WebElement webElement : element) {
			if(webElement.getText().equalsIgnoreCase(value))
			{
				webElement.click();
				break;
			}
		}
	}
	
	/**
	 * A Method to select the value of Radio button
	 */
	public static void selectRadiobuttonByValue(List<WebElement> element, String value)
	{
		for (WebElement webElement : element) {
			if(webElement.getAttribute("value").equalsIgnoreCase(value))
			{
				webElement.click();
				break;
			}
		}
	}
	/**
	 * A Method to select the value from Check boxes
	 * @param element
	 * @param check
	 */
	public static void selectCheckbox(List<WebElement> element,String check)
	{
		String[] arratCheck = check.split(",");
		for (String value : arratCheck) {
			for (WebElement webElement : element) {
				if(webElement.getText().equalsIgnoreCase(value))
				{
					webElement.click();
					break;
				}
				
			}
		}
	}

	@Override
	public void click(WebElement ele) {
		ele.click();
		
	}
	
}

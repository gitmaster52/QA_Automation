package com.mystore.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mystore.dataprovider.DataProviders;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends DataProviders {

	public static Properties prop;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
	public static Date date = new Date();
	public static String actualDate = sdf.format(date);
    public Logger logger;
    public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	
    @BeforeMethod(groups= {"smoke","sanity","regression"})
    @Parameters("browser")
	public void openBrowser(String browser) throws IOException {
		FileInputStream fis = new FileInputStream("./Configurations/Config.properties");
		prop = new Properties();
		prop.load(fis);
		
		logger = Logger.getLogger("MyStore");
		PropertyConfigurator.configure("./Configurations/Log4j.properties");

		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else  {
			System.out.println("Please use proper browser");
		}
		logger.info("Opening the browser");
		logger.info("Invoking the URL");
		getDriver().get(prop.getProperty("url"));
		logger.info("Maximizing the window");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
    
    public static WebDriver getDriver()
	{
		return driver.get();
	}
    
    @AfterMethod(groups= {"smoke","sanity","regression"})
	public void tearDown() {
    	getDriver().close();
	}
}

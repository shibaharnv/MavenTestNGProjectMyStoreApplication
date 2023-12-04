package com.mystore.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.mystore.utility.ExtentManager;

/**
 * @author manoj
 * Added ThreadLocal for cross browser Testing
 */

public class BaseClass {
	
	public static Properties prop;
//	public static WebDriver driver;
	
//	Declare ThreadLocal driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver GetDriver() {
		return driver.get();
	}
	
	@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
	public void loadConfig() {
		
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") +"//Configuartion//Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void launchApp(String browserName ) {
		
	//	String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
		//	driver = new FirefoxDriver();
		//	driver.set(new FirefoxDriver());
		//	WebDriverManager.firefoxdriver().setup();	
			driver.set(new FirefoxDriver());

		} else if (browserName.equalsIgnoreCase("IE")) {
			//driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}
		// Delete all the cookies
		// Maximize the screen
		GetDriver().manage().window().maximize();
//		Action.implicitWait(GetDriver(), 10);
//		Action.pageLoadTimeOut(GetDriver(), 30);
		
		System.out.println("URL "+prop.getProperty("url"));
		// Launching the URL
		GetDriver().get(prop.getProperty("url"));
	}
	
	/*
	 * public static String screenShot(WebDriver driver,String filename) { String
	 * dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 * TakesScreenshot takesScreenshot = (TakesScreenshot) driver; File source =
	 * takesScreenshot.getScreenshotAs(OutputType.FILE); String destination =
	 * System.getProperty("user.dir")+"\\ScreenShots\\"+filename+"_"+dateName+".png"
	 * ; File finalDestination= new File(destination); try {
	 * FileUtils.copyFile(source, finalDestination); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.getMessage(); } return destination; }
	 */
		 
		 public static String getCurrentTime() {  
		     String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());  
		     return currentDate;  
		 }  
		 
		 @AfterSuite
		 public void AfterSuite() {
		  
			 ExtentManager.endReport();
		 }
	

}

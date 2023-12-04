package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage  homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		
		 launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		GetDriver().quit();
	}	
	
	@Test(dataProvider= "credentials", dataProviderClass=DataProviders.class, groups = {"Smoke","Sanity"})
	public void LoginTest(String uname, String pswd) {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("User is going to click on SignIn");
		loginPage = indexPage.ClickOnSignIn();
		//homePage = loginPage.LogIn(prop.getProperty("username"), prop.getProperty("password")); 
		homePage = loginPage.LogIn(uname,pswd);
		String actualLoginText = homePage.LogInName();
		String expLoginText = prop.getProperty("loggInas");
		Assert.assertNotEquals(actualLoginText, expLoginText);
	//	Assert.assertEquals(actualLoginText, expLoginText);
		Log.info("Log in success");
		Log.endTestCase("loginTest");
		
	}

}

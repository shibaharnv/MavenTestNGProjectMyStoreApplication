/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

/**
 * @author manoj
 *
 */
public class IndexPageTest extends BaseClass {
	IndexPage indexPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		
		 launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		GetDriver().quit();
	}
	
	@Test(groups ="Smoke")
	public void Verifylogo() {
		indexPage = new IndexPage();
		boolean result = indexPage.ValidateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups ="Smoke")
	public void Verifytitle() {
		String title= indexPage.GetTitle();
		Assert.assertEquals(title, "Automation Exercise");
	}

}

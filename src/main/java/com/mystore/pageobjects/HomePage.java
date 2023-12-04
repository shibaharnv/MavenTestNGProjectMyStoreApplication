/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Manoj
 *
 */
public class HomePage extends BaseClass{
	
	public HomePage() {
		PageFactory.initElements(GetDriver(), this);
	}
	
	@FindBy(xpath="//*[contains(text(),' Logged in as ')]")
	WebElement loggInAs;
	
	public String LogInName() {
		String loggInas = loggInAs.getText(); 
		return loggInas;
	}
	
	public String GetCurrentURL() {
		String homepageURL = GetDriver().getCurrentUrl();
		return homepageURL;
	}
	

}

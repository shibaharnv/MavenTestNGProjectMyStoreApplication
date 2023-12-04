/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Manoj
 *
 */
public class AccountCreationPage extends BaseClass {
	
	public AccountCreationPage(){
		PageFactory.initElements(GetDriver(), this);
	}
	
	@FindBy(xpath="//b[contains(text(),'Enter Account Information')]")
	WebElement accountInfo;
	
	public boolean AccountInfo() {
		return Action.isDisplayed(GetDriver(), accountInfo);
	}
	
	

}

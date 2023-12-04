package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	public IndexPage(){
		PageFactory.initElements(GetDriver(), this);
	}
	
	@FindBy(xpath="//a[contains(@href,'/login')]")
	WebElement sigInBtn;
	
	@FindBy(xpath="//img[@alt='Website for automation practice']")
	WebElement logo;
	
	public LoginPage ClickOnSignIn() {
		Action.click(GetDriver(), sigInBtn);
		return new LoginPage();
	}
	
	public boolean ValidateLogo() {
		return Action.isDisplayed(GetDriver(), logo);
	}
	
	public String GetTitle() {
		String myStoreTitle = GetDriver().getTitle();
		return myStoreTitle;
	}

}

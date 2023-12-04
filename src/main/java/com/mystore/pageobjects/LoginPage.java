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
public class LoginPage extends BaseClass {
	
	public LoginPage(){
		PageFactory.initElements(GetDriver(), this);
	}
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement emailLogIn;
	
	@FindBy(xpath="//input[@data-qa='login-password']")
	WebElement password;
	
	@FindBy(xpath="//button[@data-qa='login-button']")
	WebElement logIn;
	
	@FindBy(xpath="//input[@data-qa='signup-name']")
	WebElement nameSignUp;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement emailAdrsSignUp;
	
	@FindBy(xpath="//button[@data-qa='signup-button']")
	WebElement signUp;
	
	public HomePage LogIn(String uname, String pswd) {
		Action.type(emailLogIn, uname);
		Action.type(password, pswd);
		Action.click(GetDriver(), logIn);
		return new HomePage();
	}
	
	public AccountCreationPage CreateAccount(String name,String emailadrs) {
		Action.type(nameSignUp, emailadrs);
		return new AccountCreationPage();
		
	}
	
	

}

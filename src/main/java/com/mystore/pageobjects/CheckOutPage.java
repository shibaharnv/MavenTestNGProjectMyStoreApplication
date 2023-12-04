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
public class CheckOutPage extends BaseClass{
	
	public CheckOutPage(){
		PageFactory.initElements(GetDriver(), this);
		
	}
	
	@FindBy(xpath="//h2[contains(text(),'Review Your Order')]")
	WebElement proceedToCheckOut;
	
	@FindBy(css="p.cart_total_price")
	WebElement totalPrice;
	
	public boolean ProceedTocheckout() {
		return Action.isDisplayed(GetDriver(), proceedToCheckOut);
	}
	
	public String TotalPrice() {
		String totalprice = totalPrice.getText(); 
		return totalprice;
	}
	

}

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
public class ViewCartPage extends BaseClass{
	
	public ViewCartPage(){
		PageFactory.initElements(GetDriver(), this);
		
	}
	
	@FindBy(css="p.cart_total_price")
	WebElement Price;
	
	@FindBy(xpath="//a[contains(text(),'Proceed To Checkout')]")
	WebElement proceedToCheckOut;
	
	public ViewCartPage Totalprice() {
		Action.isDisplayed(GetDriver(), Price);
		return new ViewCartPage();
	}
	
	public CheckOutPage proceedToCheckOut() {
		Action.click(GetDriver(), proceedToCheckOut);
		return new CheckOutPage();
	}
	

}

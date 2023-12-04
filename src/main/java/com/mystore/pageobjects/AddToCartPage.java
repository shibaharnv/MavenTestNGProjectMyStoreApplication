package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	
	public AddToCartPage(){
		PageFactory.initElements(GetDriver(), this);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'Add to cart')][1]")
	WebElement addToCart;
	
	public AddToCartPage AccountInfp() {
		Action.click(GetDriver(), addToCart);
		return new AddToCartPage();
		
	}
	
	 

}

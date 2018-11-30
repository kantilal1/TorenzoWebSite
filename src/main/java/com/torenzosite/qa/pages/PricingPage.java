package com.torenzosite.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.torenzosite.qa.base.TestBase;

public class PricingPage extends TestBase {
	
	
	@FindBy(linkText= "TRY TORENZO FOR FREE")
	WebElement tryTorenzoForFree;
	
	public PricingPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public PricingPage clickOnTryTorenzoForFree() throws IOException{
		tryTorenzoForFree.click();
		return new PricingPage();
		
	}
	
	public String validatePricingPageTitle(){
		
		return driver.getTitle();
	}

}

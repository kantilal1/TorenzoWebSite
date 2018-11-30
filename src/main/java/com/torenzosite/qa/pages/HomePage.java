package com.torenzosite.qa.pages;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.torenzosite.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(linkText= "Torenzo POS")
	WebElement torenzoPOS;
	
	@FindBy(linkText= "Features")
	WebElement features;

	@FindBy(linkText= "Hardware")
	WebElement hardware;

	@FindBy(linkText= "Pricing")
	WebElement pricing;

	@FindBy(linkText= "About Us")
	WebElement aboutUs;

	@FindBy(xpath= "//*[contains(text(),'Try Torenzo For Free')]")
	WebElement tryTorenzoForFree;

	@FindBy(linkText= "Email Address")
	WebElement emailAddress;
	
	@FindBy(linkText= "CLICK HERE TO TRY TORENZO FOR FREE")
	WebElement ClickHereToTryTorenzoForFree;
		
/*	<a href="#manage" data-toggle="pill">Manage</a>
		
	<a rel="jumpdown" href="#features" style="">Features</a>*/	
	//Initializing the Page Objects:
	
	public HomePage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	

		public String validateHomePageTitle(){
			
			return driver.getTitle();
		}	
		
		public TorenzoPOSPage clickOnTorenzoPOS() throws IOException{
			torenzoPOS.click();
			return new TorenzoPOSPage();
			
			
		}
		
		public FeaturesPage clickOnFeatures() throws IOException{
			features.click();
			return new FeaturesPage();
			
		}
		
		public HardwarePage clickOnHardware() throws IOException{
			hardware.click();
			return new HardwarePage();
			
		}
			
	
		public PricingPage clickOnPricing() throws IOException{
			pricing.click();
			return new PricingPage();
			
		}
	
		public TryTorenzoForFreePage clickOnTryTorenzoForFree() throws IOException{
			tryTorenzoForFree.click();
			return new TryTorenzoForFreePage();
			
		}
		
		
		
}




/*public HomePage login(String un, String pwd){
	username.sendKeys(un);
	password.sendKeys(pwd);
	//loginBtn.click();
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", loginBtn);
	    	
	return new HomePage();
}
*/
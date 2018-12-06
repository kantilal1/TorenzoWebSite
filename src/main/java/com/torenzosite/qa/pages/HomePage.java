package com.torenzosite.qa.pages;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.torenzosite.qa.base.TestBase;
import static com.torenzosite.qa.util.TestUtil.title;
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

	@FindBy(xpath= "//input[@type='text' and @placeholder='Email Address']")
	WebElement emailAddress;
	
	@FindBy(xpath= "//input[@type='submit' and @value='CLICK HERE TO TRY TORENZO FOR FREE']")
	WebElement ClickHereToTryTorenzoForFree;
	
	@FindBy(xpath= "//a[text()='Leave us a message']")
	WebElement LeaveUsaMessage;
	
	@FindBy(xpath= "//a[text()='Privacy Policy' ]")
	WebElement privacyPolicy;
	
	@FindBy(xpath= "//a[text()='Website by Pronto' ]")
	WebElement websiteByPronto;
	
	@FindBy(xpath= "//a[text()='Home']")
	WebElement home;
	
	@FindBy(xpath= "//a[text()='Contact Us' ]")
	public static WebElement contactUs;

	@FindBy(xpath= "//a[text()='Blog' ]")
	WebElement blog;
		


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
		
		public AboutUsPage clickOnAboutUs() throws IOException{
			aboutUs.click();
			return new AboutUsPage();
			
		}
		
		public void passEmailAddress(String email)throws IOException{
		
			emailAddress.click();
			emailAddress.sendKeys(email);
		
		}
		
		public void ClickHereOnToTryTorenzoForFree(){
			ClickHereToTryTorenzoForFree.click();
		 title = driver.getTitle();
			
		}
		
		public LeaveUsPage ClickOnLeaveUsaMessage() throws IOException{
			
			LeaveUsaMessage.click();
			
			return new LeaveUsPage();	 
			
		}
		
		public void ClickOnPrivacyPolicy(){
			privacyPolicy.click();
	
			
		}
		
		public void ClickOnWebsiteByPronto(){
			websiteByPronto.click();
	
			
		}
		
		public HomePage ClickOnHome() throws IOException{
			home.click();
             return new HomePage();	
			
		}
		
		public ContactUsPage ClickOnContactUs() throws IOException{
			contactUs.click();
			return new ContactUsPage();
	
			
		}
		
		public void ClickOnBlog(){
			blog.click();
	
			
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
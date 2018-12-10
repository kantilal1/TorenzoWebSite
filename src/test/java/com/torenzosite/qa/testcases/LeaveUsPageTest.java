package com.torenzosite.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.ContactUsPage;
import com.torenzosite.qa.pages.FeaturesPage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.LeaveUsPage;
import com.torenzosite.qa.pages.TryTorenzoForFreePage;
import com.torenzosite.qa.util.TestUtil;

public class LeaveUsPageTest extends TestBase{

	HomePage homePage;
	LeaveUsPage leaveUsPage;
	ContactUsPage contactUsPage;
	FeaturesPage featuresPage;
	TryTorenzoForFreePage tryTorenzoForFreePage;
	public LeaveUsPageTest() throws IOException {
		super();
	
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();	
		leaveUsPage = new LeaveUsPage();
		contactUsPage =new ContactUsPage();
		featuresPage =new FeaturesPage();
		tryTorenzoForFreePage =new TryTorenzoForFreePage();
	} 
	
	@Test(priority=14)
	public void verifyHomePageTitle(){
			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 			
	}
	
	@Test(priority=15)
	public void verifyLeaveUsPageTitle() throws IOException, InterruptedException{
		
		leaveUsPage = homePage.ClickOnLeaveUsaMessage();
		Thread.sleep(3000);
		System.out.println("Title==>" +leaveUsPage.validateLeaveUsMessageTitle());
		Assert.assertEquals(leaveUsPage.validateLeaveUsMessageTitle(), "Support", "Leave Us Message Page Not not found upon clicking on Leave Us Message");		 			
		leaveUsPage.passFirstName("Sachin");
		leaveUsPage.passEmailID("sachin.patil.uk@gmail.com");
		leaveUsPage.passPhoneNo("9552619077");
		leaveUsPage.passMessage("Hello");
		leaveUsPage.clickOnSubmit();	
		Thread.sleep(8000);
		Assert.assertEquals(contactUsPage.validateThankYouPageTitle(), "Thank You! - Detroit, Ann Arbor, Warren | Torenzo", "Thank You Page Title not found after failing form and clicking on Submit");			
		System.out.println("Done");
		
	}
	
	@Test(priority=13)
	public void closeToForm() throws IOException, InterruptedException{
		
		featuresPage = homePage.clickOnFeatures();
		Thread.sleep(3000);
		TestUtil.scrollUpByPixel(500);
		tryTorenzoForFreePage = featuresPage.ClickOnTryTorenzoForFreePage();
		tryTorenzoForFreePage.clickOnClose();
		
	}
	
	@Test(priority=15)
	public void fillFormWithEmptyDataLeaveUsMessage() throws IOException, InterruptedException{
		
		leaveUsPage = homePage.ClickOnLeaveUsaMessage();
		Thread.sleep(3000);
		System.out.println("Title==>" +leaveUsPage.validateLeaveUsMessageTitle());
		Assert.assertEquals(leaveUsPage.validateLeaveUsMessageTitle(), "Support", "Leave Us Message Page Not not found upon clicking on Leave Us Message");		 				
		leaveUsPage.clickOnSubmit();	
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

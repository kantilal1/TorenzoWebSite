package com.torenzosite.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.ContactUsPage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.LeaveUsPage;
import com.torenzosite.qa.pages.TryTorenzoForFreePage;

public class LeaveUsPageTest extends TestBase{

	HomePage homePage;
	LeaveUsPage leaveUsPage;
	ContactUsPage contactUsPage;
	public LeaveUsPageTest() throws IOException {
		super();
	
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();	
		leaveUsPage = new LeaveUsPage();
		contactUsPage =new ContactUsPage();
	} 
	
	@Test(priority=0)
	public void verifyHomePageTitle(){
			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 			
	}
	
	@Test(priority=1)
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
		Assert.assertEquals(contactUsPage.validateThankYouPageTitle(), "Thank You! - Detroit, Ann Arbor, Warren | Torenzo", "Thank Yo uPage Title not found after failing form and clicking on Submit");			
		System.out.println("Done");
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

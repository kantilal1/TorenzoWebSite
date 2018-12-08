package com.torenzosite.qa.testcases;

import java.io.IOException;
import static com.torenzosite.qa.pages.HomePage.contactUs;
import static com.torenzosite.qa.pages.ContactUsPage.message;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.ContactUsPage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.TryTorenzoForFreePage;
import com.torenzosite.qa.util.TestUtil;

public class ContactUsPageTest extends TestBase {

	HomePage homePage;
	ContactUsPage contactUsPage;
	TryTorenzoForFreePage tryTorenzoForFreePage;
	
	public ContactUsPageTest() throws IOException {
		super();
		
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();
		tryTorenzoForFreePage = new TryTorenzoForFreePage();
		contactUsPage =new ContactUsPage();
		
	} 
	
	@Test(priority=5)
	public void verifyHomePageTitle(){			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");
		 		
	}
	
	@Test(priority=6)
	public void verifyContactPage() throws InterruptedException, IOException{
		Thread.sleep(3000);
		TestUtil.scrollUpAtEndOFPage();	
		contactUsPage = homePage.ClickOnContactUs();		
		Thread.sleep(4000);
		System.out.println("Title of Contact US page=>" +contactUsPage.validateContactUsPageTitile());	
		Assert.assertEquals(contactUsPage.validateContactUsPageTitile(), "Contact Us - Detroit, Ann Arbor, Warren | Torenzo", "Contact us Page is not displayed upon clicking on Contact Us from header");		
	}
	
	@Test(priority=7)
	public void fillFormToConatctUs() throws InterruptedException, IOException{
		Thread.sleep(3000);
		TestUtil.scrollUpAtEndOFPage();	
		contactUsPage = homePage.ClickOnContactUs();	
		Thread.sleep(3000);
		contactUsPage.passFirstName("Sachin");
		contactUsPage.passLastName("Patil");
		contactUsPage.passEmailID("sachin.patil.uk@gmail.com");
		contactUsPage.passPhoneNo("9978451232");
		contactUsPage.passCompanyName("Torenzo");
		contactUsPage.passSubject("For Bussiness");
		//TestUtil.scrollUpHorizontalORVIsibilityOFElement(message);
		contactUsPage.passMessage("Hello Team, Hope you are all doing great");		
	/*	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");*/
		TestUtil.scrollUpByPixel(500);
		contactUsPage.clickOnSubmit();		
		System.out.println("Title of Contact Us Page ==>" +contactUsPage.validateThankYouPageTitle());
		Assert.assertEquals(contactUsPage.validateThankYouPageTitle(), "Thank You! - Detroit, Ann Arbor, Warren | Torenzo", "Thank Yo uPage Title not found after failing form and clicking on Submit");			
		System.out.println("Done");

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}

package com.torenzosite.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.FeaturesPage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.TorenzoPOSPage;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	TorenzoPOSPage torenzoPOSPage;
	FeaturesPage featuresPage;
		
	public HomePageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();
		torenzoPOSPage = new TorenzoPOSPage();
		featuresPage = new FeaturesPage();
		
	} 
	
	@Test(priority=0)
	public void verifyHomePageTitle(){
			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");
		 		
	}
	
	@Test(priority=1)
	public void verifyTorenzoPOSPageTitle() throws IOException{
		
		System.out.println("NO");
		torenzoPOSPage = homePage.clickOnTorenzoPOS();
		Assert.assertEquals(torenzoPOSPage.validateTorenzoPOSPageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 
		 System.out.println("Title of torenzopos==>" +torenzoPOSPage.validateTorenzoPOSPageTitle());
	
		System.out.println("hello1");
		
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

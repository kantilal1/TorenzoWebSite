package com.torenzosite.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.FeaturesPage;
import com.torenzosite.qa.pages.HardwarePage;
import com.torenzosite.qa.pages.HomePage;

public class HardwarePageTest extends TestBase{
		HomePage homePage;
		HardwarePage hardwarePage;
		
		public HardwarePageTest() throws IOException{
			super();
		}
		
		
		@BeforeMethod
		public void setUp() throws IOException, InterruptedException{
			
			initialization();
			homePage = new HomePage();	
			hardwarePage = new HardwarePage();
			
		} 	
		
		
		@Test(priority=0)
		public void verifyHomePageTitle(){
				
			System.out.println("Title==>" +	homePage.validateHomePageTitle());
			Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 
			
		}
		
		@Test(priority=1)
		public void verifyHardwarePageTitle() throws IOException{
			hardwarePage = homePage.clickOnHardware();
			System.out.println("Title==>" +hardwarePage.validateHardwarePageTitle());
			Assert.assertEquals(hardwarePage.validateHardwarePageTitle(), "Mobile POS Software, POS Hardware - Detroit, Ann Arbor, Warren | Torenzo", "Hardware Page titile not found");		 
			
			hardwarePage.clickOnTryTorenzoForFree();
			System.out.println("done");
			
		}
	
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
		
}

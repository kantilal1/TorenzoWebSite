package com.torenzosite.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.FeaturesPage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.PricingPage;

public class FeaturePageTest extends TestBase{
	
	HomePage homePage;
	FeaturesPage featuresPage;
	public FeaturePageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();	
		featuresPage = new FeaturesPage();
		
	} 	
	
	
	@Test(priority=0)
	public void verifyHomePageTitle(){
			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 
		
	}
	
	@Test(priority=1)
	public void verifyFeaturesPageTitle() throws IOException{
		featuresPage = homePage.clickOnFeatures();
		Assert.assertEquals(featuresPage.validateFeaturesPageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "FeaturePage titile not found");		 
		 System.out.println("Title of torenzopos==>" +featuresPage.validateFeaturesPageTitle());
		 System.out.println("Sell, Manage , Grow, Report");
		 featuresPage.clickOnSell();
		 System.out.println("Contain under Sell tab ==>" +featuresPage.validatePointsOfSaleTitle());
		 Assert.assertEquals(featuresPage.validatePointsOfSaleTitle(), "POINT OF SALE", "POINT OF SALE title not found");		 
		 featuresPage.clickOnManage();
		 System.out.println("Contain under Manage tab ==>" +featuresPage.validateProductsTitle());
		 Assert.assertEquals(featuresPage.validateProductsTitle(), "PRODUCTS", "PRODUCTS title not found");		 
		featuresPage.clickOnReport();
		 System.out.println("Contain under Report tab ==>" +featuresPage.validateCustomReportsTitle());
		 Assert.assertEquals(featuresPage.validateCustomReportsTitle(), "CUSTOM REPORTS", "CUSTOM REPORTS title not found");		 
		System.out.println("value==>" +featuresPage.getTextFromGrow());
		 featuresPage.clickOnGrow();
		 System.out.println("Contain under Report tab ==>" +featuresPage.validateScalabilityTitle());
		 Assert.assertEquals(featuresPage.validateScalabilityTitle(), "SCALABILITY", "SCALABILITY title not found");		 
	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

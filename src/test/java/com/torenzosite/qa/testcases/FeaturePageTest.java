package com.torenzosite.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static com.torenzosite.qa.pages.FeaturesPage.tryTorenzoForFree;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.FeaturesPage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.PricingPage;
import com.torenzosite.qa.pages.TryTorenzoForFreePage;
import com.torenzosite.qa.util.TestUtil;

public class FeaturePageTest extends TestBase{
	
	HomePage homePage;
	FeaturesPage featuresPage;
	TryTorenzoForFreePage tryTorenzoForFreePage;
	public FeaturePageTest() throws IOException {
		super();
		
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();	
		featuresPage = new FeaturesPage();
		tryTorenzoForFreePage =new TryTorenzoForFreePage ();
	} 	
	
	
	@Test(priority=10)
	public void verifyHomePageTitle(){
			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 
		
	}
	
	@Test(priority=11)
	public void verifyFeaturesPageTitle() throws IOException, InterruptedException{
		featuresPage = homePage.clickOnFeatures();
		Assert.assertEquals(featuresPage.validateFeaturesPageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "FeaturePage titile not found");		 
		 System.out.println("Title of torenzopos==>" +featuresPage.validateFeaturesPageTitle());
		 System.out.println("Sell, Manage , Grow, Report");
		 Thread.sleep(1000);
		 featuresPage.clickOnSell();
		 System.out.println("Contain under Sell tab ==>" +featuresPage.validatePointsOfSaleTitle());
		 Assert.assertEquals(featuresPage.validatePointsOfSaleTitle(), "POINT OF SALE", "POINT OF SALE title not found");		 
		 Thread.sleep(1000);
		 featuresPage.clickOnManage();
		 System.out.println("Contain under Manage tab ==>" +featuresPage.validateProductsTitle());
		 Assert.assertEquals(featuresPage.validateProductsTitle(), "PRODUCTS", "PRODUCTS title not found");		 
		 Thread.sleep(1000);
		 featuresPage.clickOnReport();
		 System.out.println("Contain under Report tab ==>" +featuresPage.validateCustomReportsTitle());
		 Assert.assertEquals(featuresPage.validateCustomReportsTitle(), "CUSTOM REPORTS", "CUSTOM REPORTS title not found");		 
		System.out.println("value==>" +featuresPage.getTextFromGrow());
		 Thread.sleep(1000);
		featuresPage.clickOnGrow();
		 System.out.println("Contain under Report tab ==>" +featuresPage.validateScalabilityTitle());
		 Assert.assertEquals(featuresPage.validateScalabilityTitle(), "SCALABILITY", "SCALABILITY title not found");		 
	
	}
	
	
	@Test(priority=12)
	public void verifyTryTorenzoForFree() throws IOException, InterruptedException{
		featuresPage = homePage.clickOnFeatures();
		Thread.sleep(3000);
		TestUtil.scrollUpByPixel(500);
		tryTorenzoForFree.click();	
			
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element =driver.findElement(By.xpath("//a[@class='btn btn-primary btn-lg' and text()='Try Torenzo For Free']"));		
		js.executeScript("arguments[0].scrollIntoView()", element);
	    element.click();*/	   
	
	    System.out.println("Title of Contact US page=>" + tryTorenzoForFreePage.validateTryTorenzoForFree());	
	    
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today window not found upon clicking on Try Torenzo for FREE today from Feature page");
	
	}
	
	@Test(priority=13)
	public void fillFormFromFeaturePage() throws IOException, InterruptedException{
		featuresPage = homePage.clickOnFeatures();
		Thread.sleep(3000);
		TestUtil.scrollUpByPixel(500);
		tryTorenzoForFreePage = featuresPage.ClickOnTryTorenzoForFreePage();	   
	    System.out.println("Title of Contact US page=>" + tryTorenzoForFreePage.validateTryTorenzoForFree());	    
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today window not found upon clicking on Try Torenzo for FREE today from Feature page");
		tryTorenzoForFreePage.passFirstName("Sachin");
		tryTorenzoForFreePage.passLastName("Patil");
		tryTorenzoForFreePage.passBussiness("Restarant");
		Select drpCountry = new Select(driver.findElement(By.id("input_6_7")));
		drpCountry.selectByVisibleText("Andorra");
		tryTorenzoForFreePage.passPhoneNo("9552619077");
		tryTorenzoForFreePage.passEmailID("sachin.patil.uk@gmail.com");
		tryTorenzoForFreePage.clickOnSubmit();
		System.out.println("	===>>>	TryTorenzoForFreePageTest class Done <====");
	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

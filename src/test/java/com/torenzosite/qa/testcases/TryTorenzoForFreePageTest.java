package com.torenzosite.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.text.DecimalFormat;
import static com.torenzosite.qa.pages.TryTorenzoForFreePage.phoneNo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.ContactUsPage;
import com.torenzosite.qa.pages.HardwarePage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.TryTorenzoForFreePage;

public class TryTorenzoForFreePageTest extends TestBase {
	
	HomePage homePage;
	TryTorenzoForFreePage tryTorenzoForFreePage;
	ContactUsPage contactUsPage;
	
	public TryTorenzoForFreePageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();	
		tryTorenzoForFreePage = new TryTorenzoForFreePage();
		contactUsPage =new ContactUsPage(); 
		
	} 
	@Test(priority=21)
	public void verifyHomePageTitle(){
			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 
		
	}
	
	@Test(priority=22)
	public void clickOnTryTorenzoForFreeAndFillForm() throws IOException, InterruptedException{
		Thread.sleep(2000);
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		Thread.sleep(2000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 	
		tryTorenzoForFreePage.passFirstName("Sachin");
		tryTorenzoForFreePage.passLastName("Patil");
		tryTorenzoForFreePage.passBussiness("Restarant");	
		Select drpCountry = new Select(driver.findElement(By.id("input_6_7")));
		drpCountry.selectByVisibleText("Andorra");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='(955)261-9077';", phoneNo);			
		tryTorenzoForFreePage.passEmailID("sachin.patil.uk@gmail.com");
		tryTorenzoForFreePage.clickOnSubmit();
		Thread.sleep(3000);
		Assert.assertEquals(contactUsPage.validateThankYouPageTitle(), "Thank You! - Detroit, Ann Arbor, Warren | Torenzo", "Thank You Page Title not found after failing form and clicking on Submit");			
		System.out.println("Done");
		System.out.println("	===>>>	TryTorenzoForFreePageTest class Done <====");
		
	}
	
	@Test(priority=23)
	public void fillFormWithEmptyData() throws IOException, InterruptedException{
		Thread.sleep(2000);
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		Thread.sleep(2000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 	
		tryTorenzoForFreePage.passFirstName("");
		tryTorenzoForFreePage.passLastName("");
		tryTorenzoForFreePage.passBussiness("");	
		Select drpCountry = new Select(driver.findElement(By.id("input_6_7")));
		drpCountry.selectByVisibleText("Andorra");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='';", phoneNo);			
		tryTorenzoForFreePage.passEmailID("");
		tryTorenzoForFreePage.clickOnSubmit();		
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");

		
	}
	
	@Test(priority=24)
	public void fillFormWithEmptyPhoneNumber() throws IOException, InterruptedException{
		Thread.sleep(2000);
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		Thread.sleep(2000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 	
		tryTorenzoForFreePage.passFirstName("Sachin");
		tryTorenzoForFreePage.passLastName("Patil");
		tryTorenzoForFreePage.passBussiness("Restarant");	
		Select drpCountry = new Select(driver.findElement(By.id("input_6_7")));
		drpCountry.selectByVisibleText("Andorra");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='';", phoneNo);			
		tryTorenzoForFreePage.passEmailID("sachin.patil.uk@gmail.com");
		tryTorenzoForFreePage.clickOnSubmit();		
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
		
	}
	
	@Test(priority=25)
	public void fillFormWithEmptyEmaildId() throws IOException, InterruptedException{
		Thread.sleep(2000);
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		Thread.sleep(2000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 	
		tryTorenzoForFreePage.passFirstName("Sachin");
		tryTorenzoForFreePage.passLastName("Patil");
		tryTorenzoForFreePage.passBussiness("Restarant");	
		Select drpCountry = new Select(driver.findElement(By.id("input_6_7")));
		drpCountry.selectByVisibleText("Andorra");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='(222)555-4545';", phoneNo);			
		tryTorenzoForFreePage.passEmailID("");
		tryTorenzoForFreePage.clickOnSubmit();		
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
	
	}
	
	@Test(priority=26)
	public void fillFormWithEmptyBussinesName() throws IOException, InterruptedException{
		Thread.sleep(2000);
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		Thread.sleep(2000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 	
		tryTorenzoForFreePage.passFirstName("Sachin");
		tryTorenzoForFreePage.passLastName("Patil");
		tryTorenzoForFreePage.passBussiness("");	
		Select drpCountry = new Select(driver.findElement(By.id("input_6_7")));
		drpCountry.selectByVisibleText("Andorra");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='(222)555-4545';", phoneNo);			
		tryTorenzoForFreePage.passEmailID("");
		tryTorenzoForFreePage.clickOnSubmit();		
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
	
	}
	
	@Test(priority=27)
	public void closeTheForm() throws IOException, InterruptedException{
		Thread.sleep(2000);
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		Thread.sleep(2000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 		
		tryTorenzoForFreePage.clickOnClose();
		System.out.println("Done");
	
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}



























/*driver.findElement(By.xpath("//*[@id='input_6_6_3']")).sendKeys("sachin");;

System.out.println("title" );
driver.findElement(By.xpath("//*[@id='input_6_6_6']")).sendKeys("sachin");

driver.findElement(By.id("input_6_4")).sendKeys("Restarant");
	
System.out.println("title" );
Select drpCountry = new Select(driver.findElement(By.id("input_6_7")));
drpCountry.selectByVisibleText("Andorra");

driver.findElement(By.id("input_6_8")).sendKeys("7845451212");
driver.findElement(By.id("input_6_2")).sendKeys("7845451212");

driver.findElement(By.xpath("//div[@class='gform_footer top_label']//input[@id='gform_submit_button_6' and @type='submit' and @value='Submit']")).click();
*/


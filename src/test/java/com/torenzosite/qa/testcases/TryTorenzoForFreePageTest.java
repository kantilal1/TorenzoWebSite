package com.torenzosite.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.HardwarePage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.TryTorenzoForFreePage;

public class TryTorenzoForFreePageTest extends TestBase {
	
	HomePage homePage;
	TryTorenzoForFreePage tryTorenzoForFreePage;
	
	public TryTorenzoForFreePageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();	
		tryTorenzoForFreePage = new TryTorenzoForFreePage();
		
	} 
	@Test(priority=21)
	public void verifyHomePageTitle(){
			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 
		
	}
	
	@Test(priority=22)
	public void clickOnTryTorenzoForFree() throws IOException, InterruptedException{
	
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		/*String  title =	driver.findElement(By.xpath("//*[text()='Try Torenzo for FREE today']")).getText();
		System.out.println("title" +title);*/
		Thread.sleep(4000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 
		//tryTorenzoForFreePage.passFirstName
		
		/*
		driver.findElement(By.id("First name")).sendKeys("hello");	
		System.out.println("Hello2");
		*/		
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


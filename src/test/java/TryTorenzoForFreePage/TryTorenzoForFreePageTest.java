package TryTorenzoForFreePage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();	
		tryTorenzoForFreePage = new TryTorenzoForFreePage();
		
	} 
	@Test(priority=0)
	public void verifyHomePageTitle(){
			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		AssertJUnit.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 
		
	}
	
	@Test(priority=1)
	public void clickOnTryTorenzoForFree() throws IOException, InterruptedException{
	
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		/*String  title =	driver.findElement(By.xpath("//*[text()='Try Torenzo for FREE today']")).getText();
		System.out.println("title" +title);*/
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		AssertJUnit.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 
		/*
		driver.findElement(By.id("First name")).sendKeys("hello");	
		System.out.println("Hello2");
		*/		
		driver.findElement(By.xpath("//*[@id='input_6_6_3']")).sendKeys("sachin");;
		System.out.println("title" );
		driver.findElement(By.xpath("//*[@id='input_6_6_6']")).sendKeys("sachin");;
			
		System.out.println("title" );
		String  title =	driver.findElement(By.xpath("//input[contains(text(),'First Name')]")).getText();
		System.out.println("title" +title);
		WebElement	element =driver.findElement(By.xpath("//input[contains(text(),'First Name')]"));
		element.click();
		element.sendKeys("hello");
		
		
	}
	
}

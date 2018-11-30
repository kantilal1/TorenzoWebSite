package com.torenzosite.qa.testcases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.TryTorenzoForFreePage;

public class RebiqueCCTest extends TestBase {

	public RebiqueCCTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@BeforeTest
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		
	} 

	@Test
	public void creaditProcess() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebElement ClickOnCC = driver.findElement(By.xpath("//a[@href='/credit-card']"));
		//ClickOnCC.click();
		System.out.println("click on CC from header");
		//driver.findElement(By.xpath("//span[@class='Select-arrow-zone']")).click();
		
		
		//driver.findElement(By.xpath("//span[@class='Select-arrow-zone']")).click();
		//driver.findElement(By.id("react-select-2--option-149")).click();   //==>mumbai code is 149 get selected
		
		
		 
		Select oSelect = new Select(driver.findElement(By.xpath("//span[@class='ui-dropdown-trigger-icon ui-clickable fa fa-fw fa-caret-down']")));
		oSelect.selectByVisibleText("Sleeper (SL)");

		
		//Select oSelect = new Select(driver.findElement(By.id("react-select-2--list")));
		
		//Select oSelect = new Select(driver.findElement(By.xpath("//span[@class='Select-arrow-zone']")));
		//oSelect.selectByVisibleText("Agra");
		
		
		/*Thread.sleep(3000);
	String	str = driver.findElement(By.xpath("//label[text()='Enter City']")).getText();
	System.out.println("str==>" +str);
	
	driver.findElement(By.xpath("//label[text()='Enter City']")).click();
	System.out.println("click" +str);
	

	System.out.println("Done");
	Thread.sleep(5000);
	
	
	//driver.findElement(By.xpath("//span[@class='Select-arrow']")).click();
	Thread.sleep(1000);
	List<WebElement> city =driver.findElements(By.xpath("//div[@class='Select-option']"));
	
	System.out.println("CIty listed=>" +city.size());
	System.out.println("Done");
	
	driver.findElement(By.xpath("//span[text()='Agra']")).click();
	System.out.println("Done");
	driver.findElement(By.xpath("//*[@id='react-select-3--option-1']")).click();
	System.out.println("Done1");
	driver.findElement(By.xpath("//label[text()='Enter City']")).sendKeys("Mumbai");
	System.out.println("Send==>" +str);
		driver.findElement(By.xpath("//span[@class='Select-arrow-zone']")).click();
		System.out.println("click on CC from header");
		//span[@class='Select-arrow']
		
		Select drpCity = new Select(driver.findElement(By.xpath("//label[text()='Enter City']")));
		drpCity.selectByVisibleText("Mumbai");
		
		
		
		
	String	str = driver.findElement(By.xpath("//label[text()='Enter City']")).getText();
	driver.findElement(By.xpath("//span[@class='Select-arrow']")).click();
	//driver.findElement(By.xpath("//span[@class='Select-arrow']")).click();
	
	//driver.findElement(By.xpath("//div[@class='Select-placeholder']")).sendKeys("Mumbai");
	
	<div class="Select-placeholder"/>
	driver.findElement(By.xpath("//span[@class='Select-arrow']")).sendKeys("Mumbai");
	System.out.println("str==>" +str);
*/		

		
	}
}

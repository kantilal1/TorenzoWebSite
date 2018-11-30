package com.torenzosite.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.torenzosite.qa.base.TestBase;

public class HardwarePage extends TestBase {


	@FindBy(id= "Try Torenzo For Free")
	WebElement tryTorenzoForFree;
    	
	public HardwarePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHardwarePageTitle(){
		
		return driver.getTitle();
	}
	
	public void clickOnTryTorenzoForFree(){
		
		tryTorenzoForFree.click();
	}

}

package com.torenzosite.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.torenzosite.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public TestUtil() throws IOException, InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT= 40;
	public static long IMPLICIT_WAIT = 40;
	public static String title = "";
	
	public static String screenshotName="";
	
	public static void scrollUpByPixel(int pixel){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 'pixel')");
	
	}
	
	public static void scrollUpAtEndOFPage(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
	}
	
	public static void scrollUpHorizontalORVIsibilityOFElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	
	}
	
	

}

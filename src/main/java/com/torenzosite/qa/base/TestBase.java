package com.torenzosite.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.torenzosite.qa.util.TestUtil;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException{
		try{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("E:\\SeleniumWorkSpace\\torenzowebsite\\src\\main\\java\\com\\torenzosite\\qa\\config\\config.properties");
		
		prop.load(fis);
		}catch(FileNotFoundException e){
			e.printStackTrace();		
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
		
	
	public static void initialization() throws InterruptedException{
		
		String broweserName = prop.getProperty("browser");
		if(broweserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "E:\\SeleniumWorkSpace\\chromedriver_win32-1\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		else if (broweserName.equals("FF")){

			System.setProperty("webdriver.gecko.driver", "E:\\SeleniumWorkSpace\\geckodriver.exe");		
			
			driver = new FirefoxDriver();
			
		
/*			
			System.setProperty("webdriver.gecko.driver", "/Users/username/Downloads/geckodriver");
			WebDriver driver = new FirefoxDriver();*/
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
        driver.get(prop.getProperty("torenzoURL"));
		//driver.get(prop.getProperty("url"));
	

		
	}



}

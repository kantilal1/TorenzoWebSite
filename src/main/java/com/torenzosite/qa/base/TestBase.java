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
	
	public TestBase() throws IOException, InterruptedException{
		try{
			prop = new Properties();
			Thread.sleep(5000);
			System.out.println("File 1");
			FileInputStream fis = new FileInputStream("E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\src\\main\\java\\com\\torenzosite\\qa\\config\\config.properties");
			System.out.println("File 2");
			Thread.sleep(5000);
		prop.load(fis);
		}catch(FileNotFoundException e){
			e.printStackTrace();		
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
			
	public static void initialization() throws InterruptedException{
		
		String broweserName = prop.getProperty("browser");
		if(broweserName.equals("FF")){
			
			System.setProperty("webdriver.chrome.driver", "E:\\SeleniumWorkSpace\\torenzowebsite\\FileDriver\\geckodriver.exe");
			
			driver = new ChromeDriver();
		}
		else if (broweserName.equals("chrome")){

			System.setProperty("webdriver.gecko.driver", "E:\\SeleniumWorkSpace\\torenzowebsite\\FileDriver\\chromedriver.exe");		
			System.setProperty("webdriver.firefox.marionette", "false");
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
        driver.get(prop.getProperty("torenzoURL"));
	//	driver.get(prop.getProperty("url1"));
	
	}



}

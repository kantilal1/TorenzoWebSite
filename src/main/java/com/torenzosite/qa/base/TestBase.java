package com.torenzosite.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.torenzosite.qa.util.TestUtil;

import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static AndroidDriver driver1;
	
	public TestBase() throws IOException, InterruptedException{
		try{
			prop = new Properties();
		
			FileInputStream fis = new FileInputStream(".\\src\\main\\java\\com\\torenzosite\\qa\\config\\config.properties");
		prop.load(fis);
		}catch(FileNotFoundException e){
			e.printStackTrace();		
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
		
	public static void initialization() throws InterruptedException, MalformedURLException{
		
		String broweserName = prop.getProperty("browser");
		if(broweserName.equals("FF")){
			
		   WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		
		}
		else if (broweserName.equals("chrome")){

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}	
		
		else if (broweserName.equals("IE")){
			WebDriverManager.chromedriver().setup();
			driver = new InternetExplorerDriver();		
		}
		
		else if (broweserName.equals("mobileChrome")){

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "Honor");
			caps.setCapability("udid", "192.168.157.101:5555");
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "6.0");
			caps.setCapability("browserName", "Chrome");					
			URL url = new URL("http://0.0.0.0:4723/wd/hub");
		 driver = new AndroidDriver(url, caps);
			
		}
		
		/*else if (broweserName.equals("grid")){
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setBrowserName("chrome");
			caps.setPlatform(Platform.WIN10);
			ChromeOptions options = new ChromeOptions();
			options.merge(caps);			
			String hubUrl = "http://192.168.1.123:4444/wd/hub";			
			WebDriver driver = new RemoteWebDriver(new URL(hubUrl), options);
						
		}*/
		if (broweserName.equals("mobileChrome")){
			
			System.out.println("Testing WebSite on Anddroid Emulator");
		}
		else{
			
			driver.manage().window().maximize();	
			
		}
			
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);		
        driver.get(prop.getProperty("torenzoURL"));
       // 	driver.get(prop.getProperty("url1"));
	}
	
		
	}
	
	
	
	



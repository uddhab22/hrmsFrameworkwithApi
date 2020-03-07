package com.hmrs.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.hmrs.utils.ConfigsReader;
import com.hmrs.utils.Constants;

public class BaseClass {
	public static WebDriver driver;
	
	
		
	public static void setUp() {
		ConfigsReader.readProperties(Constants.CREDENTIAL_FILEPATH);
		
				
		switch(ConfigsReader.getProperty("browser").toLowerCase()) {
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.Chrome_driver_Path);
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.Gecko_driver_Path);
			driver = new FirefoxDriver();
			break;
			
		default:
			System.err.println("Browser not supported");	
		}
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_Time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_LOAD_Time, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.get(ConfigsReader.getProperty("url"));
		
	}
	public static void tearDown() {
		if(driver!=null) {
			driver.quit();
			
		}
	}
	

}

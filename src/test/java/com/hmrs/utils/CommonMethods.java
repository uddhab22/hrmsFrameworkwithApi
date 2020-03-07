package com.hmrs.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hmrs.testbase.PageInitiliazer;

// command + o to see all the list of method in this class.

public class CommonMethods extends PageInitiliazer{

	/**
	 * Method to open browse
	 * and navigate to the URL
	 * @param browser
	 * @param URL
	 */ 

	public static void  acceptAlert() {	
		try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
		}
		catch (NoAlertPresentException e) {
				System.out.println("Alert not present");
		}
	}
	
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}
		catch (NoAlertPresentException e) {
			System.out.println("Alert not present");	
		}
	}
	public static String getAlertText() {
		String alertText=null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
			alert.accept();
		}
		catch (NoAlertPresentException e) {
			System.out.println("Alert not present");
		}
		return alertText;
	}
	
	public static void switchToFrame(String nameorID) {
		try {
			driver.switchTo().frame(nameorID);
		}
		catch(NoSuchFrameException e) {
			System.out.println("No frame is present");
		}
	}
	
	
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		}
		catch(NoSuchFrameException e) {
			System.out.println("No frame is present");
		}
	}
	
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		}
		catch(NoSuchFrameException e) {
			System.out.println("No frame is present");
		}
	}
	
	/**
	 * This method will click on the element using JS Executor
	 * @param ele
	 */
	public static void jsClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele);
	}
	
	/**
	 * Method to scroll until specific element
	 * @param ele
	 */
	public static void scrollInto(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	
	/**
	 *  Method to Scroll Down
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+pixel+")");
	}
	
	/**
	 * Method to Scroll Up	
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-"+pixel+")");
	}
		
	/**
	 * method to take ScreenShot
	 * 
	 * you can add folder before file name as well
	 * like folderName/fileName
	 * 
	 * @param fileName
	 */
	public static byte[] takeScreenShot(String fileName) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
			String timestamp = sdf.format(date.getTime());
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			byte[] picture = ts.getScreenshotAs(OutputType.BYTES);
		    
	            String ScreenShotfilePath = Constants.SCREENSHOTS_FILEPATH+fileName+timestamp+".png";
	            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            try {
	            FileUtils.copyFile(screen, new File(ScreenShotfilePath));
	        } catch (Exception e) {
	        	System.out.println(e.getMessage());
	        }
		    return picture;
	}
	
	/**
	 * This method will enter text
	 * @param element
	 * @param value
	 */
	public static void sendText(WebElement element, String value) {
		waitforVisibility(element);
		element.clear();
		element.sendKeys(value);
	}
	
	/**
	 * CREATE AN object of WebDriverWiat
	 * @return webDriverWait
	 */
	
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_LOAD_Time);
		
		return wait;
	}
	
	/**
	 * This method will wait until element becomes clickable
	 * 
	 * @param element
	 */
	public static void waitforClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	/**
	 * This method will wait until element becomes visible
	 * 
	 * @param element
	 */
	public static void waitforVisibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * This method will wait until element becomes invisible
	 * 
	 * @param element
	 */
	public static void waitforINVisibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.invisibilityOf(element));
	}
	
	/**
	 * method to click on the element
	 * @param element
	 */
	public static void click(WebElement element) {
		waitforClickability(element);
		element.click();
	}
	/**
	 * This method will select value from DD
	 * 
	 * @param element
	 * @param visibleText
	 */
	
	
	public static void selectDdValue(WebElement element, String visibleText) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();

		boolean isFound = false;
		for (WebElement option : options) {
			if (option.getText().equals(visibleText)) {
				select.selectByVisibleText(visibleText);
				isFound = true;
				break;
			}
		}

		if (!isFound) {
			System.out.println("Value " + visibleText + "was not found in the dropdown");
		}
	}

	/**
	 * This method will select value from dd
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDdValue(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isFound = false;
		if (options.size() > index) {
			select.selectByIndex(index);
			isFound = true;
		}

		if (!isFound) {
			System.out.println("Value with index " + index + "was not selected");
		}
	}

	/**
	 * This method will click on the radio based on the text
	 * 
	 * @param elements
	 * @param radioText
	 */
	public static void clickRadio(List<WebElement> elements, String radioText) {

		for (WebElement el : elements) {

			if (el.getText().equals(radioText)) {
				el.click();
				break;
			}
		}
	}
	static String jsonFile;
	public static String readJson(String filename) {
		try {
			jsonFile = new String(Files.readAllBytes(Paths.get(filename)));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return jsonFile;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}

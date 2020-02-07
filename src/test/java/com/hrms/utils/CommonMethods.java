package com.hrms.utils;
//in common methods we have any functions to perform on the browser
//XL utility- to open close and read and write excel
import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbase.BaseClass;
import com.hrms.testbase.PageInitializer;

//command+o--> for mac to see all methods within the class
//ctrl+o--> for windows
public class CommonMethods extends PageInitializer{//was extends BaseClass

//	public static WebDriver driver;

	/**
	 * Use this method in need of opening browser and target url
	 * 
	 * @param browser The desired browser
	 * @param url     The desired url
	 */
	public static void setUp(String browser, String url) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else {
			System.err.println("Browser not supported");
		}
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}

	/**
	 * This method will accept the alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void acceptAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}

	/**
	 * This methods will dismiss the alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void dismissAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not prresent");
		}
	}

	/**
	 * This method will get a text from the alert
	 * 
	 * @return text of the alert
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static String getAlertText() {

		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
			return null;
		}
	}

	/**
	 * This method with switch to the frame
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {

		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * This method with switch to the frame
	 * 
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * This method with switch to the frame
	 * 
	 * @param index
	 */
	public static void switchToFrame(int index) {

		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * This method will click on the element using JSExecutor
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * This method will scroll until until specified element
	 * @param element
	 */
	public static void scrollIntoElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * This method will scroll page down
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * This method will scroll page up
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -" + pixel + ")");
	}
	
	
	
	
	/**
	 * This method will take a screenshot
	 * 
	 * @param fileName
	 */
	public static byte[] takeScreenshot(String fileName) {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		//create picture in a form of bytes --> we need it to attach it to our scenario
		byte[] picture=ts.getScreenshotAs(OutputType.BYTES);
		
		//taking a picture in a form of file and store it in the specified location
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MMdd_HHmmss");
		String timeStamp = sdf.format(date.getTime());
	
		File file=ts.getScreenshotAs(OutputType.FILE);
		String scrshotFile=Constants.SCREENSHOTS_FILEPATH+fileName+timeStamp+".png";  //stores screenshot in specific location
		
		try {
			FileUtils.copyFile(file, new File(scrshotFile));
		} catch (IOException e) {
			System.out.println("Cannot take a screenshot");
		}
		
		return picture;
	}
	/////
	
	/**
     * This method will enter text
     * 
     * @param element
     * @param value
     */
    public static void sendText(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
    /**
     * This method will create an Object of WebDriverWait
     * 
     * @return WebDriverWait
     */
    public static WebDriverWait getWaitObject() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_LOAD_TIME);
        return wait;
    }
    /**
     * This method will wait until element becomes clickable
     * 
     * @param element
     */
    public static void waitForClickability(WebElement element) {
        getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
    }
    /**
     * This method will wait until element becomes visible
     * 
     * @param element
     */
    public static void waitForVisibility(WebElement element) {
        getWaitObject().until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * This method will wait until element becomes invisible
     * 
     * @param element
     */
    public static void waitForInvisibility(WebElement element) {
        getWaitObject().until(ExpectedConditions.invisibilityOf(element));
    }
    /**
     * This method will click on the element
     * @param element
     */
    public static void click(WebElement element) {
    	waitForClickability(element);
    	element.click();
    }
    
    /**
     * This method will select value from DropDown
     * @param element
     * @param visibleText
     */                           //Overloaded Method- same names diff parameters in same class                                           
    public static void selectDdValue(WebElement element, String visibleText) {//visibleText->txt that you wanna pass
    	Select select= new Select(element);
    	List<WebElement> options=select.getOptions();  //get all values from dropdrown
    	
    	boolean isFound=false;  //for this if block to be executed the value must be true
    	for (WebElement option:options) { //looping
    		if(option.getText().equals(visibleText)) { //get text that currently there then match to text we are passing. If matching only then select
    			select.selectByVisibleText(visibleText); //as soon as u found the txt u looking for we dont wanna loop nemore
    			isFound=true; //reassign value. As soon as found value change to true.
    			break;
    		}
    	}
    	
    	if (!isFound) {//if not able to select value.if value isnot true Value of isFound will be kept to false. //!true=false    !false=true
    		System.out.println("Value "+ visibleText+ "was not found in the dropdown");
    	}
    }
    
    
	/**
	 * This method will select value from dropdown
	 * @param element
	 * @param index
	 */						//method overloading
    public static void selectDdValue(WebElement element, int index) {//
    	Select select = new Select(element);
    	List<WebElement> options = select.getOptions();
    	boolean isFound = false;
    	if(options.size() > index) { //index should be less the number of options or # options greater than the index
    		select.selectByIndex(index);
    		isFound=true;
    	}
    	if (!isFound) {
    		System.out.println("Value with index "+ index + "was not selected");
    	}
    	
    }
    
    /**
     * This method will click on the radio based on the text
     * @param elements
     * @param radioText
     */
	public static void clickRadio(List<WebElement> elements, String radioText) {//radioText=expected text

		for (WebElement el : elements) {
		//	System.out.println("TEXT FROM RADIO BUTTON -----------"+el.getText());
			
			if (el.getText().equals(radioText)) {// retrieve text from radiobutton if txt matching click it
				el.click(); //in order to click the above if condition has to pass
				break;
			}
		}

	}
}
	

//	public static WebDriver setUp(String browser){
//		
//		if(browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "drivers/chromeDriver");
//			driver=new ChromeDriver();
//		
//		}else if(browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
//			driver=new FirefoxDriver();
//		}
//		
//		return driver;
//	}


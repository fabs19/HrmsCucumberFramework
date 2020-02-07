package com.hrms.testbase;
	//in base class initialization happens
	//in this class we set up and tear down
	//in this class we have our WebDriver and have methods to open this webdriver & navigate to the page and close WebDriver
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;


public class BaseClass {

    public static WebDriver driver; //initial value null
    
    public static void setUp() { //method
    	
    	ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);//iitialize file load entire data
    	
        switch (ConfigsReader.getProperty("browser").toLowerCase()) {//calling class->class will read property from file that get initialized (which property->browser     
        
        case "chrome":
            System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
            driver = new ChromeDriver();  //this line initializes driver
            break;
        case "firefox":
            System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
            driver = new FirefoxDriver();
            break;
        default:
            System.err.println("Browser is not supported");
        }
        driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_LOAD_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
     
        driver.get(ConfigsReader.getProperty("url"));       //getting ur url
    }
    
   
    public static void tearDown() {  //method to close browser
        if (driver != null) {
            driver.quit();
        }
    }
}

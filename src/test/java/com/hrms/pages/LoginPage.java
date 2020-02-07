package com.hrms.pages;
//Repository of webelements on the login page
//using driver to find element and storing variables in WebElement
//
import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import com.hrms.testbase.BaseClass;

public class LoginPage extends BaseClass{ // implementing POM w/o pagefactory and w/o @findby. Here using driver.findElement 

	public WebElement username=driver.findElement(By.id("txtUsername"));
	public WebElement password=driver.findElement(By.id("txtPassword"));
	public WebElement loginBtn=driver.findElement(By.id("btnLogin"));
//	public WebElement errMsg=driver.findElement(By.id("spanMessage"));
//	public WebElement logo=driver.findElement(By.xpath("//div[@id='divLogo']"));
	
	
	
	
}

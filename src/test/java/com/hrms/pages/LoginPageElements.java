package com.hrms.pages;
//implementing POM with pagefactory and with @findby.


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class LoginPageElements extends CommonMethods{  //storing all webelements in login page
	
	@FindBy(xpath="//div[@id='divLogo']")
	public WebElement logo; //make this public bc testcase loginpageTest and LoginPageElements in diffrent packages
	
	@FindBy(id="logInPanelHeading")
	public WebElement LoginLabel;
	
	@FindBy(name="txtUsername") //element stored as instance variable
	public WebElement username;
	
	@FindBy(css="input#txtPassword")
	public WebElement password;
	
	@FindBy(css="input[name='Submit']")  
	public WebElement loginBtn;
	
	
	@FindBy(id="spanMessage")
	public WebElement errorMsg;
	
	//once we store all elements we need to have something that will be initializing those elements---> this will be PageFactory
	//PageFactory-> class that comes from Selenium that support Selenium, has diff methods to initialize Page Object: 
	//.initElement();
	
	public LoginPageElements() {  //constructor 
		PageFactory.initElements(BaseClass.driver, this); //calling driver in static way instead of extending class to BaseClass
	}// page factory initializing all webelements
	
	
	
	//can store also actions that can perform on these elements
	public void login(String uid,String pwd) {    //login method
		sendText(username, uid);
		sendText(password, pwd);
		click(loginBtn);
	}
	
}

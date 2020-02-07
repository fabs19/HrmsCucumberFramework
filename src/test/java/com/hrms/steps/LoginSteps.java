package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class LoginSteps extends CommonMethods{
	
//	LoginPageElements login; //global to initialize once and give access to other methods. Initial value is null

	@Given("I open browser and navigated to the HRMS")//("parameter")
	public void i_open_browser_and_navigated_to_the_HRMS() {
	    setUp(); //setUp() inherited from grandpa BaseClass so just use method name instead of BaseClass.setUp();
	}

	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
	//	login=new LoginPageElements(); //create obj of class bc in diff package to access usename and password webelements
	    sendText(login.username, "Admin"); //method to enter text from CommonMethods Class. Use object variable to access all variables and methods
	    sendText(login.password, "Syntax@123");
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
	click(login.loginBtn); //to access login variable here had to make Obj LoginPageElements() login; ->GLOBAL
	  
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
	//	System.out.println("I am logged in");     
		Assert.assertTrue(false);    //check this on github false-failed on purpose but mine not failing
		
	}
	
	@When("I enter valid username and invalid password")
	public void i_enter_valid_username_and_invalid_password() {
	//	login=new LoginPageElements();   //create obj of class bc in diff package to access usename and password webelements
		sendText(login.username, "Admin");
	    sendText(login.password, "66jhhj");
	}

	@Then("I see error message")
	public void i_see_error_message() {
	  boolean error= login.errorMsg.isDisplayed();
	  Assert.assertTrue("Error message is not displayed", error); //"if not true message", error->what should be true
	 
	}
	
	@Then("I close browser")
	public void i_close_browser() {
	  tearDown();  //teardown inerited from grandpa Baseclass just use method name instead of BaseClass.tearDown();
	}




}
















/*can reuse implementation inside steps but feature steps must match
 * steps definitions are not ordered what defines ur order of ececution is ur feature file
 * step definitions not attached to any particular scenario/feature
 * methods executed based on annotated parameter, based on step defined in feature file
 */

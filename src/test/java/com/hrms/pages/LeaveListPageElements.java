package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class LeaveListPageElements {//dash

	@FindBy(css="a.toggle.tiptip")
	public WebElement leaveListLbl;
	
	public LeaveListPageElements() {   //Constructor
		PageFactory.initElements(BaseClass.driver, this); //pagefactory initializes webelements 
	}
}

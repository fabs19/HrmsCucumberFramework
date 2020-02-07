package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods{  //using @findBy and pagefactory

	@FindBy(linkText="Leave")
	public WebElement leaveLnk;
	
	
	@FindBy(linkText = "Leave List")
	public WebElement leaveList;
	
	
	@FindBy(linkText="PIM")  //add emp
	public WebElement pim;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement addEmp;  //add emp
	
	@FindBy(id = "welcome")
	public WebElement welcomeLnk;

	
	
	public DashboardPageElements() {      //constructor  
		PageFactory.initElements(BaseClass.driver, this); //pagefactory initializes webelements
	}
	
	
	//functions related to elements specific to this page:
	//create for commonly used
	public void navigateToLeaveList() {
		jsClick(leaveLnk);
		jsClick(leaveList);
	}
	
	
	public void navigateToAddEmployee() {
		jsClick(pim);
		jsClick(addEmp);
	}
	
	
	
	
	
}

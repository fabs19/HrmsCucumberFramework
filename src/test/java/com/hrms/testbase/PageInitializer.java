package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;

public class PageInitializer extends BaseClass {
	
	protected static LoginPageElements login;
	protected static DashboardPageElements dashboard;
	protected static AddEmployeePageElements addEmp;
	protected static PersonalDetailsPageElements pdetails;
	
	
	
	public static void initializeAllPage() { //method need to be called in order for code to get executed
		
		 login=new LoginPageElements();   //object of loginpageElements
		 dashboard=new DashboardPageElements();
		 addEmp=new AddEmployeePageElements();
		 pdetails=new PersonalDetailsPageElements();
		
		//initialize my pages as soon as i open my browser-> place in hooks
		/*
		 * Default: The access level of a default modifier is only within the package. 
		 * It cannot be accessed from outside the package. If you do not specify any 
		 * access level, it will be the default.
		 * 
		   Protected: The access level of a protected modifier is within the same package and 
			diff package thru inheritance. 
		 */
	}
}//

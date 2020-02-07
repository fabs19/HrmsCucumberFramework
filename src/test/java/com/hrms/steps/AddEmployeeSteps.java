package com.hrms.steps;


import java.util.List;
import java.util.Map;

import org.junit.Assert;  //////

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;


public class AddEmployeeSteps extends CommonMethods{
	
	String empId;
	
//	LoginPageElements login; //global
//	AddEmployeePageElements addEmp;
//	String empId;
//	DashboardPageElements dashboard;
//	PersonalDetailsPageElements pdetails;

	@Given("I am logged into HRMS")   //L Adding all page initialization to Given step in Background bc Given step always gets executed
	public void i_am_logged_into_HRMS() {//L
	   // LoginPageElements login=new LoginPageElements(); //create object to access login method
	//	login=new LoginPageElements();//initializing all variables that refering to the page i need
	//	dashboard=new DashboardPageElements();
	//	addEmp=new AddEmployeePageElements();
	//	pdetails=new PersonalDetailsPageElements();
		
	    login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password")); //using Configs to read configuration properties file
	}

	@Given("I navigated to Add Employee Page")
	public void i_navigated_to_Add_Employee_Page() {
	//	DashboardPageElements dashboard=new DashboardPageElements();
		dashboard.navigateToAddEmployee();
		
	   	}

	@When("I add {string}, {string} and {string}")
	public void i_add_and_(String fName, String mName, String lName) {    ////////
	//  addEmp=new AddEmployeePageElements();
	   sendText(addEmp.firstName, fName);
	   sendText(addEmp.middleName, mName);
	   sendText(addEmp.lastName, lName);
	   empId=addEmp.empId.getText();          // actual empId is from addEmployeePageElements
	} 

	@When("I click Save")
	public void i_click_Save() {
		click(addEmp.saveBtn);
	    
	}

	@Then("I see Employee has been successfully added")
	public void i_see_Employee_has_been_successfully_added() {
//	    PersonalDetailsPageElements pdetails=new PersonalDetailsPageElements();
	    Assert.assertEquals("Employee is Not being added", pdetails.empId.getText(), empId );
	}
	
	@Then("I see Employee with {string}, {string} and {string} is displayed")
	public void i_see_Employee_with_and_is_displayed(String string, String string2, String string3) {
	    
	}
	
	//RETRIEVE DATA
	@When("I enter employee details")//!!!!!!!!!!!BEST CHOICE working w/DATATABLE even if one row--> RETRIEVE DATA AS A LIST OF MAPS!!!!!!!!!!!!!!!!
	public void i_enter_employee_details(DataTable empDetails) { //dataTable->name   size=1
//		addEmp=new AddEmployeePageElements(); //initializing
		List<Map<String, String>> empDetailList = empDetails.asMaps();	//taking records of that data table,retrieve it as a collection of maps
	
			for(Map<String, String> map:empDetailList) {  //Advanced loop-looping thru all map in collection
				sendText(addEmp.firstName, map.get("FirstName"));//->map.get("DataTableHeader")	->key																						//System.out.println(map.get("FirstName")); //access to values inside map with variable 
				sendText(addEmp.middleName, map.get("MiddleName"));																															//System.out.println(map.get("MiddleName"));
				sendText(addEmp.lastName, map.get("LastName"));																															   //System.out.println(map.get("LastName"));
				
			}
	    }
			
	@When("I click on Edit")
	public void clickOnEdit_SaveButton() {  //can give any name you want to method name spaces must be _
		click(pdetails.edit_saveBtn);
	}
	
	//Retreiving data from dataTable
	@Then("I am able to modify Employee Details")
	public void modifyEmployeeDetails(DataTable modifyEmpDetail) throws InterruptedException { //giving dataTable a name
		List<Map<String, String>> modifyList = modifyEmpDetail.asMaps();  //size=2
			
		for(Map<String,String> map: modifyList) {  //variableName:CollectionName
			//click on edit
			click(pdetails.edit_saveBtn);
			
			//passing new details to the employee
			sendText(pdetails.licenNo, map.get("DriverLicense")); // value-> from map. key comes from DataTable header
			sendText(pdetails.licExpDate, map.get("ExpirationDate"));
			sendText(pdetails.SSN, map.get("SSN"));
			sendText(pdetails.SIN, map.get("SIN"));
			clickRadio(pdetails.genderLabels, map.get("Gender"));			//clicking on gender radiobutton not working
			Thread.sleep(5000); //pause to check if clicking gender
			
			selectDdValue(pdetails.maritalStatus, map.get("MaritalStatus")); //marital status dropdown
			selectDdValue(pdetails.nationality, map.get("Nationality"));
			sendText(pdetails.DOB, map.get("DOB"));
			
			//click on save
			click(pdetails.edit_saveBtn);
		}
	}
			
}//		
			
			
			
			
			
			

		
		
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	   // throw new cucumber.api.PendingException();
	
	
	
	
	
	


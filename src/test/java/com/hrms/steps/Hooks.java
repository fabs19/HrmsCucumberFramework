package com.hrms.steps;

import com.hrms.testbase.PageInitializer;
import com.hrms.utils.CommonMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends CommonMethods{//Scenario is an instance returns instance of class. 
	//in hook opening and navigating to browser
	@Before
	public void start(Scenario scenario) {
		System.out.println("Starting scenario"+scenario.getName());
		setUp();  //set up driver
		PageInitializer.initializeAllPage(); //initialize my pages as soon as i open my browser. calling pageInitialization method
		//the above line asel doesnt have PageInitializer part just the method name
	}
	
	@After
	public void end(Scenario scenario) {//scenario here holds info: whether it passed/failed
		System.out.println("Ending scenario "+scenario.getName());
		if(scenario.isFailed()) {
			byte[] picture=takeScreenshot("/failed/"+scenario.getName());//take screenshot put in folder failed and attach scenario
			scenario.embed(picture, "image/png"); //attach screenshot to scenario to see it in report
		}else {
			byte[] picture=takeScreenshot("/passed/"+scenario.getName());
			scenario.embed(picture, "image/png"); //attach screenshot to scenario to see it in report
		}
		
		tearDown();
	}

}

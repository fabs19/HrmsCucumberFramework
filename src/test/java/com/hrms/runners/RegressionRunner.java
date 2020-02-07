package com.hrms.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) //->what we are running
@CucumberOptions(//specify configuration settings for our test case
		features="src/test/resources/features"  //which features would u like to run path
		,glue="com/hrms/steps"   //specify path to step definition package(implementation code) wherescode glued to that feature go scan thru entire package 
		,dryRun=false		//true-->tells which steps not implemented. false--> actually execute test case
		,plugin= {"pretty", "html:target/html/cucumber-default-report"}  	//pretty-prints out report on our console. html-> reports
		,monochrome=true   //to see more readable format
		,tags= {"@regression"} //which scenario with what @cucumber tag you want to execute
		) 

public class RegressionRunner {

}//

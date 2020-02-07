package com.hrms.runners;  //configurations & running all 

import org.junit.runner.RunWith;  //junit tool used to execute test cases

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) //->what we are running
@CucumberOptions(//specify configuration settings for our test case
		features="src/test/resources/features"  //which features would u like to run path
		,glue="com/hrms/steps"   //specify path to step definition package(implementation code) wherescode glued to that feature go scan thru entire package 
		,dryRun=false		//true-->tells which steps not implemented. false--> actually execute test case
		,plugin= {"pretty", "html:target/html/cucumber-default-report", "json:target/cucumber.json", "rerun:target/failed.txt"}  	//pretty-prints out report on our console. html-> reports    json-cucumber maven report   
		,monochrome=true   //to see more readable format
		,tags= {"@smoke"} //which scenario with what @cucumber tag you want to execute
		) 

//rereun plugin-creates a txt file with name failed inside target folder.This txt file will keep the name of the failed scenarios
public class SmokeRunner { //configuration class

}




























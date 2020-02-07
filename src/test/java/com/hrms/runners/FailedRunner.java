package com.hrms.runners;
//this runner points out to the failed test cases

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) //->what we are running
@CucumberOptions(//specify configuration settings for our test case
		features="@target/failed.txt"
		,glue="com/hrms/steps"   //name of package with step definitions
		,monochrome=true
		,plugin="pretty"
		)

public class FailedRunner {

}

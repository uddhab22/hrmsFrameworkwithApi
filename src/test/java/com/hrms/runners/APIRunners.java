package com.hrms.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/resources/Features/"
		,glue = "com/hrms/API/steps/practise"
		,dryRun = false
		,plugin = {"pretty","html:target/html/cucumber-default-reports",
				"json:target/cucumber.json","rerun:target/failed.txt"}
		,monochrome = true
		,tags = "@APIEndtoEnd"
		
		)

public class APIRunners {

}

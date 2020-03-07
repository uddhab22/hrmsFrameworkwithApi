package com.hrms.steps;

import com.hmrs.utils.CommonMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends CommonMethods{
	@Before
	public void start(Scenario scenario) {
		System.out.println("Test Starting: "+scenario.getName());
		setUp();
		initializeAllPage();
	}
	
	@After
	public void end(Scenario scenario) {
		System.out.println("Test Ending: "+scenario.getName());
		System.out.println(scenario.getStatus());
		
		if(scenario.isFailed()) {
			byte[] picture = takeScreenShot("/failed/"+scenario.getName());
			scenario.embed(picture, "image/png");
		}
		else {
			byte[] picture = takeScreenShot("/passed/"+scenario.getName());
			scenario.embed(picture, "image/png");
			
		}
		tearDown();
		 
		
	}
	
	

}

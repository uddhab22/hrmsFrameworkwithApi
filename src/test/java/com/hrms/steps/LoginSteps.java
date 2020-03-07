package com.hrms.steps;

import org.junit.Assert;

import com.hmrs.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends CommonMethods{
	
	@Given("I open browser and navigate to HRMS")
	public void i_open_browser_and_navigate_to_HRMS() {
	   //setUp();
	}

	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
		sendText(login.username, "Admin");
		sendText(login.password, "Syntax@123");
	}

	@When("I clicked on login Button")
	public void i_clicked_on_login_Button() {
	   click(login.loginBtn);
	}

	@Then("I succefully logged in")
	public void i_succefully_logged_in() {
		Assert.assertTrue(dashboard.welcome.isDisplayed());
		
	    
	}
	
	@When("I enter valid username and invalid password")
	public void i_enter_valid_username_and_invalid_password() {
	 
		sendText(login.username, "Admin");
	    sendText(login.password, "66jhhj");
	}

	@Then("I see error message")
	public void i_see_error_message() {
	   boolean error=login.erroMsg.isDisplayed();
	   Assert.assertTrue("Error message is not displayed", error);
	}
	
	@Then("I close browser")
	public void i_close_browser() {
	    //tearDown();
	}
}
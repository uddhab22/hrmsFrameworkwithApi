package com.hrms.steps;

import org.junit.Assert;

import com.hmrs.pages.AddEmployee;
import com.hmrs.pages.DashboardPageElements;
import com.hmrs.pages.loginPagesElements;
import com.hmrs.utils.CommonMethods;
import com.hmrs.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmployeeSteps extends CommonMethods{
	AddEmployee emp = new AddEmployee();
	
	
	
	@Given("I am logged in to HRMS")
	public void i_am_logged_in_to_HRMS() {
	   loginPagesElements login = new loginPagesElements();
	   login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}
	
	@When("I navigate to add employee")
	public void i_navigate_to_add_employee() {
		DashboardPageElements dash = new DashboardPageElements();
		dash.navigateToAddEmployee();
		
	}

	@When("I added {string}, middle and {string}")
	public void i_added_middle_and(String string, String string2) {
	    sendText(emp.firstName, string);
	    sendText(emp.lastName, string2);
	}

	@When("I clicked save")
	public void i_clicked_save() {
	    click(emp.saveBtn);
	}

	@Then("Employee added succesfully")
	public void employee_added_succesfully() {
		Assert.assertTrue(emp.verify.isDisplayed());
		System.out.println("Employee Added Succesfully");
	}

	
	
}

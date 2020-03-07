package com.hrms.API.steps.practise;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import org.junit.Assert;

import com.hmrs.utils.CommonMethods;

public class CreateEmployeeAPISteps {
	
	private static RequestSpecification request;
	public Response response;
	
	@Given("user calls createEmployee API")
	public void user_calls_createEmployee_API() {
		response =given().contentType("application/json").headers("Authorization",SyntaxAPIAuthenticationSteps.Token)
		.body(CommonMethods.readJson("/Users/uddhabrijal/eclipse-workspace/HrmsCucumberFramework/src/test/resources/JsonFiles/CreateEmployee.json"))
		.when()
		.post("http://18.232.148.34/syntaxapi/api/createEmployee.php");
		
		response.prettyPrint();
		
	}

	@When("User retrive response")
	public void user_retrive_response() {
	    
		
		
	}

	@Then("status code is {int}")
	public void status_code_is(Integer int1) {
	   
		int statusCode =response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		System.out.println("status code is "+statusCode);
		
	}

	@Then("user validate employee is created")
	public void user_validate_employee_is_created() {
	    
		
		
	}

	
	

}

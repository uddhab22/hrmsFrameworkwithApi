package com.hrms.API.steps.practise;

import static io.restassured.RestAssured.given;

import com.hmrs.utils.APIConstants;
import com.hmrs.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class UpdateEmployee {
	
	public static Response response;
	public static Object EmployeeID;

	@Given("calls PutEmployee API")
	public void calls_PutEmployee_API() {
		response =given().contentType("application/json").headers("Authorization",SyntaxAPIAuthenticationSteps.Token)
				.body("{ \"employee_id\" : \"" + PostCreateEmployee.EmployeeID + "\"," +CommonMethods.readJson(APIConstants.Update_employee_json))
				.when()
				.put(APIConstants.UpdateEmployee_uri);
	   
	}

	@When("Retrive the response")
	public void retrive_the_response() {
		response.prettyPrint();
	    
	}

	@Then("status Code {int}")
	public void status_Code(Integer int1) {
		int statusCode =response.getStatusCode();
		response.then().assertThat().statusCode(int1);
			
		System.out.println("The Status code is "+statusCode);
	    
	}

	@Then("validate employee is updated")
	public void validate_employee_is_updated() {
	    
	}

	
	
	
}

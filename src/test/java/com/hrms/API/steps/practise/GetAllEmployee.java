package com.hrms.API.steps.practise;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.hmrs.utils.APIConstants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllEmployee {
	public static Response response;
	public static Object EmployeeID;
	
	@Given("calls get All Employee")
	public void calls_get_All_Employee() {
		
		response = given()
				.contentType("application/json")
				.headers("Authorization",SyntaxAPIAuthenticationSteps.Token)
				.when()
				.get(APIConstants.Get_all_employee_uri);

	   
	}

	@When("Retrive response fror allEmployee")
	public void retrive_response_fror_allEmployee() {
		response.prettyPrint();
	    
	}

	@Then("status Code {int} for all employee")
	public void status_Code_for_all_employee(Integer int1) {
		int statusCode =response.getStatusCode();
		response.then().assertThat().statusCode(int1);
			
		System.out.println("The Status code is "+statusCode);
	    
	}

	@Then("validate all employees are retrive")
	public void validate_all_employees_are_retrive() {
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		EmployeeID = jsonPathEvaluator.get("Employee[0].employee_id");
		response.then().body("Employee[0].employee_id", equalTo(EmployeeID));
	    
	}



}

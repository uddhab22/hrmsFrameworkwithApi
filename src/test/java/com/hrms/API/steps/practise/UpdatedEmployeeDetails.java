package com.hrms.API.steps.practise;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.hmrs.utils.APIConstants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdatedEmployeeDetails {
	public static Response response;
	public static Object EmployeeID;
	
	
	@Given("calls get UpdatedEmployee API")
	public void calls_get_UpdatedEmployee_API() {
		response = given()
				.contentType("application/json").param("employee_id",PostCreateEmployee.EmployeeID)
				.headers("Authorization",SyntaxAPIAuthenticationSteps.Token)
				
				.when()
				.get(APIConstants.get_emp_detail_uri);
		
	   
	}

	@When("Retrive the Response")
	public void retrive_the_Response() {
		response.prettyPrint();
	
	}

	@Then("The status Code is {int}")
	public void the_status_Code_is(Integer int1) {
		int statusCode =response.getStatusCode();
		response.then().assertThat().statusCode(int1);
			
		System.out.println("The Status code is "+statusCode);
	    
	
	}

	@Then("validate Updated employee is retrived")
	public void validate_Updated_employee_is_retrived() {
	    
		JsonPath jsonPathEvaluator = response.jsonPath();
		EmployeeID = jsonPathEvaluator.get("employee[0].employee_id");
		response.then().body("employee[0].employee_id", equalTo(EmployeeID));
		
		
	}



	

}

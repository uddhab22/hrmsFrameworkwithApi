package com.hrms.API.steps.practise;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.hmrs.utils.APIConstants;
import com.hmrs.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetEmployeeDetailsAPI {
	
	public static Response response;
	public static Object EmployeeID;
	
	
	@Given("calls getEmployee API")
	public void calls_getEmployee_API() {
		response = given()
				.contentType("application/json").param("employee_id",PostCreateEmployee.EmployeeID)
				.headers("Authorization",SyntaxAPIAuthenticationSteps.Token)
				
				.when()
				.get(APIConstants.get_emp_detail_uri);
		
	    
	}

	@When("Retrive response")
	public void retrive_response() {
		response.prettyPrint();
	    	}
	
	@Then("status Code {int} for")
	public void status_Code_for(Integer int1) {
		int statusCode =response.getStatusCode();
		response.then().assertThat().statusCode(int1);
			
		System.out.println("The Status code is "+statusCode);
	}


	@Then("validate employee is retrive")
	public void validate_employee_is_retrive() {
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		EmployeeID = jsonPathEvaluator.get("employee[0].employee_id");
		response.then().body("employee[0].employee_id", equalTo(EmployeeID));
		
	    
	}

}

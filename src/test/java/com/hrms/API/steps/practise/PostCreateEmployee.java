package com.hrms.API.steps.practise;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import com.hmrs.utils.APIConstants;
import com.hmrs.utils.CommonMethods;

import io.restassured.path.json.JsonPath;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.specification.RequestSpecification;

public class PostCreateEmployee {
	public Response response;
	public static Object EmployeeID;
	
	
	@Given("calls createEmployee API")
	public void calls_createEmployee_API() {
		response =given().contentType("application/json").headers("Authorization",SyntaxAPIAuthenticationSteps.Token)
				.body(CommonMethods.readJson(APIConstants.create_employee_json))
				.when()
				.post(APIConstants.createEmployee);
		
				
	}

	@When("retrive response")
	public void retrive_response() {
		response.prettyPrint();
	    
	}

	@Then("status code {int}")
	public void status_code(int int1) {
		int statusCode =response.getStatusCode();
		response.then().assertThat().statusCode(int1);
			
		System.out.println("The Status code is "+statusCode);
	
	    
	}

	@Then("validate employee is created")
	public void validate_employee_is_created() {
			response.then().body("Message", equalTo("Entry Created"));
			response.then().body("Employee[0].emp_firstname", equalTo("Matt6"));
		   
		  JsonPath jsonPathEvaluator = response.jsonPath();
		  EmployeeID = jsonPathEvaluator.get("Employee[0].employee_id");
		  System.out.println("Employee ID is: "+EmployeeID);
		
	}

}

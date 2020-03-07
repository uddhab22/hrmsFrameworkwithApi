package com.hrms.API.steps.practise;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.hmrs.utils.APIConstants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class DeleteEmployeeAPI {
	public static Response response;
	public static Object EmployeeID;
	
	@Given("calls delet Employee API")
	public void calls_delet_Employee_API() {
		response = given()
				.contentType("application/json").param("employee_id",PostCreateEmployee.EmployeeID)
				.headers("Authorization",SyntaxAPIAuthenticationSteps.Token)
				
				.when()
				.delete(APIConstants.delete_emp_uri);
		
	    
		
	}

	@When("Retrive delete employee Response")
	public void retrive_delete_employee_Response() {
		response.prettyPrint();
		
	   
	}

	@Then("The status Code {int} is displayed")
	public void the_status_Code_is_displayed(Integer int1) {
		int statusCode =response.getStatusCode();
		response.then().assertThat().statusCode(int1);
			
		System.out.println("The Status code is "+statusCode);
		
	}

	@Then("validate employee deleted successfully")
	public void validate_employee_deleted_successfully() {
		response.then().body("message", equalTo("Entry deleted"));
		
	}



	
	

}

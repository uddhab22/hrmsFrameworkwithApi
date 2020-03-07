package com.hrms.API.steps.practise;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import com.hmrs.utils.APIConstants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllEmploymentStatus {
	public static Response response;
	
	
	@Given("calls get All Employee Status")
	public void calls_get_All_Employee_Status() {
		response = given()
				.contentType("application/json")
				.headers("Authorization",SyntaxAPIAuthenticationSteps.Token)
				.when()
				.get(APIConstants.Get_all_Emp_status_uri);
	
	}

	@When("Retrive response fror Employee Status")
	public void retrive_response_fror_Employee_Status() {
		response.prettyPrint();
		
		
	}

	@Then("status Code {int} for all Employee Status")
	public void status_Code_for_all_Employee_Status(Integer int1) {
		int statusCode =response.getStatusCode();
		response.then().assertThat().statusCode(int1);
			
		System.out.println("The Status code is "+statusCode);
	    
		
		
	}

	@Then("validate all Employee Status  are retrive")
	public void validate_all_Employee_Status_are_retrive() {
		JSONObject json = new JSONObject(response.prettyPrint());
		JSONArray array = json.getJSONArray("Employee Status List");
		
		Assert.assertEquals("Freelance", array.get(4));
		Assert.assertEquals(12, array.length());
		System.out.println(array.length());
		
	   
	
	}



}

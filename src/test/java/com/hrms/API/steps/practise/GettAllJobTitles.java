package com.hrms.API.steps.practise;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import com.hmrs.utils.APIConstants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class GettAllJobTitles {
	public static Response response;
	
	@Given("calls get All Job Titles")
	public void calls_get_All_Job_Titles() {
		response = given()
				.contentType("application/json")
				.headers("Authorization",SyntaxAPIAuthenticationSteps.Token)
				.when()
				.get(APIConstants.Get_all_JobTitle_uri);
		
		
	    	}

	@When("Retrive response fror job Titles")
	public void retrive_response_fror_job_Titles() {
	   
		response.prettyPrint();
		
	}

	@Then("status Code {int} for all Job Titles")
	public void status_Code_for_all_Job_Titles(Integer int1) {
	    
		int statusCode =response.getStatusCode();
		response.then().assertThat().statusCode(int1);
			
		System.out.println("The Status code is "+statusCode);
	    
		
	}

	@Then("validate all job Titles are retrive")
	public void validate_all_job_Titles_are_retrive() {
		JSONObject json = new JSONObject(response.prettyPrint());
		JSONArray array = json.getJSONArray("Job Title List");
		
		Assert.assertEquals("Cloud Architect", array.get(0));
		Assert.assertEquals("Cloud Consultant", array.get(1));
		Assert.assertEquals(23, array.length());
		System.out.println(array.length());
		
	}


	

}

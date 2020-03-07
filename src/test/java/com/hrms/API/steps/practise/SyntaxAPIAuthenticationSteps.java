package com.hrms.API.steps.practise;

import com.hmrs.utils.APIConstants;
import com.hmrs.utils.CommonMethods;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import org.junit.Test;

public class SyntaxAPIAuthenticationSteps {
	
	private Response response;
	
	public static String Token;
	private static RequestSpecification request;
	
	
	
	@Given("user generate token")
	public void user_generate_token() {
		
		request = given().header("Content-Type","application/json");
		System.out.println(request.log().all());
		response =request.body(CommonMethods.readJson(APIConstants.generate_token_json))
		.when()
		.post(APIConstants.generateTokenURI);
		//System.out.println(response.prettyPrint());
		
		Token = "Bearer "+response.jsonPath().getString("token");
		
		System.out.println("The Token is ="+Token);
		System.out.println("==============================================================================================================================================================================");
	}
	
	

}

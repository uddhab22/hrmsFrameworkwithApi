package com.hrms.API.steps.practise;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.junit.Assert;
import org.junit.Test;

public class SampleApiTest {

	//@Test
	public void getAllJobTitle() {

		Response response = RestAssured.given().contentType("application/json").headers("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzEwNTMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjI1MywidXNlcklkIjoiODcifQ.Vo1YWz5DFNL2bpsW6qa7-SVd5lzs8sRpIGxsAzL-9so")

				.when().get("http://18.232.148.34/syntaxapi/api/jobTitle.php");

		response.prettyPrint();
		int actualResponseCode = response.getStatusCode();
		System.out.println("The Status Code is " + actualResponseCode);
		Assert.assertEquals(200, actualResponseCode);
		System.out.println("Test Pass");
		System.out.println("==============================================");
	}
	
	//@Test
	public void getAllEmployee() {
		Response response = RestAssured.given().contentType("application/json").headers("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzEwNTMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjI1MywidXNlcklkIjoiODcifQ.Vo1YWz5DFNL2bpsW6qa7-SVd5lzs8sRpIGxsAzL-9so")

				.when().get("http://18.232.148.34/syntaxapi/api/getAllEmployees.php");
	 
	 	response.prettyPrint();
	 	int actualResponseCode = response.getStatusCode();
		System.out.println("The Status Code is " + actualResponseCode);
		System.out.println("==============================================");

		
	}
	
	//@Test
	 public void getOneEmployee() {
		 Response response = RestAssured.given().param("employee_id", "3394").contentType("application/json").headers("Authorization",
					"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzEwNTMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjI1MywidXNlcklkIjoiODcifQ.Vo1YWz5DFNL2bpsW6qa7-SVd5lzs8sRpIGxsAzL-9so")

					.when().get("http://18.232.148.34/syntaxapi/api/getOneEmployee.php");
		 
		 	response.prettyPrint();
		 	int actualResponseCode = response.getStatusCode();
			System.out.println("The Status Code is " + actualResponseCode);
			System.out.println("==============================================");
	 }
	//@Test
	public void employeeStatus() {
		Response response = RestAssured.given().contentType("application/json").headers("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzEwNTMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjI1MywidXNlcklkIjoiODcifQ.Vo1YWz5DFNL2bpsW6qa7-SVd5lzs8sRpIGxsAzL-9so")

				.when().get("http://18.232.148.34/syntaxapi/api/employeeStatus.php");
	 
	 	response.prettyPrint();
	 	
	 	int actualResponseCode = response.getStatusCode();
		System.out.println("The Status Code is " + actualResponseCode);
		System.out.println("=========================================");
		
	}
	@Test
	public void createEmployee() {
		
		String requestBody = "{\n" + 
				"  \"emp_firstname\": \"Matt6\",\n" + 
				"  \"emp_lastname\": \"Brown\",\n" + 
				"  \"emp_middle_name\": \"\",\n" + 
				"  \"emp_gender\": \"1\",\n" + 
				"  \"emp_birthday\": \"1990-02-19\",\n" + 
				"  \"emp_status\": \"Employee\",\n" + 
				"  \"emp_job_title\": \"Developer\"\n" + 
				"}";
		Response response =RestAssured.given().contentType("application/json").headers("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzEwNTMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjI1MywidXNlcklkIjoiODcifQ.Vo1YWz5DFNL2bpsW6qa7-SVd5lzs8sRpIGxsAzL-9so")
		.body(requestBody)
		.when().post("http://18.232.148.34/syntaxapi/api/createEmployee.php");
		
		response.prettyPrint();
		int actualResponseCode = response.getStatusCode();
		System.out.println("The Status Code is " + actualResponseCode);
		Assert.assertEquals(200, actualResponseCode);
		System.out.println("Test Pass");
		
		
		
		
		
		
		
	}
	
}

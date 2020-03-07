package com.hmrs.utils;

import com.hrms.API.steps.practise.PostCreateEmployee;

public class APIConstants {
	
	public static final String generateTokenURI = "http://18.232.148.34/syntaxapi/api/generateToken.php";
	 
	public static final String createEmployee = "http://18.232.148.34/syntaxapi/api/createEmployee.php";
	
	public static final String get_emp_detail_uri = "http://18.232.148.34/syntaxapi/api/getOneEmployee.php";
	
	public static final String generate_token_json = System.getProperty("user.dir")+"/src/test/resources/JsonFiles/generateToken.json";

	public static final String create_employee_json = System.getProperty("user.dir")+"/src/test/resources/JsonFiles/CreateEmployee.json";
	
	public static final String UpdateEmployee_uri = "http://18.232.148.34/syntaxapi/api/updateEmployee.php";
	public static final String Update_employee_json = System.getProperty("user.dir")+"/src/test/resources/JsonFiles/UpdateEmployee.json";
	
	public static final String delete_emp_uri ="http://18.232.148.34/syntaxapi/api/deleteEmployee.php";
	
	public static final String Get_all_employee_uri="http://18.232.148.34/syntaxapi/api/getAllEmployees.php";
	
	public static final String Get_all_JobTitle_uri="http://18.232.148.34/syntaxapi/api/jobTitle.php";
	
	public static final String Get_all_Emp_status_uri="http://18.232.148.34/syntaxapi/api/employeeStatus.php";
	
	
	
	
}

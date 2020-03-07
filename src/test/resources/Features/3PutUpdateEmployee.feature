@APIEndtoEnd
Feature: Validating Syntax Hrms APIS
Background: 
Given user generate token
  
  
  Scenario: Retrive Employee with empID 
    Given calls PutEmployee API
    When Retrive the response
		Then status Code 200 
    Then validate employee is updated
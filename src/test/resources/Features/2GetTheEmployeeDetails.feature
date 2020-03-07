@APIEndtoEnd
Feature: Validating Syntax Hrms APIS
Background: 
Given user generate token
  
  
  Scenario: Retrive Employee with empID 
    Given calls getEmployee API
    When Retrive response
		Then status Code 200 for
    Then validate employee is retrive
  
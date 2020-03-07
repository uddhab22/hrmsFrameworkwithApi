@APIEndtoEnd
Feature: Validating Syntax Hrms APIS
Background: 
Given user generate token
  
  
  Scenario: Test Employee has been created Created
    Given calls createEmployee API
    When retrive response
		Then status code 200
    Then validate employee is created
  
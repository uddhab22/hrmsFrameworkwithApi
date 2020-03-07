
Feature: Validating Syntax Hrms APIS
Background: 
Given user generate token
  
  
  Scenario: Test Employee is Created
    Given user calls createEmployee API
    When User retrive response
		Then status code is 200
    Then user validate employee is created
  
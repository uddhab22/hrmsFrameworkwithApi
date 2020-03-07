@APIEndtoEnd
Feature: Validating Syntax Hrms APIS
Background: 
Given user generate token
  
  
  Scenario: Retrive All Employee 
    Given calls get All Employee 
    When Retrive response fror allEmployee
		Then status Code 200 for all employee
    Then validate all employees are retrive
  
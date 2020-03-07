@APIEndtoEnd
Feature: Validating Syntax Hrms APIS
Background: 
Given user generate token
  
  
  Scenario: Retrive All Employee Status 
    Given calls get All Employee Status 
    When Retrive response fror Employee Status 
		Then status Code 200 for all Employee Status 
    Then validate all Employee Status  are retrive
  
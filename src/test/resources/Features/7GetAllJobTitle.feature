@APIEndtoEnd
Feature: Validating Syntax Hrms APIS
Background: 
Given user generate token
  
  
  Scenario: Retrive All Job Title 
    Given calls get All Job Titles 
    When Retrive response fror job Titles
		Then status Code 200 for all Job Titles
    Then validate all job Titles are retrive
  
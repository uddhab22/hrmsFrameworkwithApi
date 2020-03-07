@APIEndtoEnd
Feature: Validating Syntax Hrms APIS
Background: 
Given user generate token
  
  
  Scenario: Retrive Updated Employee 
    Given calls get UpdatedEmployee API
    When Retrive the Response
		Then The status Code is 200 
    Then validate Updated employee is retrived
  
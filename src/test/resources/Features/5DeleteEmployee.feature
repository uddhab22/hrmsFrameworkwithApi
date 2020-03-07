@APIEndtoEnd
Feature: Validating Syntax Hrms APIS
Background: 
Given user generate token
  
  
  Scenario: Delete  Employee 
    Given calls delet Employee API
    When Retrive delete employee Response
		Then The status Code 200 is displayed
    Then validate employee deleted successfully
  
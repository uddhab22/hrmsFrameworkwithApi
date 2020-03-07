@addemployee
Feature: Add employee

 @Smoke
  Scenario Outline: add valid employee details
    Given I am logged in to HRMS
    When I navigate to add employee
    When I added "<name>", middle and "<last>"
    And I clicked save
    Then Employee added succesfully

    Examples: 
      | name   | last    |
      | john12 | smith12 |
      | john22 | smith22 |
			| john12 | smith12 |
      | john22 | smith22 |
			| john12 | smith12 |
      | john22 | smith22 |
			
@sprint1 @login
Feature: Login

  @smoke
  Scenario: Valid Login
    Given I open browser and navigate to HRMS
    When I enter valid username and valid password
    And I clicked on login Button
    Then I succefully logged in
    Then I close browser


  @regression
  Scenario: Invalid Login
    Given I open browser and navigate to HRMS
    When I enter valid usernam and invalid password
    And I clicked on login Button
    Then I see error message
    And I close browser
    
	@regression
  Scenario Outline: Invalid login and message validation
    When I enter "<username>" and "<password>"
    And I clicked on login Button
    Then I see "<error Message>"

    Examples: 
      | username | password   | error Message            |
      | Admin    | Syntax123  | Invalid credentials      |
      | Admin    |            | Password cannot be empty |
      |          | Syntax@123 | Username cannot be empty |
      |          |            | Username cannot be empty |

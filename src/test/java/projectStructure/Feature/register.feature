Feature: Registration

  @register
  Scenario: User registers with valid details
    Given I open the browser
    When I navigate to the registration page
    And I click on the register button
    And I enter valid registration details
    Then I submit the registration form

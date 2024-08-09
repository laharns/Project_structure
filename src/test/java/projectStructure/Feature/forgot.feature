Feature: Forgot

  @forgot
  Scenario: User Forgot with valid details
    Given I forgot open the browser
    When I navigate to the forgot page
    And I click on the forgot button
    And I enter valid forgot details
    Then I submit the Forgot form



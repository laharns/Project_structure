Feature: Login

  @login
  Scenario: User logs in with valid credentials
    Given I navigate to the login page
    When I login with username and password
    Then I should see the homepage

  @logindyna
  Scenario Outline: User logs in with valid credentials
    Given I navigate to the login page
    When I login with username <email> and password <pass>
    Then I should see the homepage
    Examples:
    |email|pass|
    |  username   | password   |
    |  username_1   |  password_1  |